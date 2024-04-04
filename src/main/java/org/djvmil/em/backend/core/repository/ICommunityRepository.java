package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommunityRepository extends JpaRepository<Community, Long> {
}
