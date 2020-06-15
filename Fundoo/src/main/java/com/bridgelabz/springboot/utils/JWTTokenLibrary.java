package com.bridgelabz.springboot.utils;

import org.springframework.stereotype.Component;


@Component
public class JWTTokenLibrary {
	
	private final String TOKEN_SECRET_CODE = "fundoo";
	
	public String newToken(long id) {
		String newToken = null;
		
		newToken = JWT.create().withClaim("userId", id).sign(Algorithm.HMAC256(TOKEN_SECRET_CODE));
	}
	
	public Long tokenDecoder(String token) {
		Long userId = 0l;
		try {
		Verification verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET_CODE));
		JWTVerifier jwtVerifier = verification.build();
		DecodedJWT decodeJWT = jwtVerifier.verify(token);
		Claim claim = decodeJWT.getClaim("userId");
		userId = claim.asLong();
		}catch(JWTCreationException e | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return userId;
	}
}
