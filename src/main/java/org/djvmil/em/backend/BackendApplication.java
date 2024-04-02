package org.djvmil.em.backend;

import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication{ //implements CommandLineRunner {

	//@Autowired
	//private RepositoryRestConfiguration restConfiguration;

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

}
