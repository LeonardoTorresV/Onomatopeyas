package com.reto.onomatopoeia;

import com.reto.onomatopoeia.application.service.AnimalProcessor;
import com.reto.onomatopoeia.domain.enums.AnimalType;
import com.reto.onomatopoeia.domain.model.Animal;
import com.reto.onomatopoeia.domain.factory.AnimalFactory;
import com.reto.onomatopoeia.infrastructure.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AnimalFactoryTest {

    @Test
    void testAnimalConstructor() {
        // Arrange (Prepara los datos)
        String expectedName = "Leon";
        AnimalType expectedType = AnimalType.TERRESTRES;
        String expectedSound = "Rugido";

        // Act (Crea el objeto)
        Animal animal = new Animal(expectedName, expectedType, expectedSound);

        // Assert (Verifica que los valores son correctos)
        assertEquals(expectedName, animal.getName());
        assertEquals(expectedType, animal.getType());
        assertEquals(expectedSound, animal.getOnomatopoeia());
    }

    @Test
    void testCrearAnimalesDesdeInput() {
        // Simulamos un input de texto separado por comas
        String input = "Perro,Gato,Leon";

        // Llamamos a la funcionalidad que queremos probar
        List<Animal> animales = Arrays.stream(input.split(","))
                .map(AnimalFactory::crearAnimal)
                .collect(Collectors.toList());

        // Verificamos que se hayan creado correctamente
        assertNotNull(animales);
        assertEquals(3, animales.size());
        assertEquals("Perro", animales.get(0).getName());
        assertEquals("Gato", animales.get(1).getName());
        assertEquals("Leon", animales.get(2).getName());
    }



    @Test
    void testMainWithoutArguments() {
        // Capturar salida de consola
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Ejecutar main sin argumentos
        Main.main(new String[]{});

        // Verificar que el mensaje esperado se imprimió
        assertTrue(outputStream.toString().contains("Debe proporcionar una cadena de entrada."));

        // Restaurar salida estándar
        System.setOut(System.out);
    }

    @Test
    void testOnomatopeiaConstructor() {
        Animal animal = new Animal("León", AnimalType.TERRESTRES, "Rugido");
        assertNotNull(animal);
    }

    @Test
    void testGetType() {
        Animal animal = new Animal("León", AnimalType.TERRESTRES, "Rugido");
        assertEquals(AnimalType.TERRESTRES, animal.getType());
    }



    @Test
    void testCrearAnimalExistente_Perros() {
        // Arrange & Act
        Animal animal = AnimalFactory.crearAnimal("perros");

        // Assert
        assertNotNull(animal);
        assertEquals("Perros", animal.getName());
        assertEquals(AnimalType.TERRESTRES, animal.getTipo());
        assertEquals("Guau!", animal.getOnomatopoeia());
    }

    @Test
    void testCrearAnimalExistente_Patos() {
        // Arrange & Act
        Animal animal = AnimalFactory.crearAnimal("patos");

        // Assert
        assertNotNull(animal);
        assertEquals("Patos", animal.getName());
        assertEquals(AnimalType.VOLADORES, animal.getTipo());
        assertEquals("Cuác!", animal.getOnomatopoeia());
    }

    @Test
    void testCrearAnimalExistente_Ballenas() {
        // Arrange & Act
        Animal animal = AnimalFactory.crearAnimal("ballenas");

        // Assert
        assertNotNull(animal);
        assertEquals("Ballenas", animal.getName());
        assertEquals(AnimalType.ACUATICOS, animal.getTipo());
        assertEquals("Blub!", animal.getOnomatopoeia());
    }

    @Test
    void testCrearAnimalNoExistente() {
        // Arrange & Act
        Animal animal = AnimalFactory.crearAnimal("delfines");

        // Assert
        assertNotNull(animal);
        assertEquals("delfines", animal.getName());
        assertEquals(AnimalType.TERRESTRES, animal.getTipo()); // Por defecto TERRESTRES
        assertEquals("???", animal.getOnomatopoeia()); // Sonido desconocido
    }

    @Test
    void testCrearAnimalConNombreEnMayusculas() {
        // Arrange & Act
        Animal animal = AnimalFactory.crearAnimal("GATOS");

        // Assert
        assertNotNull(animal);
        assertEquals("Gatos", animal.getName());
        assertEquals(AnimalType.TERRESTRES, animal.getTipo());
        assertEquals("Miau!", animal.getOnomatopoeia());
    }

    // Prueba para nombres vacíos
    @Test
    void testCrearAnimalConNombreVacio() {
        Animal animal = AnimalFactory.crearAnimal("");
        assertNotNull(animal);
        assertEquals("", animal.getName());
        assertEquals(AnimalType.TERRESTRES, animal.getTipo());
        assertEquals("???", animal.getOnomatopoeia());
    }

    @Test
    void testCrearAnimalConNombreMixto() {
        // Arrange & Act
        Animal animal = AnimalFactory.crearAnimal("PeRrOs");

        // Assert
        assertNotNull(animal);
        assertEquals("Perros", animal.getName());
        assertEquals(AnimalType.TERRESTRES, animal.getTipo());
        assertEquals("Guau!", animal.getOnomatopoeia());
    }

    @Test
    void testProcesarAnimales() {
        // Redirigir la salida de la consola para verificar la impresión
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        AnimalProcessor processor = new AnimalProcessor();
        processor.procesarAnimales("Perro,Gato,Ave,Pez");

        // Verificar que se imprimieron las categorías
        String output = outContent.toString();
        assertTrue(output.contains("Animales TERRESTRES:") ||
                output.contains("Animales VOLADORES:") ||
                output.contains("Animales ACUATICOS:"));

        // Restaurar la salida estándar
        System.setOut(System.out);
    }

    @Test
    void testBeanCreation() {
        // Cargar el contexto de Spring
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            // Verificar que el contexto carga correctamente
            assertNotNull(context);

            // Obtener el bean de AnimalProcessor
            AnimalProcessor processor = context.getBean(AnimalProcessor.class);

            // Verificar que el bean no sea nulo
            assertNotNull(processor);
        }
    }

    @Test
    void testSettersAndGetters() {
        Animal animal = new Animal("Perro", AnimalType.TERRESTRES, "Guau"); // Constructor sin parámetros

        // Probar setter y getter de name
        animal.setName("Perro");
        assertEquals("Perro", animal.getName());

        // Probar setter y getter de type
        animal.setType(AnimalType.TERRESTRES);
        assertEquals(AnimalType.TERRESTRES, animal.getTipo());

        // Probar setter y getter de onomatopeya
        animal.setOnomatopoeia("Guau");
        assertEquals("Guau", animal.getOnomatopoeia());
    }
}