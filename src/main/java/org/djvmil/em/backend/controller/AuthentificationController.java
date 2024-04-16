package org.djvmil.em.backend.controller;

import jakarta.validation.Valid;
import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.service.UserService;
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
    private UserService service;


    public UserDto login(String login, String password){

        return service.login(login, password);
    }

    public UserDto register(UserDto user){

        return service.create(user);
    }

    @GetMapping
    public String  homePage(Model model){
        Iterable<UserDto> users = service.allUsers();
        model.addAttribute("usersAtr", users);

        return "home";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long userId, Model model){
        UserDto user = service.getById(userId);
        model.addAttribute("user", user);

        return "user-detail";
    }

    @GetMapping("add")
    public String addUser(@ModelAttribute UserForm user){

        return "add-user";
    }

    //@RequestMapping(value = "", method = RequestMethod.POST)
    @PostMapping
    //public String addUser(User userAtt, Model model){
    public String addUser(@Valid @ModelAttribute UserForm userAtt, BindingResult bindingResult, Model model){
    //public String addUser(@ModelAttribute("userForm") User userAtt, Model model){

        if (bindingResult.hasErrors())
            return "add-user";

        UserDto user = new UserDto();
        user.setUserID(123L);
        user.setFirstname(userAtt.getFirstname());
        user.setLastname(userAtt.getLastname());
        user.setEmail(userAtt.getEmail());

        model.addAttribute("user", userAtt);

        service.create(user);

        return "result-add-user";
    }

}
