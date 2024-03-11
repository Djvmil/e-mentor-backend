package org.djvmil.em.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.djvmil.em.core.repository.file", "org.djvmil.em.core.service", "org.djvmil.em.controler"})
public class AppConfig {

}
