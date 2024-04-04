package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
