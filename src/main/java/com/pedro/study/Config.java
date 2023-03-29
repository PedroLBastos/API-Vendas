package com.pedro.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class Config {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("Rodando dev");
        };
    }


}
