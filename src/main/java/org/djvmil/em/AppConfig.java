package org.djvmil.em;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.djvmil.em.repository.file", "org.djvmil.em.service", "org.djvmil.em.controler"})
public class AppConfig {

}
