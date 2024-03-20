package org.djvmil.em.backend.core.service;

import org.djvmil.em.backend.core.entity.User;
import org.djvmil.em.backend.core.repository.IAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Component
public class AuthService {
    @Autowired // like @Inject or @Ressource in JEE
    private IAuthRepository repository;

    public User login(String login, String password){
        return repository.findById(1L).orElseThrow();
    }

    public User register(User user){

        return repository.save(user);
    }

    public Iterable<User> list(){
        return repository.findAll();
    }

    public User getById(Long userId) {
        return repository.findById(userId).orElseThrow();
    }
}
