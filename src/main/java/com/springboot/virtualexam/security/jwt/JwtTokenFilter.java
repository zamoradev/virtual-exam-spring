package com.springboot.virtualexam.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;


@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter{

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private UserDetailsService userDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
		try {
			String token = this.getToken(request);
			this.assigningTokenData(token);
		}catch(Exception e) {
			log.error("El método dofilter ha fallado " + e.getMessage());
		}

		filterChain.doFilter(request, response);
	}

	private String getToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		
		return (header != null && header.startsWith("Bearer")) ? header.replace("Bearer ", ""): null;
	}
	
	private void assigningTokenData(String token) {
		if(token != null && jwtProvider.validationToken(token)) {
			String username = jwtProvider.getUsernameFromToken(token);
			UserDetails userDetails = userDetailService.loadUserByUsername(username);
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
	}
}
