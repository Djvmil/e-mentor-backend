package org.djvmil.em.backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.djvmil.em.backend.config.ErrorResponse;
import org.djvmil.em.backend.payloads.APIErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class JWTFilter extends OncePerRequestFilter {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private EMUserDetailsService userDetailsServiceImpl;

	APIErrorResponse errorDetails;
	@Autowired
	private ObjectMapper mapper;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

			String authHeader = request.getHeader("Authorization");
			String token = null;
			String username = null;

		try {
			if(authHeader != null && authHeader.startsWith("Bearer ")){
				token = authHeader.substring(7);
				username = jwtService.extractUsername(token);
			}

			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
				UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
				if(jwtService.validateToken(token, userDetails)){
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					if (SecurityContextHolder.getContext().getAuthentication() == null) {
						SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					}
				}
			}

		}catch (Exception exception){
			errorDetails = new APIErrorResponse(HttpStatus.UNAUTHORIZED, "Authentication Error");
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);

			mapper.writeValue(response.getWriter(), errorDetails);
		}

		filterChain.doFilter(request, response);
	}
}