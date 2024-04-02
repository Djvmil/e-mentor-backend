package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Question;
import org.djvmil.em.backend.core.entity.Response;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IQuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findResponseByQuestionText(String questionText);
    List<Question> findResponseByQuestionTextContains(String contains);
    List<Question> findResponseByQuestionType(String questionType);
    List<Question> findOrderByQuestionType(String questionType);
}