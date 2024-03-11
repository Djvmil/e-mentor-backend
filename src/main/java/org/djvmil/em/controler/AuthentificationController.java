package org.djvmil.em.controler;

import org.djvmil.em.entity.User;
import org.djvmil.em.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    /*@RequestMapping("/home")
    public String homePage(HttpServletRequest request){
        System.out.println("Tentative d'affichage de home");
        List<User> users = service.list();
        request.setAttribute("users", users);
        return "home";
    }

    @RequestMapping("/home")
    public List<User> homePage(){
        System.out.println("Tentative d'affichage de home");
        List<User> users = service.list();

        return users;
    }*/

    @RequestMapping("/home")
    public @ModelAttribute("usersAtr") List<User> homePage(){
        System.out.println("Tentative d'affichage de home");
        List<User> users = service.list();

        return users;
    }
}
