# Enunciado Examen Práctico: Gestión de Biblioteca

## Contexto
Se requiere desarrollar una API RESTful para gestionar los autores y sus respectivos libros en el catálogo de una biblioteca. El sistema debe permitir registrar autores, añadir nuevos libros a su repertorio, realizar búsquedas específicas por género y gestionar el catálogo general.

## Requisitos Técnicos
- **Entidades y Relaciones**:
  - Un **Autor** (1) está relacionado con muchos **Libros** (N). 
  - Un autor puede haber escrito muchos libros, pero en este sistema, cada libro pertenece a un solo autor principal.

### Entidades

**Autor:**
- `id`: Identificador único (Autogenerado).
- `nombre`: Cadena de texto.
- `nacionalidad`: Cadena de texto.

**Libro:**
- `id`: Identificador único (Autogenerado).
- `titulo`: Cadena de texto.
- `genero`: Enum (`FICCIÓN`, `NO_FICCIÓN`, `CIENCIA`, `TERROR`, `FANTASÍA`).
- `anioPublicacion`: Número entero.
- `autor`: Relación con la entidad Autor.

### Validaciones Requeridas
- El **`nombre`** del Autor es **obligatorio** y debe tener una longitud mínima de 3 caracteres.
- El **`titulo`** del Libro es **obligatorio** y no puede estar compuesto solo de espacios en blanco.
- El **`anioPublicacion`** del Libro **no puede ser mayor al año actual** (ej. no se pueden registrar libros del 2028).
- El **`genero`** del Libro debe corresponder exactamente a uno de los valores definidos en el Enum. En caso de violación de cualquiera de estas reglas, la API debe retornar un código de estado `400 Bad Request` con un mensaje claro del error.

### Patrón DTO (Data Transfer Object) - REQUISITO OBLIGATORIO
Queda **estrictamente prohibido** exponer las Entidades de la base de datos (Autor, Libro) directamente a través de los Controladores REST. 
Debes implementar DTOs y una capa de mapeo (manual o usando librerías como MapStruct o ModelMapper) para aislar tu base de datos:
- **Para Creación (Request DTOs)**: Objetos que reciban solo los datos necesarios para crear un recurso (aplicando aquí las validaciones como `@NotBlank` o `@NotNull`).
- **Para Respuestas (Response DTOs)**: Objetos que devuelvan los datos formateados. Esto evitará además el clásico error de **recursividad infinita** (StackOverflow) al serializar a JSON la relación bidireccional entre Autor y Libro.

### Endpoints a Desarrollar

A diferencia del ejercicio anterior, aquí se proponen rutas anidadas para reflejar mejor la pertenencia de los recursos, así como búsquedas por query parameters:

1. **Registrar un nuevo Autor**
   - `POST /api/autores`
   - Body: `AutorRequestDTO`
   - Retorna: `AutorResponseDTO` con estado `201 Created`.

2. **Listar el directorio de Autores**
   - `GET /api/autores`
   - Retorna: Una lista de `AutorResponseDTO`. Estado `200 OK`.

3. **Añadir un Libro al repertorio de un Autor**
   - `POST /api/autores/{autorId}/libros`
   - Path variable: `autorId`.
   - Body: `LibroRequestDTO` (sin incluir al autor, ya que se infiere de la ruta).
   - Lógica: Verificar que el autor exista en la base de datos. Si no existe, devolver `404 Not Found`.
   - Retorna: `LibroResponseDTO` con estado `201 Created`.

4. **Obtener la bibliografía completa de un Autor**
   - `GET /api/autores/{autorId}/libros`
   - Path variable: `autorId`.
   - Lógica: Si el autor no existe, devolver `404 Not Found`. Si el autor existe pero aún no tiene libros registrados, devolver una lista vacía `[]`.
   - Retorna: Lista de `LibroResponseDTO` y estado `200 OK`.

5. **Buscar libros por género en todo el catálogo**
   - `GET /api/libros/busqueda?genero={genero}`
   - Query parameter: `genero` (ej: `?genero=FANTASÍA`).
   - Retorna: Lista de `LibroResponseDTO` que coincidan con ese género. Estado `200 OK`.

6. **Retirar un Libro del catálogo**
   - `DELETE /api/libros/{id}`
   - Path variable: `id` del libro.
   - Lógica: Eliminar el libro correspondiente. Si el libro no se encuentra, devolver `404 Not Found`.
   - Retorna: Estado `204 No Content`.

7. **Buscar autores que hayan escrito libros de un género específico (Requiere `@Query`)**
   - `GET /api/autores/busqueda?genero={genero}`
   - Query parameter: `genero` (ej: `?genero=TERROR`).
   - Lógica: Encontrar aquellos autores que tengan al menos un libro del género especificado.
   - Retorna: Lista de `AutorResponseDTO` (sin duplicados). Estado `200 OK`.
   - *Pista para la solución:* Requiere un `JOIN` explícito en JPQL entre la tabla de Autor y Libro.

8. **Buscar libros publicados en un rango de años, ordenados alfabéticamente (Requiere `@Query`)**
   - `GET /api/libros/rango?desde={anioInicio}&hasta={anioFin}`
   - Query parameters: `desde` y `hasta` numéricos.
   - Retorna: Lista de `LibroResponseDTO` publicados entre esos dos años (ambos inclusive), ordenados alfabéticamente por su título. Estado `200 OK`.
   - *Pista para la solución:* Requiere utilizar la cláusula `BETWEEN` o condicionales `>=` y `<=`, además de un `ORDER BY` en JPQL.

## Criterios de Evaluación
1. **Diseño Relacional**: Correcta configuración y mapeo de la relación 1 a N en base de datos.
2. **Consultas Complejas**: Uso adecuado de `@Query` y JPQL para resolver búsquedas avanzadas y cruces de tablas.
3. **Patrón DTO y Mapeo (NUEVO)**: Estricto uso de DTOs en las peticiones y respuestas, asegurando que las entidades no llegan a la capa web. Prevención exitosa de problemas de recursividad JSON.
4. **Validaciones**: Implementación estricta de las reglas de negocio descritas, aplicadas sobre los DTOs de entrada.
5. **Manejo de Errores**: Respuestas HTTP correctas (`400`, `404`, `201`, `204`, etc.) ante escenarios exitosos y fallidos.
6. **Diseño de Endpoints**: Correcto parseo de rutas anidadas (`/autores/{id}/libros`) y uso de Query Parameters para la búsqueda.
7. **Arquitectura Limpia**: Separación de responsabilidades clara (Controladores, Capa de Servicio, Repositorios).
