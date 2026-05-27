# Enunciado Examen Práctico: Plataforma de Educación (Cursos y Estudiantes)

## Contexto
Se requiere desarrollar una API RESTful para la gestión académica de una institución educativa. El sistema permitirá administrar los cursos ofrecidos y los estudiantes matriculados en cada uno de ellos, permitiendo consultas específicas, actualizaciones de datos y manteniendo un control riguroso sobre las inscripciones.

## Requisitos Técnicos
- **Entidades y Relaciones**:
  - Un **Curso** (1) puede tener matriculados a muchos **Estudiantes** (N). 
  - Para simplificar la arquitectura, en este sistema un estudiante solo puede pertenecer a un curso (como un bootcamp o ciclo formativo de tiempo completo).

### Entidades

**Curso:**
- `id`: Identificador único (Autogenerado).
- `nombre`: Cadena de texto (ej: "Desarrollo Web Full-Stack").
- `profesorAsignado`: Cadena de texto.
- `creditos`: Número entero.

**Estudiante:**
- `id`: Identificador único (Autogenerado).
- `nombreCompleto`: Cadena de texto.
- `email`: Cadena de texto.
- `fechaMatriculacion`: Fecha (LocalDate / Date).
- `curso`: Relación con la entidad Curso.

### Validaciones Requeridas
- El **`nombre`** del Curso es **obligatorio** y debe ser único (si el stack lo permite fácilmente) o al menos no estar en blanco.
- Los **`creditos`** del Curso deben ser un **número positivo** mayor a cero.
- El **`email`** del Estudiante es **obligatorio** y debe tener un **formato de correo electrónico válido**.
- La **`fechaMatriculacion`** del Estudiante no puede ser una fecha futura (debe ser la fecha actual o una fecha pasada).
- En caso de fallar alguna validación, el servidor debe responder con un `400 Bad Request` informando del motivo.

### Endpoints a Desarrollar

Para añadir variedad, este examen incluye un endpoint de actualización completa (PUT):

1. **Crear un nuevo Curso**
   - `POST /api/cursos`
   - Body: Datos del curso.
   - Retorna: El curso creado y estado `201 Created`.

2. **Listar todos los Cursos disponibles**
   - `GET /api/cursos`
   - Retorna: Una lista de cursos. Estado `200 OK`.

3. **Matricular a un Estudiante en un Curso**
   - `POST /api/cursos/{cursoId}/estudiantes`
   - Path variable: `cursoId`.
   - Body: Datos del estudiante.
   - Lógica: Verificar que el curso exista. Si no existe, devolver `404 Not Found`.
   - Retorna: El estudiante matriculado y estado `201 Created`.

4. **Obtener el listado de Estudiantes de un Curso**
   - `GET /api/cursos/{cursoId}/estudiantes`
   - Path variable: `cursoId`.
   - Retorna: Lista de estudiantes del curso específico. Si el curso no existe, `404 Not Found`. Estado `200 OK`.

5. **Buscar un Estudiante por su Email**
   - `GET /api/estudiantes/busqueda?email={email}`
   - Query parameter: `email`.
   - Retorna: Los datos del estudiante si se encuentra, o un `404 Not Found` si no existe ningún estudiante con ese correo.

6. **Actualizar la información de un Estudiante**
   - `PUT /api/estudiantes/{id}`
   - Path variable: `id` del estudiante.
   - Body: Todos los datos del estudiante (nombre, email, fecha).
   - Lógica: Si el estudiante no existe, devolver `404 Not Found`. Si existe, se reemplazan sus datos validando de nuevo la información.
   - Retorna: El estudiante actualizado y estado `200 OK`.

7. **Dar de baja a un Estudiante (Eliminar)**
   - `DELETE /api/estudiantes/{id}`
   - Path variable: `id` del estudiante.
   - Retorna: Estado `204 No Content` si tuvo éxito o `404 Not Found` si no existía el estudiante.

## Criterios de Evaluación
1. **Configuración de Entidades**: Definición correcta de claves primarias y foráneas para la relación 1:N.
2. **Validaciones**: Uso adecuado de aserciones (`@Email`, `@PastOrPresent`, `@Positive`, etc., según el framework).
3. **Manejo de Errores Restful**: Controladores consistentes que devuelven los HTTP Status correctos.
4. **Implementación de PUT**: Capacidad para localizar una entidad existente, mutar su estado manteniendo la integridad y guardarla nuevamente.
5. **Uso de Query Parameters**: Extraer correctamente parámetros de la URL para filtrar búsquedas personalizadas.
