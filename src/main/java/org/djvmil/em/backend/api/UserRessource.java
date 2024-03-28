package org.djvmil.em.backend.api;

import org.djvmil.em.backend.core.entity.User;
import org.djvmil.em.backend.core.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserRessource {

    @Autowired // like @Inject or @Ressource in JEE
    private AuthService service;

    @PostMapping
    public User create(@RequestBody User user){

        return service.register(user);
    }

    @GetMapping
    public Iterable<User> getUsers(){

        return service.list();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long userId){

        return service.getById(userId);
    }

}
