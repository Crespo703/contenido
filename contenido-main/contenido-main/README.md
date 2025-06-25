🎬 API de Gestión de Contenido - Cine Plus
Este proyecto es una API REST desarrollada en Java con Spring Boot para gestionar contenido audiovisual como películas, series o documentales, simulando una plataforma de streaming llamada Cine Plus. Incluye endpoints para crear, consultar, actualizar y eliminar contenido, y utiliza prácticas modernas como documentación automática y HATEOAS.

🚀 Objetivo del Proyecto
Implementar un microservicio REST completo.
Aplicar principios de arquitectura por capas.
Usar Swagger para documentar la API.
Incorporar HATEOAS para mejorar la navegabilidad de las respuestas.
Gestionar dependencias con Maven.
⚙️ Tecnologías Usadas
Java 17
Spring Boot
Spring Web
Spring Data JPA
Spring HATEOAS
Swagger (Springdoc)
Maven
H2 (base de datos en memoria por defecto)
📦 Funcionalidades
GET /api/contenido → Listar todo el contenido
GET /api/contenido/{id} → Obtener contenido por ID
POST /api/contenido → Crear contenido nuevo
PUT /api/contenido/{id} → Actualizar contenido existente
DELETE /api/contenido/{id} → Eliminar contenido
Estructura y descripción de carpetas y archivos clave
📁 .mvn, mvnw, mvnw.cmd, pom.xml
.mvn/ y mvnw / mvnw.cmd:
Permiten ejecutar Maven sin necesidad de tenerlo instalado globalmente en tu equipo, asegurando consistencia entre diferentes entornos.

pom.xml:
Archivo clave de Maven donde se definen las dependencias del proyecto (por ejemplo, Spring Boot, Swagger, etc.), plugins y configuración general del build.

📁 src/main/java/cine/plus/cl/contenido
Este es el paquete principal que contiene el código fuente organizado siguiendo el patrón MVC y en capas.

Subpaquetes y sus funciones:
assemblers
Contiene clases como ContenidoModelAssembler.java, que se utilizan para convertir entidades del modelo en representaciones enriquecidas para APIs REST (por ejemplo, con enlaces HATEOAS).

config
Aquí se encuentran configuraciones adicionales del proyecto, como SwaggerConfig.java, que habilita y personaliza Swagger para la documentación automática de APIs REST.

controller
Contiene los controladores REST o “endpoints”:

ContenidoController.java: Controlador principal para gestionar solicitudes relacionadas con "contenido".
ContenidoControllerV2.java: Versión 2 del controlador, usada para evolucionar la API sin romper la versión anterior.
model
Contiene las clases de modelo o entidades, como Contenido.java, que representan los datos del dominio y suelen estar mapeadas a tablas en la base de datos.

repository
Interfaces como ContenidoRepository.java que extienden de JpaRepository o similares, proporcionando acceso a la base de datos sin necesidad de escribir SQL explícito.

service
Contiene la lógica de negocio, por ejemplo ContenidoService.java, que actúa como capa intermedia entre controladores y repositorios.

ContenidoApplication.java
Clase principal con el método main, que es el punto de entrada para la aplicación Spring Boot.

📁 src/main/resources
Aquí se colocan archivos de configuración y recursos estáticos:

Archivos como application.properties o application.yml para configurar la aplicación.
Plantillas, vistas o recursos estáticos si aplica.
📁 src/test
Contiene pruebas unitarias y de integración para asegurar la calidad y correcto funcionamiento del código.

📌 Resumen de las capas y responsabilidades
Capa	Función
controller	Expone los endpoints REST para interactuar con la aplicación
service	Contiene la lógica de negocio
repository	Acceso y manipulación de datos en la base de datos
model	Representación de los datos o entidades de dominio
assembler	Convierte modelos en DTOs enriquecidos (p. ej. con HATEOAS)
config	Configuraciones adicionales (Swagger, seguridad, etc.)