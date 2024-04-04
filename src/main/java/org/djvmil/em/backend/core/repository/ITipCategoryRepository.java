package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.TipCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipCategoryRepository extends JpaRepository<TipCategory, Long> {
}
