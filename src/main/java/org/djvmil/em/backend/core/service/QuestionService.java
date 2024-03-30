package org.djvmil.em.backend.core.service;

import org.djvmil.em.backend.core.dto.QuestionDto;
import org.djvmil.em.backend.core.entity.Question;
import org.djvmil.em.backend.core.repository.IQuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
//@Component
public class QuestionService {
    @Autowired
    private IQuestionRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public QuestionDto save(QuestionDto questionDto){

        Question question = modelMapper.map(questionDto, Question.class);


        return modelMapper.map(repository.save(question), QuestionDto.class);
    }

    public List<QuestionDto> list(){

        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(question -> modelMapper.map(question, QuestionDto.class)).collect(Collectors.toList());
    }

    public QuestionDto findById(Long questionId) {

        return modelMapper.map(repository.findById(questionId).orElseThrow(), QuestionDto.class);
    }
}
