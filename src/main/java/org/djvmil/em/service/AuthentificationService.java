package org.djvmil.em.service;

import org.djvmil.em.entity.User;
import org.djvmil.em.repository.IAuthentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Component
public class AuthentificationService {


    @Autowired
    private IAuthentificationRepository repository;

    public User login(String login, String password){
        return repository.login(login, password);
    }

    public Boolean register(User user){

        return repository.register(user);
    }
}
