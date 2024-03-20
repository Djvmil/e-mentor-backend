package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Response;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface IResponseRepository extends CrudRepository<Response, Long> {
    @EntityGraph(value = "response.join.tables", type = EntityGraph.EntityGraphType.FETCH)
    Iterable<Response> findAll();
}