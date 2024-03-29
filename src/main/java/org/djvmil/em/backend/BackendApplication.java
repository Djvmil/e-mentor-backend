package org.djvmil.em.backend;

import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import org.djvmil.em.backend.core.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public Hibernate6Module hibernate6Module() {
		return new Hibernate6Module();
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Response.class);
	}
}
