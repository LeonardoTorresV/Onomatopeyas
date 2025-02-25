package com.reto.onomatopoeia.application.service;

import com.reto.onomatopoeia.domain.enums.AnimalType;
import com.reto.onomatopoeia.domain.factory.AnimalFactory;
import com.reto.onomatopoeia.domain.model.Animal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class AnimalProcessor {
    public void procesarAnimales(String input) {
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        List<Animal> animales = Arrays.stream(input.split(","))
                .map(AnimalFactory::crearAnimal)
                .collect(Collectors.toList());

        Map<AnimalType, List<Animal>> agrupados = animales.stream()
                .collect(Collectors.groupingBy(Animal::getTipo));

        // Ordenar los tipos de animales para garantizar un orden consistente
        List<AnimalType> tiposOrdenados = Arrays.asList(AnimalType.TERRESTRES, AnimalType.VOLADORES, AnimalType.ACUATICOS);

        for (AnimalType tipo : tiposOrdenados) {
            if (agrupados.containsKey(tipo)) {
                System.out.println("Animales " + tipo + ":");
                agrupados.get(tipo).forEach(a -> System.out.println("- " + a.getOnomatopoeia()));
                System.out.println(); // Salto de línea adicional después de cada grupo
            }
        }
    }}