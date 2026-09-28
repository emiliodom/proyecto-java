```md
# Taller Formularios

Aplicación web desarrollada con Spring Boot y Thymeleaf para registrar jugadores de fútbol, visualizar la lista de inscritos y consultar el detalle de cada jugador.

## Descripción

Este proyecto permite:

- Registrar un jugador con nombre, edad y posición
- Guardar los datos en memoria
- Mostrar la lista completa de jugadores inscritos
- Consultar el detalle de un jugador específico
- Usar una interfaz web sencilla con HTML + Thymeleaf + CSS

Es una aplicación pequeña y didáctica, ideal para practicar formularios, MVC y plantillas en Spring.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring MVC
- Thymeleaf
- Maven

## Requisitos previos

Antes de ejecutar el proyecto asegúrate de tener instalado:

- Java 17 o superior
- Maven
- Git

## Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/taller-formularios.git
cd taller-formularios
```

## Ejecutar la aplicación

Desde la raíz del proyecto:

```bash
./mvnw spring-boot:run
```

En Windows:

```bash
mvnw.cmd spring-boot:run
```

Luego abre en tu navegador:

```text
http://localhost:8080/jugadores/nuevo
```

## Endpoints principales

- `GET /jugadores/nuevo` → muestra el formulario para registrar un jugador
- `POST /jugadores` → guarda el jugador enviado por el formulario
- `GET /jugadores` → lista todos los jugadores registrados
- `GET /jugadores/{numero}` → muestra el detalle de un jugador

## Estructura del proyecto

```text
taller-formularios/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── gt/edu/url/tallerformularios/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── service/
│   │   │       └── TallerFormulariosApplication.java
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   ├── templates/
│   │   │   └── application.properties
│   └── test/
│       └── java/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── Dockerfile
├── HELP.md
└── README.md
```

## Nota importante

La aplicación guarda los jugadores en memoria (`List<Jugador>`), por lo que los datos se pierden al reiniciar la aplicación.

## Autor

Tu nombre o nombre del equipo

## Licencia

Este proyecto está bajo la licencia MIT. Puedes crear tu propia licencia si lo deseas.

---

