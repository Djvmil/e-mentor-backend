package org.djvmil.em.backend.core.service;

import org.djvmil.em.backend.core.dto.RoleDto;
import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.entity.Role;
import org.djvmil.em.backend.core.entity.User;
import org.djvmil.em.backend.core.helpers.Helper;
import org.djvmil.em.backend.core.repository.IRoleRepository;
import org.djvmil.em.backend.core.repository.IUserRepository;
import org.djvmil.em.backend.payloads.AuthRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {
    @Autowired // like @Inject or @Ressource in JEE
    private IUserRepository repository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public UserDto login(String login, String password){

        return modelMapper.map(repository.findByUsername(login), UserDto.class);
    }

    public UserDto registerUser(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return modelMapper.map(repository.save(user), UserDto.class);
    }

    public UserDto create(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return modelMapper.map(repository.save(user), UserDto.class);
    }

    public UserDto getById(Long userId) {
        return modelMapper.map(repository.findById(userId).orElseThrow(), UserDto.class);
    }


    public List<UserDto> allUsers(){

        return repository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }
    public UserDto getByUsername(String username) {
        return modelMapper.map(repository.findByUsername(username), UserDto.class);
    }

    public UserDto getByEmail(String email) {
        return modelMapper.map(repository.getByEmail(email), UserDto.class);
    }

    public UserDto getByPhoneNumber(String phoneNumber) {
        return modelMapper.map(repository.getByPhoneNumber(phoneNumber), UserDto.class);
    }

    public RoleDto addRole(RoleDto roleDto) {
        Role role =  roleRepository.save(modelMapper.map(roleDto, Role.class));

        return modelMapper.map(role, RoleDto.class);
    }


    @Transactional
    public UserDto addRoleToUser(String username, String roleName) {
        Role role = roleRepository.findByRole(roleName);
        User user = repository.getByEmail(username);
        user.getRoles().add(role);

        return modelMapper.map(user, UserDto.class);
    }


    @Transactional
    public UserDto getUser(String username) {
        UserDto userDto;

        if (Helper.isEmailValid(username))
            userDto = getByEmail(username);

        else if(Helper.isPhoneNumberValid(username))
            userDto = getByPhoneNumber(username);

        else
            userDto = getByUsername(username);

        return userDto;
    }
}
