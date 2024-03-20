package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Question;
import org.springframework.data.repository.CrudRepository;

public interface IQuestionRepository extends CrudRepository<Question, Long> {}