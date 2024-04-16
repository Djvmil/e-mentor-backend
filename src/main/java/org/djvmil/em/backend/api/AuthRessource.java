package org.djvmil.em.backend.api;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.helpers.Helper;
import org.djvmil.em.backend.core.service.UserService;
import org.djvmil.em.backend.exceptions.UserNotFoundException;
import org.djvmil.em.backend.exceptions.UserRegistrationException;
import org.djvmil.em.backend.payloads.APIResponse;
import org.djvmil.em.backend.payloads.AuthRequest;
import org.djvmil.em.backend.payloads.AuthResponse;
import org.djvmil.em.backend.payloads.RoleRequest;
import org.djvmil.em.backend.security.EMUserDetailsService;
import org.djvmil.em.backend.security.JwtService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@SecurityRequirement(name = "E-Mentor Application")
public class AuthRessource {

    private static final Logger logger = LoggerFactory.getLogger(AuthRessource.class);
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public APIResponse<String> registerHandler(@Valid @RequestBody AuthRequest user) throws UserRegistrationException {
        try {
            logger.debug("registerHandler 1 user: ", user);
            UserDto userDto = userService.registerUser(modelMapper.map(user, UserDto.class));
            logger.debug("registerHandler 2 user: ", user);

        }catch (Exception ex){
            ex.printStackTrace();
            logger.debug("registerHandler: ", ex);
            if (ex instanceof UserRegistrationException exception)
                throw new UserRegistrationException(exception.getMessage());
            else
                throw new UserRegistrationException(ex.getMessage());
        }

        System.out.println("registerHandler -----------");
        return new APIResponse<>(HttpStatus.OK, "Success Registration");
    }


    @PostMapping("/add-role")
    public RoleRequest addRoleToUser(@Valid @RequestBody RoleRequest roleRequest) throws UserNotFoundException {
        roleRequest.getRoles().forEach( role ->
            userService.addRoleToUser(roleRequest.getEmail(), role)
        );

        return roleRequest;
    }

    @PostMapping("/login")
    public APIResponse<AuthResponse> loginHandler(@RequestBody AuthRequest credentials) throws UserNotFoundException {
        UserDto userDto;
        try {
            userDto = userService.getUser(credentials.getUsername());
            if (userDto != null){
                UsernamePasswordAuthenticationToken authCredentials =
                        new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
                authenticationManager.authenticate(authCredentials);

            } else throw new UserNotFoundException("Username or password doesn't exist");

        }catch (Exception ex){
            throw new UserNotFoundException("Username or password doesn't exist");
        }

        APIResponse<AuthResponse> response =  new APIResponse<>(HttpStatus.OK, "Success Login");
        response.setData(AuthResponse.builder()
                .accesToken(jwtService.GenerateToken(userDto.getEmail()))
                .user(userDto).build());

        return response;
    }

}