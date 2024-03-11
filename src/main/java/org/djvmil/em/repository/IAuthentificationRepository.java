package org.djvmil.em.repository;

import org.djvmil.em.entity.User;

import java.util.List;

public interface IAuthentificationRepository {

    public User login(String login, String password);

    public Boolean register(User user);

    public List<User> list();
}
