package org.djvmil.em.backend.api;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
@SecurityRequirement(name = "E-Mentor Application")
public class UserRessource {

    @Autowired // like @Inject or @Ressource in JEE
    private UserService service;

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto){

        return service.create(userDto);
    }

    @GetMapping
    public Iterable<UserDto> getUsers(){

        return service.allUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Long userId){

        return service.getById(userId);
    }

}
