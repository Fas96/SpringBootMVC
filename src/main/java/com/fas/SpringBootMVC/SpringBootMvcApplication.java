package com.fas.SpringBootMVC;

import com.fas.SpringBootMVC.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootMvcApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext cont = SpringApplication.run(SpringBootMvcApplication.class, args);

	}

}
