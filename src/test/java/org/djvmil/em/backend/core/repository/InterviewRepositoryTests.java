package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Interview;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class InterviewRepositoryTests {

	@Autowired
	IInterviewRepository repository;

	static Interview interview = null;

	@BeforeEach
	public void init(){
		interview = new Interview();
		interview.setCompany("C1");
		interview.setTitle("Title 1");
		interview.setDescription("Description 1");
		interview.setRequiredSkills("Skill 1");

	}

	@Test
	void testCreate() {

		repository.save(interview);

		Optional<Interview> optionalInterview = repository.findById(interview.getInterviewID());
		if (optionalInterview.isPresent()) {
			Interview retrievedInterview = optionalInterview.get();
			System.out.println("testCreate: Interview récupéré = " + retrievedInterview);
		} else {
			System.out.println("testCreate: Interview non trouvé.");
		}


	}

	@Test
	void testFind() {
		Optional<Interview> optionalInterview = repository.findById(interview.getInterviewID());
		if (optionalInterview.isPresent()) {
			Interview retrievedInterview = optionalInterview.get();
			System.out.println("testFind: Interview récupéré = " + retrievedInterview);
		} else {
			System.out.println("testFind: Interview non trouvé.");
		}

	}

	@Test
	void testFindByTitle() {
		Iterable<Interview> interviews = repository.findResponseByTitle(interview.getTitle());
		interviews.forEach( res ->
				System.out.println("findResponseByTitle: Interview récupéré = " + res)
		);
	}

	@Test
	void testFindByDescription() {
		Iterable<Interview> interviews = repository.findResponseByDescription(interview.getDescription());
		interviews.forEach( res ->
				System.out.println("findResponseByDescription: Interview récupéré = " + res)
		);
	}
	@Test
	void testFindByDescriptionContains() {
		Iterable<Interview> interviews = repository.findResponseByDescriptionContains(interview.getDescription());
		interviews.forEach( res ->
				System.out.println("findResponseByDescriptionContains: Interview récupéré = " + res)
		);
	}

	@Test
	void testFindByCompany() {
		Iterable<Interview> interviews = repository.findResponseByCompany(interview.getCompany());
		interviews.forEach( res ->
				System.out.println("findResponseByCompany: Interview récupéré = " + res)
		);
	}

	@Test
	@AfterEach
	void testDeleteInterview() {

		Optional<Interview> optionalInterview = repository.findById(interview.getInterviewID());
		if (optionalInterview.isPresent()) {
			Interview retrievedInterview = optionalInterview.get();
			System.out.println("testDeleteInterview: Interview récupéré = " + retrievedInterview);
		} else {
			System.out.println("testDeleteInterview: Interview non trouvé.");
		}

	}

}
