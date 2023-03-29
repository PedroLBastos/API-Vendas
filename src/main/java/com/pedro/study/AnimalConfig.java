package com.pedro.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {

    @Bean(name = "Cachorro")
    public Animal cachorro(){
        return new Animal(){
            @Override
            public void fazerBarulho(){
                System.out.println("Au au");
            }
        };

    }
    @Bean(name = "Gato")
    public Animal gato(){
        return new Animal(){
            @Override
            public void fazerBarulho(){
                System.out.println("MiAu miau");
            }
        };

    }
}
