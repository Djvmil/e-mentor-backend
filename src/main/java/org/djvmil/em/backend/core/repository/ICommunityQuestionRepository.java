package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.CommunityQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommunityQuestionRepository extends JpaRepository<CommunityQuestion, Long> {
}
