package com.reto.onomatopoeia;

import com.reto.onomatopoeia.application.service.AnimalProcessor;
import com.reto.onomatopoeia.infrastructure.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Debe proporcionar una cadena de entrada.");
            return;
        }
        String input = args[0];

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnimalProcessor processor = context.getBean(AnimalProcessor.class);
        processor.procesarAnimales(input);
        context.close();
    }
}