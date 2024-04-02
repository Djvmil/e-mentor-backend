package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.Interview;
import org.djvmil.em.backend.core.entity.Question;
import org.djvmil.em.backend.core.entity.Response;
import org.djvmil.em.backend.core.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class ResponseRepositoryTests {

	@Autowired
	IResponseRepository repository;

	static Response response = null;

	@BeforeAll
	public static void init(){
		User user = new User();
		user.setUserID(1L);
		user.setFirstname("Djibril");
		user.setLastname("Diop");
		user.setCountry("SENEGAl");
		user.setGenre("MALE");
		user.setEmail("djidiop13@gmail.com");
		user.setBirthDate("02/01/1992");
		user.setPhoneNumber("546767898765");

		Interview interview = new Interview();
		interview.setInterviewID(1L);
		interview.setCompany("C1");
		interview.setTitle("Title 1");
		interview.setDescription("Description 1");
		interview.setDateTime(LocalDateTime.now());
		interview.setRequiredSkills("Skill 1");

		Question question = new Question();
		question.setQuestionID(1L);
		question.setQuestionText("Test question 1");
		question.setQuestionType("T1");


		response = new Response();

		response.setResponseText("Response Test 1");
		response.setScore(234l);
		response.setUser(new User());
		response.setInterview(interview);
		response.setQuestion(question);

	}

	@BeforeTestMethod
	@Test
	void testCreate() {

		repository.save(response);

		Optional<Response> optionalResponse = repository.findById(response.getResponseID());
		if (optionalResponse.isPresent()) {
			Response retrievedResponse = optionalResponse.get();
			System.out.println("testCreate: Response récupéré = " + retrievedResponse);
		} else {
			System.out.println("testCreate: Response non trouvé.");
		}


	}

	@Test
	void testFind() {
		Optional<Response> optionalResponse = repository.findById(response.getResponseID());
		if (optionalResponse.isPresent()) {
			Response retrievedResponse = optionalResponse.get();
			System.out.println("testFind: Response récupéré = " + retrievedResponse);
		} else {
			System.out.println("testFind: Response non trouvé.");
		}

	}

	@Test
	void testFindByInterviewId() {
		Iterable<Response> responses = repository.findByInterviewInterviewID(response.getInterview().getInterviewID());
		responses.forEach( res ->
				System.out.println("testFindByInterviewId: Response récupéré = " + res)
		);
	}

	@Test
	void testFindResponseByQuestionId() {
		Iterable<Response> responses = repository.findResponseByQuestionQuestionID(response.getQuestion().getQuestionID());
		responses.forEach( res ->
				System.out.println("findResponseByQuestionId: Response récupéré = " + res)
		);
	}

	@Test
	void testFindUserByRole() {
		Iterable<Response> responses = repository.findByResponseText(response.getResponseText());
		responses.forEach( res ->
				System.out.println("findByResponseText: Response récupéré = " + res)
		);
	}


	@Test
	void testFindByResponseTextContains() {
		Iterable<Response> responses = repository.findByResponseTextContains(response.getResponseText());
		responses.forEach( res ->
				System.out.println("findByResponseTextContains: Response récupéré = " + res)
		);
	}

	@Test
	void testFindByUserId() {
		Iterable<Response> responses = repository.findByUserUserID(response.getUser().getUserID());
		responses.forEach( res ->
				System.out.println("findByUserId: Response récupéré = " + res)
		);
	}

	@Test
	void testFindByUser() {
		Iterable<Response> responses = repository.findByUser(response.getUser());
		responses.forEach( res ->
				System.out.println("findByUser: Response récupéré = " + res)
		);
	}

	@AfterTestMethod
	@Test
	void testDeleteResponse() {

		Optional<Response> optionalResponse = repository.findById(response.getResponseID());
		if (optionalResponse.isPresent()) {
			Response retrievedResponse = optionalResponse.get();
			System.out.println("testDeleteResponse: Response récupéré = " + retrievedResponse);
			repository.delete(retrievedResponse);
		} else {
			System.out.println("testDeleteResponse: Response non trouvé.");
		}

	}

}
