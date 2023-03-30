package com.pedro.study;

import com.pedro.study.domain.entity.Cliente;
import com.pedro.study.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class StudySpringBootApplication {

	@Bean
	public CommandLineRunner init (@Autowired Clientes clientes){
		return args -> {
			clientes.save(new Cliente("Lucas"));
			clientes.save(new Cliente("Outro"));

			boolean existe = clientes.existsByNome("Pedro");
			System.out.println("existe um cliente " + existe);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(StudySpringBootApplication.class, args);
	}

}