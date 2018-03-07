package com.sap.cf.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author fabiano.rosa
 *
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@ComponentScan(basePackages = { "com.sap.cf.springboot" })
@Slf4j
public class AppController {

	// Main method gives control to Spring by invoking run on Spring Application.
	// This enables Spring to Bootstrap the application
	public static void main(String[] args) {
		log.info(">>>Enter main!!!!!");
		SpringApplication.run(AppController.class, args);

	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			log.info("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				log.info(beanName);
//			}
//
//		};
//	}
}
