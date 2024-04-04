package org.djvmil.em.backend;

import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import jakarta.annotation.PostConstruct;
import org.djvmil.em.backend.core.dto.RoleDto;
import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendApplication{ //implements CommandLineRunner {

	//@Autowired
	//private RepositoryRestConfiguration restConfiguration;


	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public Hibernate6Module hibernate6Module() {
		return new Hibernate6Module();
	}


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	//@Override
	//public void run(String... args) throws Exception {
	//	restConfiguration.exposeIdsFor(User.class);
	//}

	/*@PostConstruct
	public void initUserAndRole(){
		//ajouter les rôles
		userService.addRole(new RoleDto(null,"ADMIN"));
		userService.addRole(new RoleDto(null,"USER"));

		//ajouter les users

		UserDto userAdmin = new UserDto();
		userAdmin.setUserID(null);
		userAdmin.setFirstname("admin");
		userAdmin.setLastname("admin");
		userAdmin.setUsername("admin");
		userAdmin.setPassword("1234");
		userAdmin.setEmail("admin@em.com");
		userAdmin.setEnabled(true);
		userService.create(userAdmin);

		UserDto userSimple = new UserDto();
		userSimple.setUserID(null);
		userSimple.setFirstname("yassine");
		userSimple.setLastname("nadhem");
		userSimple.setUsername("yassine");
		userSimple.setPassword("1234");
		userSimple.setEmail("yassine@em.com");
		userSimple.setEnabled(true);
		userService.create(userSimple);

		//ajouter les rôles aux users
		userService.addRoleToUser(userAdmin.getUsername(), "ADMIN");
		userService.addRoleToUser(userAdmin.getUsername(), "USER");
		userService.addRoleToUser(userSimple.getUsername(), "USER");
	}*/

}
