# Biller Project - Sistema de Facturación

Sistema de gestión de facturación desarrollado con Spring Boot que proporciona una API RESTful completa para la administración de productos, categorías, clientes y facturas. El sistema incluye autenticación y autorización mediante JWT, integración con PostgreSQL y arquitectura lista para despliegue en contenedores Docker.

## 📋 Descripción del Proyecto

Biller Project es una aplicación backend robusta diseñada para gestionar operaciones de facturación empresarial. Permite a los usuarios administrar productos, categorías, clientes y generar facturas de manera eficiente. El sistema está construido siguiendo las mejores prácticas de desarrollo con Spring Boot 3.3.0 y Java 17, implementando seguridad mediante Spring Security y JWT tokens para proteger los endpoints de la API.

## 🚀 Tecnologías Utilizadas

- **Java 17** - Lenguaje de programación principal
- **Spring Boot 3.3.0** - Framework de desarrollo
- **Spring Data JPA** - Persistencia de datos
- **Spring Security** - Seguridad y autenticación
- **JWT (JSON Web Tokens)** - Autenticación basada en tokens
- **PostgreSQL** - Base de datos relacional
- **Lombok** - Reducción de código boilerplate
- **ModelMapper** - Mapeo entre entidades y DTOs
- **Maven** - Gestión de dependencias
- **Docker** - Contenedorización de la aplicación

## 📁 Estructura del Proyecto

```
biller-project/
├── src/
│   ├── main/
│   │   ├── java/com/grupo4/servicios/biller_project/
│   │   │   ├── auth/           # Configuración de autenticación
│   │   │   ├── configuration/  # Configuraciones de la aplicación
│   │   │   ├── controllers/    # Controladores REST
│   │   │   ├── dtos/           # Data Transfer Objects
│   │   │   ├── entities/       # Entidades JPA
│   │   │   ├── repositories/   # Repositorios de datos
│   │   │   └── services/       # Lógica de negocio
│   │   └── resources/          # Archivos de configuración
│   └── test/                   # Tests unitarios e integración
├── target/                     # Archivos compilados
├── Dockerfile                  # Configuración Docker
└── pom.xml                     # Configuración Maven
```

## ⚙️ Requisitos Previos

- Java 17 o superior
- Maven 3.6 o superior
- PostgreSQL 12 o superior
- Docker (opcional, para despliegue en contenedores)

## 🔧 Instalación y Configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/IAlexLizano/biller-project-services.git
cd biller-project-services
```

### 2. Configurar la base de datos

Crear una base de datos PostgreSQL y configurar las credenciales en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/biller_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

### 3. Compilar el proyecto

```bash
./mvnw clean install
```

O en Windows:

```bash
mvnw.cmd clean install
```

### 4. Ejecutar la aplicación

```bash
./mvnw spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

## 🐳 Despliegue con Docker

### Construir la imagen Docker

```bash
# Primero compilar el proyecto
./mvnw clean package

# Construir la imagen
docker build -t biller-project .
```

### Ejecutar el contenedor

```bash
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/biller_db \
  -e SPRING_DATASOURCE_USERNAME=tu_usuario \
  -e SPRING_DATASOURCE_PASSWORD=tu_contraseña \
  biller-project
```

## 📚 Funcionalidades Principales

- **Gestión de Productos**: CRUD completo para productos
- **Gestión de Categorías**: Administración de categorías de productos
- **Gestión de Clientes**: Registro y administración de clientes
- **Gestión de Facturas**: Creación y consulta de facturas
- **Autenticación JWT**: Sistema de autenticación seguro
- **Validación de Datos**: Validación automática de entradas
- **CORS Configurado**: Integración con frontend

## 🔐 Seguridad

El proyecto implementa:
- Autenticación basada en JWT
- Spring Security para protección de endpoints
- Validación de datos de entrada
- CORS configurado para comunicación con frontend

## 🌐 Endpoints Principales

### Autenticación
- `POST /api/auth/login` - Iniciar sesión
- `POST /api/auth/register` - Registrar usuario

### Productos
- `GET /api/products` - Listar todos los productos
- `POST /api/products` - Crear nuevo producto
- `GET /api/products/{id}` - Obtener producto por ID
- `PUT /api/products/{id}` - Actualizar producto
- `DELETE /api/products/{id}` - Eliminar producto

### Categorías
- `GET /api/categories` - Listar todas las categorías
- `POST /api/categories` - Crear nueva categoría
- `GET /api/categories/{id}` - Obtener categoría por ID
- `PUT /api/categories/{id}` - Actualizar categoría
- `DELETE /api/categories/{id}` - Eliminar categoría

### Clientes
- `GET /api/customers` - Listar todos los clientes
- `POST /api/customers` - Crear nuevo cliente
- `GET /api/customers/{id}` - Obtener cliente por ID
- `PUT /api/customers/{id}` - Actualizar cliente
- `DELETE /api/customers/{id}` - Eliminar cliente

### Facturas
- `GET /api/bills` - Listar todas las facturas
- `POST /api/bills` - Crear nueva factura
- `GET /api/bills/{id}` - Obtener factura por ID

## 🧪 Testing

Ejecutar los tests:

```bash
./mvnw test
```

## 👥 Colaboradores

Este proyecto ha sido desarrollado por:

### Desarrolladores Front-end
- **[IAlexLizano](https://github.com/IAlexLizano)** - Front-end Developer
- **[Davidl2002](https://github.com/Davidl2002)** - Front-end Developer

### Desarrolladores Back-end
- **[Jeffer2S](https://github.com/Jeffer2S)** - Back-end Developer
- **[TicheKiwar](https://github.com/TicheKiwar)** - Back-end Developer

## 📝 Licencia

Este proyecto es parte de un proyecto académico desarrollado por el Grupo 4.

## 🔗 Enlaces

- **Frontend**: [https://biller-project-services-front.onrender.com](https://biller-project-services-front.onrender.com)
- **Backend API**: Configurado para despliegue en Render

## 📧 Contacto

Para más información sobre el proyecto, contactar a los colaboradores a través de sus perfiles de GitHub.

---

**Versión**: 0.0.1-SNAPSHOT  
**Última actualización**: Diciembre 2024
