package org.djvmil.em.backend.core.service;

import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.entity.User;
import org.djvmil.em.backend.core.repository.IAuthRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@Component
public class AuthService {
    @Autowired // like @Inject or @Ressource in JEE
    private IAuthRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDto login(String login, String password){

        return modelMapper.map(repository.findById(1L).orElseThrow(), UserDto.class);
    }

    public UserDto register(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);

        return modelMapper.map(repository.save(user), UserDto.class);
    }

    public List<UserDto> list(){

        return repository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto getById(Long userId) {
        return modelMapper.map(repository.findById(userId).orElseThrow(), UserDto.class);
    }
}
