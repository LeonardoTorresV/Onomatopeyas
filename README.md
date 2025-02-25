# Onomatopeyas

## Descripción del Proyecto

Este proyecto está diseñado para procesar nombres de animales y generar sus respectivas onomatopeyas (sonidos característicos). Utiliza una arquitectura hexagonal para organizar el código de manera modular y escalable, permitiendo una fácil implementación y mantenimiento.

## Requisitos

Para ejecutar este proyecto, necesitarás lo siguiente:

+ Java : Versión 17.
+ Maven : Para compilar y empaquetar el proyecto.
+ IntelliJ IDEA : Como entorno de desarrollo recomendado.

# Instalación
Sigue estos pasos para configurar y ejecutar el proyecto localmente:

    git clone [URL_DEL_REPOSITORIO]
    cd [NOMBRE_DEL_PROYECTO]

# Compila el proyecto usando Maven:

    mvn clean install

## Ejecuta el archivo JAR generado:

    java -jar target/RetoTecnico-1.0-SNAPSHOT-jar-with-dependencies.jar [OBJETO_A_CONSULTAR]

Ejemplo:

    java -jar target/RetoTecnico-1.0-SNAPSHOT-jar-with-dependencies.jar perros

# Uso

El programa acepta nombres de animales como entrada y devuelve su onomatopeya correspondiente. Si el animal no existe en la base de datos, se asignará un sonido predeterminado ("???").

Ejemplo de salida:

    Animales TERRESTRES:
    - Guau!

    Animales VOLADORES:
    - Cuác!

# Arquitectura

![1_yR4C1B-YfMh5zqpbHzTyag](https://github.com/user-attachments/assets/efe840ef-5b56-4ea5-9a04-d3af294eccfb)


## Estructura del Proyecto

![Imagen de WhatsApp 2025-02-25 a las 02 27 01_4db18e5e](https://github.com/user-attachments/assets/bcb6c8fa-a8b6-4651-a51d-54b8d1f8ead6)

# Pruebas

El proyecto incluye pruebas unitarias para validar la funcionalidad. Para ejecutarlas:

    1. Abre el proyecto en IntelliJ IDEA.
    2. Navega al archivo AnimalFactoryTest.
    3. Ejecuta las pruebas haciendo clic derecho sobre el archivo y seleccionando Run 'AnimalFactoryTest'.

Las pruebas cubren:

    1. Creación de animales existentes y no existentes.
    2. Manejo de nombres con diferentes formatos (mayúsculas, minúsculas, mixtas).
    3. Entradas vacías o nulas.

# Cobertura de Código con SonarCloud

![sonarcloud-logo](https://github.com/user-attachments/assets/1bacd1e7-2fd8-464a-bc84-95878514baa2)

Este proyecto utiliza SonarCloud para medir la cobertura de código y garantizar la calidad del código. La cobertura de código indica qué porcentaje del código fuente está siendo ejecutado durante las pruebas.

## Objeto de cobertura

El objetivo es alcanzar al menos un 70% de cobertura de código . Actualmente, el proyecto tiene una cobertura del 80.3%.
