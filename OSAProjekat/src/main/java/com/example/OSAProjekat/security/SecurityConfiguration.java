package com.example.OSAProjekat.security;

import javax.ws.rs.HttpMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    public void configureAuthentication(
            AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {

        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean()
            throws Exception {
        AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
        authenticationTokenFilter
                .setAuthenticationManager(authenticationManagerBean());
        return authenticationTokenFilter;
    }
    
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        //Naglasavamo browser-u da ne cache-ira podatke koje dobije u header-ima
        //detaljnije: https://www.baeldung.com/spring-security-cache-control-headers
        httpSecurity.headers().cacheControl().disable();
        //Neophodno da ne bi proveravali autentifikaciju kod Preflight zahteva
        httpSecurity.cors();
        //sledeca linija je neophodna iskljucivo zbog nacina na koji h2 konzola komunicira sa aplikacijom
        //Greota obrisati
        httpSecurity.headers().frameOptions().disable();
        httpSecurity.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //.antMatchers("/h2-console/**").permitAll()
                //.antMatchers(HttpMethod.GET, "/api/artikli/**").hasAnyRole("KUPAC", "PRODAVAC", "ADMINISTRATOR")          
                //.antMatchers(HttpMethod.POST, "/api/artikli").hasRole("PRODAVAC")OVO TREA  
                .antMatchers(HttpMethod.POST, "/api/artikli").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/artikli/**").hasRole("PRODAVAC")//OVO TREBA
                //.antMatchers(HttpMethod.PUT, "/api/artikli/**").hasRole("PRODAVAC")OVO TREA
                .antMatchers(HttpMethod.DELETE, "/api/artikli/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/artikli/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/korisnici/login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/korisnici/login2").permitAll()

                
                .antMatchers(HttpMethod.POST, "/api/korisnici").permitAll()
                .antMatchers(HttpMethod.POST, "/api/korisnici/prodavac").permitAll()
                .antMatchers(HttpMethod.POST, "/api/korisnici/administrator").permitAll()
                .antMatchers(HttpMethod.POST, "/api/korisnici/kupac").permitAll()
                .antMatchers(HttpMethod.POST, "/api/korisnici/prodavacc").permitAll()
                
                .antMatchers(HttpMethod.POST, "/porudzbinee").permitAll()
                .antMatchers(HttpMethod.POST, "/porudzbinee/**").permitAll()
                .antMatchers(HttpMethod.POST, "/artiklii/**").permitAll()
                .antMatchers(HttpMethod.POST, "/artikli7").permitAll()

                .antMatchers(HttpMethod.GET, "/artiklii/**").permitAll()
        
                .antMatchers(HttpMethod.POST, "/artikli7/**").permitAll()
                .antMatchers(HttpMethod.GET, "/artikli7/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/artikli7/**").permitAll()

                .antMatchers(HttpMethod.GET, "/porudzbine7/**").permitAll()
                .antMatchers(HttpMethod.POST, "/porudzbine7/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/porudzbine7/**").permitAll()
                
                .antMatchers(HttpMethod.GET, "/porudzbine4/**").permitAll()
                .antMatchers(HttpMethod.POST, "/porudzbine4/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/porudzbine4/**").permitAll()

                
                .antMatchers(HttpMethod.GET, "/api/artikli/**").permitAll()          
                .antMatchers(HttpMethod.GET, "/api/prodavci").permitAll()
                .antMatchers(HttpMethod.GET, "/api/korisnici/**").permitAll()          
                .antMatchers(HttpMethod.GET, "/api/porudzbine/**").permitAll()
                
                .antMatchers(HttpMethod.GET, "/api/prodavci/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/kupci/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/kupci/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/stavke/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/stavke/**").permitAll()


                .antMatchers(HttpMethod.PUT, "/api/korisnici/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/korisnici/username/**").permitAll()          
                .antMatchers(HttpMethod.GET, "/api/kupci").permitAll()
                .antMatchers(HttpMethod.GET, "/api/porudzbine").permitAll()
                .antMatchers(HttpMethod.GET, "/api/admini").permitAll()
                .antMatchers(HttpMethod.GET, "/api/korisnici").permitAll()
                .antMatchers(HttpMethod.GET, "/api/korisnici/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/artikli").permitAll()             

                .anyRequest().authenticated();

        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }
    
    
}
