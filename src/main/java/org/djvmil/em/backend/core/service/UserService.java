package org.djvmil.em.backend.core.service;

import org.djvmil.em.backend.core.dto.RoleDto;
import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.entity.Role;
import org.djvmil.em.backend.core.entity.User;
import org.djvmil.em.backend.core.helpers.Helper;
import org.djvmil.em.backend.core.repository.IRoleRepository;
import org.djvmil.em.backend.core.repository.IUserRepository;
import org.djvmil.em.backend.exceptions.UserRegistrationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    //@Transactional
    public UserDto registerUser(UserDto userDto) throws UserRegistrationException {
        try {
            if (userDto.getFirstname() == null || userDto.getFirstname().isBlank()) {
                throw new UserRegistrationException("Firstname required");
            }
            if (userDto.getLastname() == null || userDto.getLastname().isBlank()) {
                throw new UserRegistrationException("Lastname required");
            }
            if ((userDto.getEmail() == null || userDto.getEmail().isBlank()) && (userDto.getPhoneNumber() == null || userDto.getPhoneNumber().isBlank())) {
                throw new UserRegistrationException("Email or Phone Number required");
            }

            if (userDto.getUsername() != null && !userDto.getUsername().isBlank()) {
                if (getByUsername(userDto.getUsername()) != null)
                    throw new UserRegistrationException("A user with this username already exists");
            }

            if (userDto.getEmail() != null && !userDto.getEmail().isBlank()){
                if (getByEmail(userDto.getEmail()) != null)
                    throw new UserRegistrationException("A user with this email already exists");
            }
            if (userDto.getPhoneNumber() != null && !userDto.getPhoneNumber().isBlank()){
                if (getByPhoneNumber(userDto.getPhoneNumber()) != null)
                    throw new UserRegistrationException("A user with this phone number already exists");
            }

            if (userDto.getRoles() != null)
                userDto.getRoles().forEach( role -> {

                    if (role.getRoleID() == null){
                        RoleDto roleSearch = getRole(role.getRole());
                        if (roleSearch != null) {
                            role.setRoleID(roleSearch.getRoleID());
                            role.setDateUpdated(roleSearch.getDateUpdated());
                            role.setDateCreated(roleSearch.getDateCreated());

                        }
                    }
                });

            User user = modelMapper.map(userDto, User.class);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));

            return modelMapper.map(repository.save(user), UserDto.class);
        } catch (Exception e) {
            // Handle exception
            throw new UserRegistrationException(e.getMessage());
        }
    }

    public UserDto create(UserDto userDto){
        try {
            User user = modelMapper.map(userDto, User.class);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));

            return modelMapper.map(repository.save(user), UserDto.class);
        } catch (Exception e) {
            return null;
        }
    }

    public UserDto getById(Long userId) {
        try {
            return modelMapper.map(repository.findById(userId).orElseThrow(), UserDto.class);
        } catch (Exception e) {
            return null;
        }
    }


    public List<UserDto> allUsers(){

        return repository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }
    public UserDto getByUsername(String username) {
        try {
            return modelMapper.map(repository.findByUsername(username), UserDto.class);
        } catch (Exception e) {
            return null;
        }
    }

    public UserDto getByEmail(String email) {
        try {
            return modelMapper.map(repository.getByEmail(email), UserDto.class);
        } catch (Exception e) {
            return null;
        }
    }

    public UserDto getByPhoneNumber(String phoneNumber) {
        try {
        return modelMapper.map(repository.getByPhoneNumber(phoneNumber), UserDto.class);
    } catch (Exception e) {
        return null;
    }
    }

    public RoleDto getRole(String roleName) {
        try {
            Role role =  roleRepository.findByRole(roleName);

            System.out.println("getRole: 123 "+ role);

            return modelMapper.map(role, RoleDto.class);
        } catch (Exception e) {
            return null;
        }
    }

    public RoleDto addRole(RoleDto roleDto) {
        try {
            Role role =  roleRepository.save(modelMapper.map(roleDto, Role.class));

            return modelMapper.map(role, RoleDto.class);
        } catch (Exception e) {
            return null;
        }
    }


    @Transactional
    public UserDto addRoleToUser(String username, String roleName) {
        try {
            Role role = roleRepository.findByRole(roleName);
            User user = repository.getByEmail(username);
            user.getRoles().add(role);

            return modelMapper.map(user, UserDto.class);
        } catch (Exception e) {
            return null;
        }
    }

    public UserDto getUser(String username) {
        try {
            UserDto userDto;

            if (Helper.isEmailValid(username))
                userDto = getByEmail(username);
            else if (Helper.isPhoneNumberValid(username))
                userDto = getByPhoneNumber(username);
            else
                userDto = getByUsername(username);

            return userDto;
        } catch (Exception e) {
            return null;
        }
    }

}
