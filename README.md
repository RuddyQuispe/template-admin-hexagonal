# 🛠️ Template de Administración con Spring Boot 3.5

![Java](https://img.shields.io/badge/Java-21-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-latest-blue)
![Build](https://img.shields.io/badge/build-passing-brightgreen)
![License](https://img.shields.io/badge/license-Apache-blue.svg)
![Swagger](https://img.shields.io/badge/docs-Swagger%20UI-blue)

## 📌 Descripción

Este proyecto es un **template de administración** que utiliza **Spring Boot 3.5**, **Java 21** y sigue el patrón de **Arquitectura Hexagonal**.
Está diseñado para facilitar el desarrollo de la parte administrativa de un sistema, proporcionando una estructura
limpia y modular.

---

## 🚀 Tecnologías y Herramientas

- **Java 21**
- **Spring Boot 3.5**
- **Spring Data JPA / Hibernate**
- **MapStruct** – para mapeo automático de DTOs
- **PostgreSQL** – como base de datos relacional
- **Swagger / OpenAPI** – para documentación interactiva de APIs
- **Lombok** – para reducir boilerplate
- **Spring Validation** – para validaciones de entrada
- **Maven / Gradle** – gestión de dependencias (según tu elección)

---

## 📁 Estructura del Proyecto

```textplain
└── src
    └── main
        ├── java
        │   └── edu
        │       └── bo
        │           └── uyunicode
        │               └── template
        │                   └── admin
        │                       ├── application
        │                       │   ├── input
        │                       │   ├── output
        │                       │   └── service
        │                       ├── domain
        │                       │   ├── dto
        │                       │   │   ├── request
        │                       │   │   └── response
        │                       │   ├── entity
        │                       │   ├── exceptions
        │                       │   ├── mappers
        │                       │   └── models
        │                       ├── infrastructure
        │                       │   ├── persistence
        │                       │   │   └── repository
        │                       │   └── rest
        │                       └── utils
        └── resources
```

---

## 🔧 Configuración Inicial

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/RuddyQuispe/template-admin-hexagonal.git
   cd template-admin-hexagonal
   ```

---

## 📖 Documentación de la API

Una vez ejecutado, accede a la documentación Swagger en:

   ```
   http://localhost:8080/swagger-ui/index.html
   ```

## 📖 Documentación de codigo (Javadoc)

```bash
   mvn javadoc:jar 
```

Una vez ejecutado, accede a la documentación en:

```
   file:///${PROJECT_PATH}/template-administration/target/apidocs/index.html
```

## ✅ Estado del Proyecto

- [x] Estructura base con Arquitectura Hexagonal
- [x] Integración con PostgreSQL
- [x] Documentación Swagger activa
- [x] Mapeos DTO con MapStruct
- [ ] Autenticación y autorización (pendiente)
- [ ] Pruebas unitarias y de integración
- [ ] Dockerización avanzada
