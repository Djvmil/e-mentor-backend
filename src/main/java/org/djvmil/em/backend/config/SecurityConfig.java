package org.djvmil.em.backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.djvmil.em.backend.security.JWTFilter;
import org.djvmil.em.backend.exceptions.AccessDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	DaoAuthenticationProvider authenticationProvider;

	@Autowired
	private JWTFilter jwtFilter;

	@Autowired
	private ObjectMapper mapper;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.sessionManagement(session ->
						session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf(AbstractHttpConfigurer::disable)
				.cors(cors -> new CorsConfigurationSource() {

					@Override
					public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
						CorsConfiguration corsConf = new CorsConfiguration();

						corsConf.setAllowedOrigins(Arrays.asList("http://localhost:4200/", "*******"));
						corsConf.setAllowedHeaders(Collections.singletonList("Authorization"));
						corsConf.setAllowedHeaders(Collections.singletonList("*"));
						corsConf.setAllowedMethods(Collections.singletonList("*"));
						corsConf.setMaxAge(3600L);
						corsConf.setAllowCredentials(true);
						return corsConf;
					}
				})
				.authorizeHttpRequests( requests ->
						requests.requestMatchers(AppConstants.PUBLIC_URLS).permitAll()
								.requestMatchers(AppConstants.USER_URLS).hasAnyAuthority("USER", "ADMIN")
								.requestMatchers(AppConstants.ADMIN_URLS).hasAuthority("ADMIN")
								.anyRequest().authenticated()
				)
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling(handling -> handling.authenticationEntryPoint(
						(request, response, authException) ->
								response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
				)).authenticationProvider(authenticationProvider);

		return http.build();
	}

}