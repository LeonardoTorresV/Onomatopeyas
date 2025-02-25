package com.reto.onomatopoeia.domain.factory;

import com.reto.onomatopoeia.domain.enums.AnimalType;
import com.reto.onomatopoeia.domain.model.*;


import java.util.HashMap;
import java.util.Map;

public class AnimalFactory {
    private static final Map<String, Animal> animalMap = new HashMap<>();
    static {
        animalMap.put("perros", new Animal("Perros", AnimalType.TERRESTRES, "Guau!"));
        animalMap.put("gatos", new Animal("Gatos", AnimalType.TERRESTRES, "Miau!"));
        animalMap.put("patos", new Animal("Patos", AnimalType.VOLADORES, "Cuác!"));
        animalMap.put("gorriones", new Animal("Gorriones", AnimalType.VOLADORES, "Cucú!"));
        animalMap.put("peces", new Animal("Peces", AnimalType.ACUATICOS, "Blub!"));
        animalMap.put("ballenas", new Animal("Ballenas", AnimalType.ACUATICOS, "Blub!"));
    }

    public static Animal crearAnimal(String nombre) {
        return animalMap.getOrDefault(nombre.toLowerCase(), new Animal(nombre, AnimalType.TERRESTRES, "???") {});
    }
}
