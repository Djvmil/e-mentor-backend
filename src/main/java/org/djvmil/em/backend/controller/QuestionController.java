package org.djvmil.em.backend.controller;

import jakarta.validation.Valid;
import org.djvmil.em.backend.core.entity.Question;
import org.djvmil.em.backend.core.entity.User;
import org.djvmil.em.backend.core.service.QuestionService;
import org.djvmil.em.backend.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping
    public String  list(Model model){
        Iterable<Question> questions = service.list();
        model.addAttribute("questions", questions);

        return "home";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long questionId, Model model){
        System.out.println("Tentative d'affichage de home");
        Question question = service.findById(questionId);
        model.addAttribute("question", question);

        return "user-detail";
    }

    @GetMapping("add")
    public String addUser(@ModelAttribute UserForm user){
        System.out.println("Tentative d'affichage de GetMapping = "+user.formatToDB());

        return "add-user";
    }

    @PostMapping
    public String addUser(@Valid @ModelAttribute UserForm userAtt, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors())
            return "add-user";

        User user = new User();
        user.setId(123L);
        user.setFirstname(userAtt.getFirstname());
        user.setLastname(userAtt.getLastname());
        user.setEmail(userAtt.getEmail());

        model.addAttribute("user", userAtt);

       // service.save(user);

        return "result-add-user";
    }

}
