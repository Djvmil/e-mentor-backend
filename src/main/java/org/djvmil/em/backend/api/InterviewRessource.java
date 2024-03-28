package org.djvmil.em.backend.api;

import jakarta.validation.Valid;
import org.djvmil.em.backend.core.entity.Interview;
import org.djvmil.em.backend.core.service.InterviewService;
import org.djvmil.em.backend.form.InterviewForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interviews")
@CrossOrigin
public class InterviewRessource {

    @Autowired
    private InterviewService service;

    @GetMapping
    public Iterable<Interview> list(){

        return service.list();
    }

    @GetMapping("/{id}")
    public Interview findById(@PathVariable("id") Long interviewId){
        Interview interview = service.findById(interviewId);

        return interview;
    }

    @PostMapping
    public InterviewForm addUser(@Valid @ModelAttribute InterviewForm interviewForm, BindingResult bindingResult){

        return interviewForm;
    }

}
