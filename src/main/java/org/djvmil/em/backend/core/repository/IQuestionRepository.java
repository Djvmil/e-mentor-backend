package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Question;
import org.djvmil.em.backend.core.entity.Response;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface IQuestionRepository extends CrudRepository<Question, Long> {
    Iterable<Question> findResponseByQuestionText(String questionText);
    Iterable<Question> findResponseByQuestionTextContains(String contains);
    Iterable<Question> findResponseByQuestionType(String questionType);
    Iterable<Question> findOrderByQuestionTypeASC(String questionType);
}