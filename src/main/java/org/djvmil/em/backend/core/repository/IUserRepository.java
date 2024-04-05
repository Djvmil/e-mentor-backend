package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface IUserRepository extends JpaRepository<User, Long> {
    List<User> findUserByFirstname(String firstname);
    List<User> findUserByLastname(String lastname);
    List<User> findUserByGenre(String genre);
    User findByUsername(String username);
    User getByEmail(String email);
}
