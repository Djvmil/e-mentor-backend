package org.djvmil.em.backend.api;

import org.djvmil.em.backend.core.entity.Question;
import org.djvmil.em.backend.core.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin
public class QuestionRessource {

    @Autowired
    private QuestionService service;

    @GetMapping
    public Iterable<Question> list(Model model){
        return service.list();
    }

    @GetMapping("/{id}")
    public Question findById(@PathVariable("id") Long questionId){

        return service.findById(questionId);
    }


}
