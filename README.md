# 🚗 Concesionario - Sistema de Órdenes de Trabajo

Este proyecto es una API REST desarrollada con **Spring Boot**, que permite gestionar vehículos y órdenes de trabajo asociadas a ellos. Incluye autenticación con **JWT**, validaciones, manejo global de errores y perfiles de entorno para facilitar su despliegue.

---

## 🧰 Tecnologías Utilizadas

- ✅ Spring Boot 3+
- 🔐 Spring Security + JWT
- 🗃️ PostgreSQL
- 🧪 JUnit
- 🌱 Perfiles de entorno: `local` y `dev`

---

## 🚀 Instalación y ejecución

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/concesionario-ordenes-trabajo.git
cd concesionario-ordenes-trabajo
```

### 2️⃣ Configurar los perfiles

El proyecto está preparado para trabajar con perfiles de entorno. Puedes usar:

- `local`: configuración local sin base de datos real (en memoria).
- `dev`: configuración para desarrollo real con base de datos PostgreSQL.

Edita el archivo `application.properties` para cambiar el perfil activo:

```properties
spring.profiles.active=local
```

También puedes usar la variable de entorno:

```bash
SPRING_PROFILES_ACTIVE=local
```

---

## ▶️ Ejecutar el proyecto

Usa Maven o tu IDE favorito:

```bash
./mvnw spring-boot:run
```

---

## 🔐 Autenticación

El sistema utiliza autenticación JWT. Para probarlo:

1. Inicia sesión:
   - **POST** `/auth/login`
   - Cuerpo JSON:
     ```json
     {
       "username": "admin",
       "password": "admin123"
     }
     ```

2. Usa el token en tus peticiones:
   - En Postman o similar, añade el token en los headers:
     ```
     Authorization: Bearer <tu-token>
     ```

---

## 📫 Endpoints principales

| Método | Endpoint                     | Descripción                         |
|--------|------------------------------|-------------------------------------|
| POST   | `/auth/login`                | Obtener token JWT                   |
| POST   | `/api/vehiculos`             | Crear un nuevo vehículo             |
| GET    | `/api/vehiculos`             | Listar vehículos                    |
| GET    | `/api/vehiculos/{id}`        | Obtener vehículo por ID             |
| PUT    | `/api/vehiculos/{id}`        | Actualizar vehículo                 |
| DELETE | `/api/vehiculos/{id}`        | Eliminar vehículo                   |
| POST   | `/api/ordenes/vehiculo/{id}` | Crear orden de trabajo              |
| PUT    | `/api/ordenes/{id}/cerrar`   | Cerrar orden de trabajo             |
| GET    | `/api/ordenes/vehiculo/{id}` | Ver órdenes por vehículo            |

---

## 📦 Colección Postman

👉 Puedes importar y probar todos los endpoints fácilmente desde esta colección:

🔗 [Ir a la colección de Postman](https://reto77.postman.co/workspace/My-Workspace~7ce6a182-b5c2-4fa8-8d32-f83d82a5e5e0/request/16188387-ffee52e0-20cb-4135-a622-77b324a1f3d6?action=share&creator=16188387&ctx=documentation)

---

## 🧪 Tests

Ejecuta las pruebas unitarias con:

```bash
./mvnw test
```

---

## 🧑‍💻 Autor

Desarrollado por **Santiago Arboleda** como parte de una prueba técnica para desarrollador web fullstack junior.

---

