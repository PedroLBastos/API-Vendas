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
			clientes.salvar(new Cliente("Pedro"));
			clientes.salvar(new Cliente("Outro"));

			List<Cliente> todos = clientes.obterTodos();
			todos.forEach(System.out::println);

			todos.forEach(cliente -> {
				cliente.setNome(cliente.getNome() + " atualizado");
				clientes.atualizar(cliente);
			});

			clientes.buscarPorNome("Ped").forEach(System.out::println);

			todos = clientes.obterTodos();
			if (todos.isEmpty()){
				System.out.println("Nenhum");

			}else {
				todos.forEach(System.out::println);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(StudySpringBootApplication.class, args);
	}

}