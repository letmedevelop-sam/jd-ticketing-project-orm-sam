package com.cybertek;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

						//Container will handle bean staff
@SpringBootApplication  //@SpringBootApplication covers @ComponentScan - @Configuration  - @EnableAutoConfiguration
public class SpringMvcProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProjectManagementApplication.class, args);
	}

	@Bean			//@SpringBootApplication covers @ComponentScan - @Configuration  - @EnableAutoConfiguration
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}



}
