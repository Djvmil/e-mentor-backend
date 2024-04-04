package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
}
