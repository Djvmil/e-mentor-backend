package org.djvmil.em.backend.api;

import org.djvmil.em.backend.core.dto.QuestionDto;
import org.djvmil.em.backend.core.entity.Question;
import org.djvmil.em.backend.core.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin
public class QuestionRessource {

    @Autowired
    private QuestionService service;

    @GetMapping
    public List<QuestionDto> list(Model model){
        return service.list();
    }

    @GetMapping("/{id}")
    public QuestionDto findById(@PathVariable("id") Long questionId){

        return service.findById(questionId);
    }


}
