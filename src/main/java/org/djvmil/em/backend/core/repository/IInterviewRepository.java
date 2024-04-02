package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Interview;
import org.djvmil.em.backend.core.entity.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IInterviewRepository extends CrudRepository<Interview, Long> {
    List<Interview> findResponseByTitle(String title);
    List<Interview> findResponseByDescription(String description);
    List<Interview> findResponseByDescriptionContains(String contains);
    List<Interview> findResponseByCompany(String company);
}
