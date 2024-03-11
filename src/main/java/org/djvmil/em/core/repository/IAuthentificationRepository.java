package org.djvmil.em.core.repository;

import org.djvmil.em.core.entity.User;

import java.util.List;

public interface IAuthentificationRepository {

    public User login(String login, String password);

    public Boolean register(User user);

    public List<User> list();
}
