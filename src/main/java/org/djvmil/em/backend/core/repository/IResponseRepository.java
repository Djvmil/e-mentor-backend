package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Response;
import org.djvmil.em.backend.core.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IResponseRepository extends JpaRepository<Response, Long> {
    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    List<Response> findAll();
    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    List<Response> findByResponseText(String responseText);
    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    List<Response> findByResponseTextContains(String responseText);

    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    List<Response> findByUser(User user);
    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    List<Response> findByUserId(Long userId);
    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    List<Response> findResponseByQuestionId(Long questionId);

    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    List<Response> findByInterviewId(Long interviewId);
}