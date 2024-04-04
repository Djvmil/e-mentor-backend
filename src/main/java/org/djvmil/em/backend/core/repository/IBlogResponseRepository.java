package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.BlogResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogResponseRepository extends JpaRepository<BlogResponse, Long> {
}
