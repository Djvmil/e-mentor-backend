package org.djvmil.em.backend.api;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.service.UserService;
import org.djvmil.em.backend.exceptions.UserNotFoundException;
import org.djvmil.em.backend.payloads.LoginCredentials;
import org.djvmil.em.backend.payloads.RegisterRequest;
import org.djvmil.em.backend.payloads.AuthResponse;
import org.djvmil.em.backend.security.JWTUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "E-Mentor Application")
public class AuthRessource {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public AuthResponse registerHandler(@Valid @RequestBody RegisterRequest user) throws UserNotFoundException {

        UserDto userDTO = userService.registerUser(modelMapper.map(user, UserDto.class));

        String token = jwtUtil.generateToken(userDTO.getEmail());

        return new AuthResponse(
                token,
                userDTO
        );
       // return new ResponseEntity<Map<String, Object>>(Collections.singletonMap("jwt-token", token), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public AuthResponse loginHandler(@Valid @RequestBody LoginCredentials credentials) {

        UsernamePasswordAuthenticationToken authCredentials = new UsernamePasswordAuthenticationToken(
                credentials.getEmail(), credentials.getPassword());

        authenticationManager.authenticate(authCredentials);
        String token = jwtUtil.generateToken(credentials.getEmail());

        UserDto userDto = userService.getByEmail(credentials.getEmail());

        return new AuthResponse(
                token,
                userDto
        );
    }
}