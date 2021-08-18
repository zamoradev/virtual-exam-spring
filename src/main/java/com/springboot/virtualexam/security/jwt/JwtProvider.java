package com.springboot.virtualexam.security.jwt;

import java.util.Date;
import java.util.stream.Collectors;

import com.springboot.virtualexam.security.data.PrimaryUser;
import com.springboot.virtualexam.util.DateManipulation;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtProvider {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private int expiration;
	
	public String generateToken(Authentication authentication) {
		PrimaryUser mainUser = (PrimaryUser) authentication.getPrincipal();
		String username = mainUser.getUsername();
		String rol = mainUser.getAuthorities().stream()
												.map(GrantedAuthority::getAuthority)
												.collect(Collectors.joining(","));
		Date dateCreated = new Date();
		Date timeExpired = DateManipulation.timeExpired(dateCreated, expiration);
		SignatureAlgorithm algorithmType = SignatureAlgorithm.HS512;
		
		return Jwts.builder().setSubject(username)
				.claim("rol", rol)
				.setIssuedAt(dateCreated)
				.setExpiration(timeExpired)
				.signWith(algorithmType, secret.getBytes())
				.compact();
	}
	
	public String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(secret.getBytes())
				            .parseClaimsJws(token)
				            .getBody()
				            .getSubject();
	}
	
	public boolean validationToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret.getBytes())
						 .parseClaimsJws(token);
			
			return true;
		}catch(MalformedJwtException e) {
			log.error("Mal formato del token");
		}catch(UnsupportedJwtException e) {
			log.error("Token no soportado");
		}catch(ExpiredJwtException e) {
			log.error("Token expirado");
		}catch(IllegalArgumentException e) {
			log.error("Token vacío");
		}catch(SignatureException e) {
			log.error("Firma inválida");
		}
		
		return false;
	}
}
