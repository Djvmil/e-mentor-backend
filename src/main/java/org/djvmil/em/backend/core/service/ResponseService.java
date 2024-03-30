package org.djvmil.em.backend.core.service;

import org.djvmil.em.backend.core.dto.ResponseDto;
import org.djvmil.em.backend.core.entity.Response;
import org.djvmil.em.backend.core.repository.IResponseRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponseService {
    @Autowired
    private IResponseRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public ResponseDto save(ResponseDto responseDto){

        Response response = modelMapper.map(responseDto, Response.class);

        return modelMapper.map(repository.save(response), ResponseDto.class);
    }

    public List<ResponseDto> list(){

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return repository.findAll().stream()
                .map(response-> modelMapper.map(response, ResponseDto.class))
                .collect(Collectors.toList());
    }

    public ResponseDto findById(Long responseId) {

        return modelMapper.map(repository.findById(responseId).orElseThrow(), ResponseDto.class);
    }
}
