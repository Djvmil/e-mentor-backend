package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UserRepositoryTests {

	@Autowired
	IAuthRepository repository;

	static User user = null;

	@BeforeAll
	public static void init(){
		user = new User();
		user.setFirstname("Djibril");
		user.setLastname("Diop");
		user.setCountry("SENEGAl");
		user.setGenre("MALE");
		user.setEmail("djidiop19@gmail.com");
		user.setBirthDate("02/01/1992");
		user.setPhoneNumber("546767898765");

	}

	@Test
	void testCreate() {

		repository.save(user);

		Optional<User> optionalUser = repository.findById(user.getUserID());
		if (optionalUser.isPresent()) {
			User retrievedUser = optionalUser.get();
			System.out.println("testCreate: Utilisateur récupéré = " + retrievedUser);
		} else {
			System.out.println("testCreate: Utilisateur non trouvé.");
		}


	}

	@Test
	void testFind() {
		Optional<User> optionalUser = repository.findById(user.getUserID());
		if (optionalUser.isPresent()) {
			User retrievedUser = optionalUser.get();
			System.out.println("testFind: Utilisateur récupéré = " + retrievedUser);
		} else {
			System.out.println("testFind: Utilisateur non trouvé.");
		}

	}

	@Test
	void testFindUserByFirstname() {
		Iterable<User> users = repository.findUserByFirstname(user.getFirstname());
		users.forEach( user ->
				System.out.println("testFindResponseByFirstname: Utilisateur récupéré = " + user)
		);
	}

	@Test
	void testFindUserByLastname() {
		Iterable<User> users = repository.findUserByLastname(user.getLastname());
		users.forEach( user ->
				System.out.println("testFindResponseByLastname: Utilisateur récupéré = " + user)
		);
	}

	@Test
	void testFindUserByRole() {
		Iterable<User> users = repository.findUserByRole(user.getRole());
		users.forEach( user ->
				System.out.println("testFindResponseByRole: Utilisateur récupéré = " + user)
		);
	}

	@Test
	void testFindUserByGenre() {
		Iterable<User> users = repository.findUserByGenre(user.getGenre());
		users.forEach( user ->
				System.out.println("testFindResponseByGenre: Utilisateur récupéré = " + user)
		);
	}
	@Test
	void testDeleteUser() {

		Optional<User> optionalUser = repository.findById(user.getUserID());
		if (optionalUser.isPresent()) {
			User retrievedUser = optionalUser.get();
			System.out.println("testDeleteUser: Utilisateur récupéré = " + retrievedUser);
			repository.delete(retrievedUser);
		} else {
			System.out.println("testDeleteUser: Utilisateur non trouvé.");
		}

	}

}
