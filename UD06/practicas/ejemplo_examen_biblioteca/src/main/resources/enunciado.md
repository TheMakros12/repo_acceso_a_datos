# Enunciado Examen Práctico: Plataforma de Gestión de Bibliotecas (Bibliotecas y Libros)

## Contexto
Se requiere desarrollar una API RESTful para la gestión de una red de bibliotecas digitales y físicas. El sistema permitirá administrar las bibliotecas registradas en la plataforma y los libros que se encuentran en el catálogo de cada una, permitiendo consultas específicas, actualizaciones de datos y control de inventario mediante el estado de disponibilidad de cada libro.

## Requisitos Técnicos
- **Entidades y Relaciones**:
    - Una **Biblioteca** (1) puede tener muchos **Libros** (N).
    - Para simplificar la arquitectura, en este sistema un libro solo pertenece a una idBiblioteca (cada idBiblioteca mantiene su propio catálogo).

### Entidades

**Biblioteca:**
- `id`: Identificador único (Autogenerado).
- `nombre`: Cadena de texto (ej: "Biblioteca Central de Madrid").
- `ubicacion`: Cadena de texto (ej: "Calle Mayor, 15").
- `anoApertura`: Número entero.
- `numeroLibrosTotal`: Número entero.

**Libro:**
- `id`: Identificador único (Autogenerado).
- `titulo`: Cadena de texto.
- `autor`: Cadena de texto.
- `isbn`: Cadena de texto (formato único).
- `anoPublicacion`: Número entero.
- `estado`: Enumeración (DISPONIBLE, PRESTADO, DAÑADO, DESCATALOGADO).
- `idBiblioteca`: Relación con la entidad Biblioteca.

### Validaciones Requeridas
- El **`nombre`** de la Biblioteca es **obligatorio** y debe ser único o al menos no estar en blanco.
- La **`ubicacion`** de la Biblioteca es **obligatoria**.
- El **`anoApertura`** de la Biblioteca debe ser un **número menor o igual al año actual**.
- El **`numeroLibrosTotal`** de la Biblioteca debe ser un **número positivo** mayor a cero.
- El **`titulo`** del Libro es **obligatorio**.
- El **`autor`** del Libro es **obligatorio**.
- El **`isbn`** del Libro es **obligatorio** y debe tener un **formato único de 10 o 13 dígitos**.
- El **`anoPublicacion`** del Libro debe ser un **número menor o igual al año actual**.
- El **`estado`** del Libro debe ser uno de los valores válidos de la enumeración (DISPONIBLE, PRESTADO, DAÑADO, DESCATALOGADO).
- En caso de fallar alguna validación, el servidor debe responder con un `400 Bad Request` informando del motivo.

### Enumeración de Estados de Libro

Los estados disponibles para un libro son los siguientes:

| Valor ENUM | Descripción |
|-----------|-----------|
| `DISPONIBLE` | Libro disponible para préstamo |
| `PRESTADO` | Libro actualmente prestado a un usuario |
| `DAÑADO` | Libro dañado, no disponible para préstamo |
| `DESCATALOGADO` | Libro eliminado del catálogo |

### Endpoints a Desarrollar

Se requieren exactamente **4 endpoints diferentes** para este examen:

1. **Crear una nueva Biblioteca**
    - `POST /api/bibliotecas`
    - Body: **`BibliotecaRequestDTO`** (datos de la idBiblioteca a crear, sin ID).
    - Retorna: **`BibliotecaResponseDTO`** y estado `201 Created`.

2. **Agregar un nuevo Libro al catálogo de una Biblioteca**
    - `POST /api/bibliotecas/{bibliotecaId}/libros`
    - Path variable: `bibliotecaId`.
    - Body: **`LibroRequestDTO`** (datos del libro a agregar, sin ID).
    - Lógica: Verificar que la idBiblioteca exista. Si no existe, devolver `404 Not Found`. Si existe, crear el libro asociado a esa idBiblioteca.
    - Retorna: **`LibroResponseDTO`** y estado `201 Created`.

3. **Buscar un Libro por su ISBN**
    - `GET /api/libros/busqueda?isbn={isbn}`
    - Query parameter: `isbn`.
    - Retorna: **`LibroResponseDTO`** si se encuentra, o un `404 Not Found` si no existe ningún libro con ese ISBN.

4. **Cambiar el estado de un Libro**
    - `PATCH /api/libros/{id}/cambiar-estado?estado={estado}`
    - Path variable: `id` del libro.
    - Query parameter: `estado` (uno de los valores válidos del ENUM).
    - Lógica: Si el libro no existe, devolver `404 Not Found`. Si existe, cambiar su estado actual por el nuevo estado proporcionado.
    - Retorna: **`LibroResponseDTO`** actualizado y estado `200 OK`.

## Criterios de Evaluación
1. **Configuración de Entidades**: Definición correcta de claves primarias y foráneas para la relación 1:N.
2. **Validaciones**: Uso adecuado de aserciones (`@Pattern` para ISBN, `@NotBlank`, `@Positive`, `@Min`, etc., según el framework).
3. **Manejo de Errores RESTful**: Controladores consistentes que devuelven los HTTP Status correctos (`201`, `200`, `404`, `400`).
4. **Implementación de PATCH**: Capacidad para modificar una propiedad específica (el estado) sin afectar el resto de datos.
5. **Uso de Query Parameters**: Extraer correctamente parámetros de la URL para filtrar búsquedas personalizadas y cambios de estado.
6. **Arquitectura limpia**: Separación correcta entre Controllers, Services, Repositories y DTOs.

---

## Notas Importantes

- El **`estado`** del libro es un **ENUM** y solo puede tomar los valores: DISPONIBLE, PRESTADO, DAÑADO, DESCATALOGADO.
- El **`anoApertura`** no puede ser mayor al año actual.
- El **`anoPublicacion`** no puede ser mayor al año actual.
- El **`isbn`** debe ser único en el sistema y seguir un formato válido (10 o 13 dígitos).
- Se espera que utilices **ModelMapper** o similar para la conversión entre entidades y DTOs.
- El endpoint de cambio de estado (PATCH) es especial porque modifica solo una propiedad sin tocar el resto de datos.
- El manejo de excepciones debe ser consistente y devolver mensajes claros al cliente.