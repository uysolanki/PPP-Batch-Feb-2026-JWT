package com.itp.pppjwt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AuthenticationResponse {

	private final String jwt;
	
//	public AuthenticationResponse(String jwt)
//	{
//		this.jwt=jwt;
//	}
	
	

}
