package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IAuthRepository extends CrudRepository<User, Long> {

}
