package com.example.OSAProjekat.security;

import java.util.List;

public class JWTResponse {

private static final long serialVersionUID = -8091879091924046844L;
	
	private String token;
	
	private String type = "Bearer";
	
	private String username;

	public JWTResponse(String accessToken,String username) {
		this.token = accessToken;
		this.username = username;
		
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
