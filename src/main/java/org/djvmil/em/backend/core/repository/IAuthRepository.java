package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Question;
import org.djvmil.em.backend.core.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IAuthRepository extends CrudRepository<User, Long> {
    Iterable<User> findUserByFirstname(String firstname);
    Iterable<User> findUserByLastname(String lastname);
    Iterable<User> findUserByGenre(String genre);
    Iterable<User> findUserByRole(String role);
}
