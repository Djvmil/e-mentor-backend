package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Response;
import org.djvmil.em.backend.core.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface IResponseRepository extends CrudRepository<Response, Long> {
    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    Iterable<Response> findAll();
    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    Iterable<Response> findByResponseText(String responseText);
    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    Iterable<Response> findByResponseTextContains(String responseText);

    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    Iterable<Response> findByUser(User user);
    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    Iterable<Response> findByUserId(Long userId);
    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    Iterable<Response> findResponseByQuestionId(Long questionId);

    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    Iterable<Response> findByInterviewId(Long interviewId);
}