package org.djvmil.em.backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.djvmil.em.backend.core.dto.UserDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter( AuthenticationManager authManager ) {
        super();
        this.authenticationManager = authManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UserDto userDto;
        try {
            userDto = new ObjectMapper().readValue(request.getInputStream(), UserDto.class);


        } catch (JsonParseException | JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {

        User user = (User) authResult.getPrincipal();

        List<String> roles = new ArrayList<>();

        user.getAuthorities().forEach(auth -> roles.add(auth.getAuthority()));

        String jwt = JWT.create()
                .withSubject(user.getUsername())
                .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis() + (10 * 24 * 60 * 60 * 1000)))
                .sign(Algorithm.HMAC256("EM-Backend-2024"));

        System.out.println("except 4");

        response.addHeader("Authorization", jwt);

        //super.successfulAuthentication(request, response, chain, authResult);
    }


}
