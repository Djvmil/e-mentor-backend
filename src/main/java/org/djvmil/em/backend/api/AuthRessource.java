package org.djvmil.em.backend.api;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.helpers.Helper;
import org.djvmil.em.backend.core.service.UserService;
import org.djvmil.em.backend.exceptions.UserNotFoundException;
import org.djvmil.em.backend.payloads.AuthRequest;
import org.djvmil.em.backend.payloads.AuthResponse;
import org.djvmil.em.backend.payloads.RoleRequest;
import org.djvmil.em.backend.security.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@SecurityRequirement(name = "E-Mentor Application")
public class AuthRessource {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public AuthResponse registerHandler(@Valid @RequestBody AuthRequest user) throws UserNotFoundException {

        UserDto userDTO = userService.registerUser(modelMapper.map(user, UserDto.class));
        //UsernamePasswordAuthenticationToken authCredentials = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword());

        userDTO.setUsername(user.getEmail());
        return AuthResponse.builder()
                .accesToken(jwtService.GenerateToken(userDTO.getEmail()))
                .user(userDTO).build();
    }


    @PostMapping("/add-role")
    public RoleRequest addRoleToUser(@Valid @RequestBody RoleRequest roleRequest) throws UserNotFoundException {
        roleRequest.getRoles().forEach( role ->
            userService.addRoleToUser(roleRequest.getEmail(), role)
        );

        return roleRequest;
    }

    @PostMapping("/login")
    public AuthResponse loginHandler(@RequestBody AuthRequest credentials) throws UserNotFoundException {
        UserDto userDto = userService.getUser(credentials.getUsername());

        System.out.println("userDto find: "+ userDto);

        if (userDto != null){
            UsernamePasswordAuthenticationToken authCredentials =
                    new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());

            authenticationManager.authenticate(authCredentials);

        }else throw new UserNotFoundException("User with this username does't exist");

        System.out.println("userDto find 2: "+ userDto);

        return AuthResponse.builder()
                .accesToken(jwtService.GenerateToken(userDto.getEmail()))
                .user(userDto).build();
    }

}