package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Tip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipRepository extends JpaRepository<Tip, Long> {
}
