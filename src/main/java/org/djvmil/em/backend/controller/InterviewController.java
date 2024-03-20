package org.djvmil.em.backend.controller;

import jakarta.validation.Valid;
import org.djvmil.em.backend.core.entity.Interview;
import org.djvmil.em.backend.core.entity.Question;
import org.djvmil.em.backend.core.entity.Response;
import org.djvmil.em.backend.core.entity.User;
import org.djvmil.em.backend.core.service.InterviewService;
import org.djvmil.em.backend.core.service.ResponseService;
import org.djvmil.em.backend.form.InterviewForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService service;

    @Autowired
    private ResponseService responseService;

    @GetMapping
    public String  list(){

        return "interview-page";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long interviewId, Model model){
        Interview interview = service.findById(interviewId);
        model.addAttribute("interview", interview);

        return "user-detail";
    }

    @GetMapping("/create")
    public String addUser(@ModelAttribute InterviewForm interviewForm){

        return "create-interview";
    }

    @PostMapping
    public String addInterview(@Valid @ModelAttribute InterviewForm interviewForm, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors())
            return "create-interview";

        Response response = new Response();

        User user = new User();
        user.setFirstname(interviewForm.getFirstname());
        user.setLastname(interviewForm.getLastname());
        user.setGenre(interviewForm.getGenre());
        user.setEmail(interviewForm.getEmail());

        response.setUser(user);

        Question question = new Question();
        question.setQuestionText(interviewForm.getQuestionText());
        question.setQuestionType(interviewForm.getQuestionType());

        response.setQuestion(question);

        Interview interview = new Interview();
        interview.setCompany(interviewForm.getCompany());
        interview.setDescription(interviewForm.getDescription());
        interview.setTitle(interviewForm.getTitle());
        interview.setRequiredSkills(interviewForm.getRequiredSkills());
        response.setInterview(interview);

        response.setResponseText(interviewForm.getResponseText());
        response.setScore(interviewForm.getScore());

        responseService.save(response);

        return "interview-page";
    }

}
