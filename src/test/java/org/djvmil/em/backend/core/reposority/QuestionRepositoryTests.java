package org.djvmil.em.backend.core.reposority;

import org.djvmil.em.backend.core.entity.Question;
import org.djvmil.em.backend.core.entity.User;
import org.djvmil.em.backend.core.repository.IAuthRepository;
import org.djvmil.em.backend.core.repository.IQuestionRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class QuestionRepositoryTests {

	@Autowired
	IQuestionRepository repository;

	static Question question = null;

	@BeforeAll
	public static void init(){
		question = new Question();
		question.setQuestionText("Test question 1");
		question.setQuestionType("T1");


	}

	@Test
	void testCreate() {

		repository.save(question);

		Optional<Question> optionalQuestion = repository.findById(question.getQuestionID());
		if (optionalQuestion.isPresent()) {
			Question retrievedQuestion = optionalQuestion.get();
			System.out.println("testCreate: Question récupéré = " + retrievedQuestion);
		} else {
			System.out.println("testCreate: Question non trouvé.");
		}


	}

	@Test
	void testFind() {
		Optional<Question> optionalQuestion = repository.findById(question.getQuestionID());
		if (optionalQuestion.isPresent()) {
			Question retrievedQuestion = optionalQuestion.get();
			System.out.println("testFind: Question récupéré = " + retrievedQuestion);
		} else {
			System.out.println("testFind: Question non trouvé.");
		}

	}

	@Test
	void testFindByQuestionText() {
		Iterable<Question> questions = repository.findResponseByQuestionText(question.getQuestionText());
		questions.forEach( res ->
				System.out.println("findResponseByQuestionText: Question récupéré = " + res)
		);
	}

	@Test
	void testFindByQuestionTextContains() {
		Iterable<Question> questions = repository.findResponseByQuestionTextContains(question.getQuestionText());
		questions.forEach( res ->
				System.out.println("findResponseByQuestionTextContains: Question récupéré = " + res)
		);
	}

	@Test
	void testFindByQuestionType() {
		Iterable<Question> questions = repository.findResponseByQuestionType(question.getQuestionType());
		questions.forEach( res ->
				System.out.println("findResponseByQuestionType: Question récupéré = " + res)
		);
	}

	@Test
	void testDeleteQuestion() {

		Optional<Question> optionalQuestion = repository.findById(question.getQuestionID());
		if (optionalQuestion.isPresent()) {
			Question retrievedQuestion = optionalQuestion.get();
			System.out.println("testDeleteQuestion: Question récupéré = " + retrievedQuestion);
		} else {
			System.out.println("testDeleteQuestion: Question non trouvé.");
		}

	}

}
