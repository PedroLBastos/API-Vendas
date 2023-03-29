package com.pedro.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@ConfigDev
public class Config {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("Rodando dev");
        };
    }

}
