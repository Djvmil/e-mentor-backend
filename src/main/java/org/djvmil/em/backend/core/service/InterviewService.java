package org.djvmil.em.backend.core.service;

import org.djvmil.em.backend.core.dto.InterviewDto;
import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.entity.Interview;
import org.djvmil.em.backend.core.repository.IInterviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InterviewService {
    @Autowired
    private IInterviewRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public InterviewDto save(InterviewDto interviewDto){
        Interview interview = modelMapper.map(interviewDto, Interview.class);

        return modelMapper.map(repository.save(interview), InterviewDto.class);
    }

    public List<InterviewDto> list(){

        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(interview -> modelMapper.map(interview, InterviewDto.class))
                .collect(Collectors.toList());
    }

    public InterviewDto findById(Long interviewId) {

        return modelMapper.map(repository.findById(interviewId).orElseThrow(), InterviewDto.class);
    }
}
