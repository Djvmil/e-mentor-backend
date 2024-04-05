package org.djvmil.em.backend.api;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.djvmil.em.backend.core.dto.InterviewDto;
import org.djvmil.em.backend.core.entity.Interview;
import org.djvmil.em.backend.core.service.InterviewService;
import org.djvmil.em.backend.form.InterviewForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
@CrossOrigin("*")
@SecurityRequirement(name = "E-Mentor Application")
public class InterviewRessource {

    @Autowired
    private InterviewService service;

    @GetMapping
    public List<InterviewDto> list(){

        return service.list();
    }

    @GetMapping("/{id}")
    public InterviewDto findById(@PathVariable("id") Long interviewId){

        return service.findById(interviewId);
    }

    @PostMapping
    public InterviewForm addUser(@Valid @ModelAttribute InterviewForm interviewForm, BindingResult bindingResult){

        return interviewForm;
    }

}
