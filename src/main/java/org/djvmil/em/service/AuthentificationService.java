package org.djvmil.em.service;

import org.djvmil.em.entity.User;
import org.djvmil.em.repository.IAuthentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Component
public class AuthentificationService {


    @Autowired // like @Inject or @Ressource in JEE
    private IAuthentificationRepository repository;

    public User login(String login, String password){
        return repository.login(login, password);
    }

    public Boolean register(User user){

        return repository.register(user);
    }

    public List<User> list(){
        return repository.list();
    }
}
