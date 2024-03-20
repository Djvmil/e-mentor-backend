package org.djvmil.em.backend.core.service;

import org.djvmil.em.backend.core.entity.Question;
import org.djvmil.em.backend.core.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Component
public class QuestionService {
    @Autowired
    private IQuestionRepository repository;

    public Question save(Question question){

        return repository.save(question);
    }

    public Iterable<Question> list(){
        return repository.findAll();
    }

    public Question findById(Long questionId) {
        return repository.findById(questionId).orElseThrow();
    }
}
