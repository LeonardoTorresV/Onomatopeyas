package com.reto.onomatopoeia.infrastructure.config;

import com.reto.onomatopoeia.application.service.AnimalProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.reto.onomatopoeia")
public class AppConfig {
    @Bean
    public AnimalProcessor animalProcessor() {
        return new AnimalProcessor();
    }
}