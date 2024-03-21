package org.djvmil.em.backend.controller;

import jakarta.validation.Valid;
import org.djvmil.em.backend.core.entity.User;
import org.djvmil.em.backend.core.service.AuthService;
import org.djvmil.em.backend.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthentificationController {

    @Autowired // like @Inject or @Ressource in JEE
    private AuthService service;


    public User login(String login, String password){

        return service.login(login, password);
    }

    public User register(User user){

        return service.register(user);
    }

    @GetMapping
    public String  homePage(Model model){
        System.out.println("Tentative d'affichage de home");
        Iterable<User> users = service.list();
        model.addAttribute("usersAtr", users);

        return "home";
    }

    //@RequestMapping("/{id}")
    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long userId, Model model){
        System.out.println("Tentative d'affichage de home");
        User user = service.getById(userId);
        model.addAttribute("user", user);

        return "user-detail";
    }

    @GetMapping("add")
    public String addUser(@ModelAttribute UserForm user){
        System.out.println("Tentative d'affichage de GetMapping = "+user.formatToDB());

        return "add-user";
    }

    //@RequestMapping(value = "", method = RequestMethod.POST)
    @PostMapping
    //public String addUser(User userAtt, Model model){
    public String addUser(@Valid @ModelAttribute UserForm userAtt, BindingResult bindingResult, Model model){
    //public String addUser(@ModelAttribute("userForm") User userAtt, Model model){

        System.out.println("Tentative d'affichage de PostMapping = "+userAtt.formatToDB());
        if (bindingResult.hasErrors())
            return "add-user";

        User user = new User();
        user.setUserID(123L);
        user.setFirstname(userAtt.getFirstname());
        user.setLastname(userAtt.getLastname());
        user.setEmail(userAtt.getEmail());

        model.addAttribute("user", userAtt);

        service.register(user);

        return "result-add-user";
    }

}
