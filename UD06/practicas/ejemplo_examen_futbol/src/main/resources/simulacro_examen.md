# Enunciado Simulacro Examen: Gestión de Liga Deportiva

## Contexto
Se requiere desarrollar una API RESTful para gestionar los equipos de una liga y los jugadores que pertenecen a ellos. El sistema debe permitir registrar equipos, fichar nuevos jugadores para un equipo específico, consultar la plantilla de un equipo y buscar jugadores por su posición en el campo.

## Requisitos Técnicos

### Entidades y Relaciones
- Un **Equipo** (1) está relacionado con muchos **Jugadores** (N). 
- Un jugador solo puede pertenecer a un equipo a la vez en esta base de datos.

**1. Equipo:**
- `id`: Identificador único (Autogenerado).
- `nombre`: Cadena de texto.
- `ciudad`: Cadena de texto.

**2. Jugador:**
- `id`: Identificador único (Autogenerado).
- `nombreCompleto`: Cadena de texto.
- `posicion`: Enum (`PORTERO`, `DEFENSA`, `MEDIOCAMPISTA`, `DELANTERO`).
- `salario`: Número decimal (`BigDecimal`).
- `equipo`: Relación con la entidad Equipo.

### Validaciones Requeridas
- El **`nombre`** del Equipo es **obligatorio** y debe tener una longitud mínima de 3 caracteres.
- El **`nombreCompleto`** del Jugador es **obligatorio**.
- El **`salario`** del Jugador debe ser un valor **mayor a 0**.
- La **`posicion`** del Jugador debe corresponder exactamente a uno de los valores definidos en el Enum.
*En caso de violación de cualquiera de estas reglas, la API debe retornar un código de estado `400 Bad Request` con un mensaje descriptivo.*

### Patrón DTO (Data Transfer Object) - OBLIGATORIO
Las Entidades (Equipo, Jugador) **no pueden** ser devueltas ni recibidas directamente en los Controladores.
Debes crear DTOs de Request y Response para aislar la base de datos y evitar la recursividad infinita (StackOverflow) al serializar el JSON.

---

## Endpoints a Desarrollar

**1. Registrar un nuevo Equipo**
- `POST /api/equipos`
- Body: `EquipoRequestDTO`
- Retorna: `EquipoResponseDTO` con estado `201 Created`.

**2. Fichar a un Jugador para un Equipo**
- `POST /api/equipos/{equipoId}/jugadores`
- Path variable: `equipoId`.
- Body: `JugadorRequestDTO` (no incluye el equipo, se saca de la URL).
- Lógica: Verificar que el equipo exista. Si no existe, devolver `404 Not Found`.
- Retorna: `JugadorResponseDTO` con estado `201 Created`.

**3. Obtener la plantilla completa de un Equipo**
- `GET /api/equipos/{equipoId}/jugadores`
- Path variable: `equipoId`.
- Lógica: Si el equipo no existe, devolver `404 Not Found`. Si existe pero no tiene jugadores, devolver `[]`.
- Retorna: Lista de `JugadorResponseDTO` y estado `200 OK`.

**4. Buscar equipos cuyo salario total supere un importe (Requiere `@Query`)**
- `GET /api/equipos/busqueda?salarioMinimo={importe}`
- Query parameter: `salarioMinimo` numérico.
- Lógica: Encontrar los equipos donde la suma del salario de todos sus jugadores sea mayor que el importe pasado por parámetro.
- Retorna: Lista de `EquipoResponseDTO`. Estado `200 OK`.
- *Pista:* Requiere un JOIN y la función de agregación `SUM()`, además de un `GROUP BY` y `HAVING`.

---

## Criterios de Evaluación
1. **Diseño Relacional**: Mapeo 1 a N correcto entre Equipo y Jugador.
2. **Uso de `@Query`**: Resolución de la consulta compleja de salarios mediante JPQL.
3. **Patrón DTO**: Uso estricto de DTOs con ModelMapper o mapeo manual.
4. **Validaciones**: Anotaciones de Spring Validation (`@NotBlank`, `@DecimalMin`, etc.) aplicadas en los DTOs.
5. **Manejo de Errores**: Uso de `try-catch` y relanzamiento de `ResponseStatusException` para devolver `404` o `400` según corresponda.
