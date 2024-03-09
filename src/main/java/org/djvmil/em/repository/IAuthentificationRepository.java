package org.djvmil.em.repository;

import org.djvmil.em.entity.User;

public interface IAuthentificationRepository {

    public User login(String login, String password);

    public Boolean register(User user);
}
