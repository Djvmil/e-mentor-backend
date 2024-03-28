package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Interview;
import org.djvmil.em.backend.core.entity.Question;
import org.springframework.data.repository.CrudRepository;


public interface IInterviewRepository extends CrudRepository<Interview, Long> {
    Iterable<Interview> findResponseByTitle(String title);
    Iterable<Interview> findResponseByDescription(String description);
    Iterable<Interview> findResponseByDescriptionContains(String contains);
    Iterable<Interview> findResponseByCompany(String company);
}
