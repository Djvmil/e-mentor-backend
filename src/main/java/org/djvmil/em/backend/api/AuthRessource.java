package org.djvmil.em.backend.api;



import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.service.UserService;
import org.djvmil.em.backend.exceptions.UserNotFoundException;
import org.djvmil.em.backend.payloads.LoginCredentials;
import org.djvmil.em.backend.security.test.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "E-Mentor Application")
public class AuthRessource {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerHandler(@Valid @RequestBody UserDto user) throws UserNotFoundException {
        String encodedPass = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPass);

        //UserDto userDTO = userService.registerUser(user);
        UserDto userDTO = new UserDto();

        String token = jwtUtil.generateToken(userDTO.getEmail());

        return new ResponseEntity<Map<String, Object>>(Collections.singletonMap("jwt-token", token),
                HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public Map<String, Object> loginHandler(@Valid @RequestBody LoginCredentials credentials) {

        System.out.println("LoginCredentials: "+credentials.toString());

        UsernamePasswordAuthenticationToken authCredentials = new UsernamePasswordAuthenticationToken(
                credentials.getEmail(), credentials.getPassword());

        System.out.println("LoginCredentials 1: "+credentials.toString());
        authenticationManager.authenticate(authCredentials);

        System.out.println("LoginCredentials 2: "+credentials.toString());
        String token = jwtUtil.generateToken(credentials.getEmail());
        System.out.println("LoginCredentials 3: "+credentials.toString());
        System.out.println("LoginCredentials 4: "+token);

        return Collections.singletonMap("jwt-token", token);
    }
}