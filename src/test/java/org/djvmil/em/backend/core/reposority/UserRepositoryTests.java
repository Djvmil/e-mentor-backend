package org.djvmil.em.backend.core.reposority;

import org.djvmil.em.backend.core.entity.User;
import org.djvmil.em.backend.core.repository.IAuthRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UserRepositoryTests {

	@Autowired
	IAuthRepository repository;

	@Test
	void testCreateUser() {
		User user = new User();
		user.setFirstname("Djibril");
		user.setLastname("Diop");
		user.setCountry("SENEGAl");
		user.setGenre("MALE");
		user.setEmail("djidiop88@gmail.com");
		user.setBirthDate("02/01/1992");
		user.setPhoneNumber("546767898765");

		repository.save(user);

		Optional<User> optionalUser = repository.findById(user.getUserID());
		if (optionalUser.isPresent()) {
			User retrievedUser = optionalUser.get();
			System.out.println("Utilisateur récupéré : " + retrievedUser);
		} else {
			System.out.println("Utilisateur non trouvé.");
		}
/*
		// Test de mise à jour d'un utilisateur
		user.setFirstname("Jane");
		user.setLastname("Doe");
		System.out.println("Utilisateur récupéré befor update: " + user);
		repository.save(user);

		// Test de suppression d'un utilisateur
		repository.delete(user);
		System.out.println("Utilisateur supprimé.");

		// Vérifier s'il reste des utilisateurs dans la base de données
		Iterable<User> users = repository.findAll();
		System.out.println("Utilisateurs restants dans la base de données :");
		for (User u : users) {
			System.out.println(u);
		}*/
	}
	@Test
	void testFind() {
		User user = new User();
		user.setFirstname("Djibril");
		user.setLastname("Diop");
		user.setCountry("SENEGAl");
		user.setGenre("MALE");
		user.setEmail("djidiop89@gmail.com");
		user.setBirthDate("02/01/1992");
		user.setPhoneNumber("546767898765");

		repository.findById(1l).orElseThrow();
	}



}
