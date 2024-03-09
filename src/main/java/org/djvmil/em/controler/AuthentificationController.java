package org.djvmil.em.controler;

import org.djvmil.em.entity.User;
import org.djvmil.em.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
//@Component
public class AuthentificationController {

    @Autowired // like @Inject or @Ressource in JEE
    private AuthentificationService service;


    public User login(String login, String password){

        return service.login(login, password);
    }

    public Boolean register(User user){

        return service.register(user);
    }
}
