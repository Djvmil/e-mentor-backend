package org.djvmil.em.backend.controller;

import jakarta.validation.Valid;
import org.djvmil.em.backend.core.dto.InterviewDto;
import org.djvmil.em.backend.core.dto.QuestionDto;
import org.djvmil.em.backend.core.dto.ResponseDto;
import org.djvmil.em.backend.core.dto.UserDto;
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
        InterviewDto interview = service.findById(interviewId);
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

        ResponseDto responseDto = new ResponseDto();

        UserDto userDto = new UserDto();
        userDto.setFirstname(interviewForm.getFirstname());
        userDto.setLastname(interviewForm.getLastname());
        userDto.setGenre(interviewForm.getGenre());
        userDto.setEmail(interviewForm.getEmail());

        responseDto.setUserDto(userDto);

        QuestionDto question = new QuestionDto();
        question.setQuestionText(interviewForm.getQuestionText());
        question.setQuestionType(interviewForm.getQuestionType());

        responseDto.setQuestionDto(question);

        InterviewDto interviewDto = new InterviewDto();
        interviewDto.setCompany(interviewForm.getCompany());
        interviewDto.setDescription(interviewForm.getDescription());
        interviewDto.setTitle(interviewForm.getTitle());
        interviewDto.setRequiredSkills(interviewForm.getRequiredSkills());
        responseDto.setInterviewDto(interviewDto);

        responseDto.setResponseText(interviewForm.getResponseText());
        responseDto.setScore(interviewForm.getScore());

        responseService.save(responseDto);

        return "interview-page";
    }

}
