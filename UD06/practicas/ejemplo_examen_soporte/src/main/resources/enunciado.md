# Enunciado Examen Práctico: Plataforma de Gestión de Tickets de Soporte (Proyectos y Tickets)

## Contexto
Se requiere desarrollar una API RESTful para la gestión de tickets de soporte técnico en una empresa de servicios de TI. El sistema permitirá administrar los proyectos/clientes y los tickets de soporte asociados a cada uno, permitiendo consultas específicas, actualizaciones de datos y gestión del ciclo de vida de cada ticket mediante transiciones de estado progresivas e irreversibles.

## Requisitos Técnicos
- **Entidades y Relaciones**:
    - Un **Proyecto** (1) puede tener muchos **Tickets** (N).
    - Para simplificar la arquitectura, en este sistema un ticket solo pertenece a un proyecto.

### Entidades

**Proyecto:**
- `id`: Identificador único (Autogenerado).
- `nombre`: Cadena de texto (ej: "Cliente Tech Solutions").
- `descripcion`: Cadena de texto.
- `fechaInicio`: Fecha (LocalDate / Date).
- `presupuesto`: Número decimal.

**Ticket:**
- `id`: Identificador único (Autogenerado).
- `titulo`: Cadena de texto.
- `descripcion`: Cadena de texto.
- `prioridad`: Enumeración (BAJA, MEDIA, ALTA).
- `estado`: Enumeración (ABIERTO, EN_PROGRESO, CERRADO).
- `fechaCreacion`: Fecha (LocalDate / Date).
- `proyecto`: Relación con la entidad Proyecto.

### Validaciones Requeridas
- El **`nombre`** del Proyecto es **obligatorio** y debe ser único o al menos no estar en blanco.
- La **`descripcion`** del Proyecto es **obligatoria**.
- La **`fechaInicio`** del Proyecto no puede ser una fecha futura.
- El **`presupuesto`** del Proyecto debe ser un **número positivo** mayor a cero.
- El **`titulo`** del Ticket es **obligatorio**.
- La **`descripcion`** del Ticket es **obligatoria**.
- La **`prioridad`** del Ticket debe ser uno de los valores válidos (BAJA, MEDIA, ALTA).
- El **`estado`** del Ticket debe ser uno de los valores válidos (ABIERTO, EN_PROGRESO, CERRADO).
- La **`fechaCreacion`** del Ticket no puede ser una fecha futura.
- En caso de fallar alguna validación, el servidor debe responder con un `400 Bad Request` informando del motivo.

### Enumeración de Estados de Ticket (Transiciones Progresivas)

Los estados disponibles para un ticket son los siguientes, con transiciones **irreversibles**:

| Valor ENUM | Descripción | Siguiente estado |
|-----------|-----------|----------|
| `ABIERTO` | Ticket recién creado, pendiente de asignación | EN_PROGRESO |
| `EN_PROGRESO` | Ticket asignado, en proceso de resolución | CERRADO |
| `CERRADO` | Ticket completado, no puede cambiar de estado | ❌ No puede cambiar |

**Lógica de transiciones:**
- Un ticket en estado **ABIERTO** puede transicionar a **EN_PROGRESO**.
- Un ticket en estado **EN_PROGRESO** puede transicionar a **CERRADO**.
- Un ticket en estado **CERRADO** **NO puede cambiar de estado**. Intentar cambiar el estado de un ticket cerrado debe devolver `400 Bad Request`.

### Enumeración de Prioridades

| Valor ENUM | Descripción |
|-----------|-----------|
| `BAJA` | Problema no urgente |
| `MEDIA` | Problema moderado |
| `ALTA` | Problema crítico |

### Endpoints a Desarrollar

Se requieren exactamente **4 endpoints diferentes** para este examen:

1. **Crear un nuevo Proyecto**
    - `POST /api/proyectos`
    - Body: **`ProyectoRequestDTO`** (datos del proyecto a crear, sin ID).
    - Retorna: **`ProyectoResponseDTO`** y estado `201 Created`.

2. **Crear un nuevo Ticket en un Proyecto**
    - `POST /api/proyectos/{proyectoId}/tickets`
    - Path variable: `proyectoId`.
    - Body: **`TicketRequestDTO`** (datos del ticket a crear, sin ID).
    - Lógica: Verificar que el proyecto exista. Si no existe, devolver `404 Not Found`. Si existe, crear el ticket asociado a ese proyecto. El estado inicial de todo ticket es **ABIERTO**.
    - Retorna: **`TicketResponseDTO`** y estado `201 Created`.

3. **Buscar un Ticket por su Título**
    - `GET /api/tickets/busqueda?titulo={titulo}`
    - Query parameter: `titulo`.
    - Retorna: **`TicketResponseDTO`** si se encuentra, o un `404 Not Found` si no existe ningún ticket con ese título.

4. **Avanzar el Estado de un Ticket (Progresión)**
    - `PATCH /api/tickets/{id}/avanzar-estado`
    - Path variable: `id` del ticket.
    - Lógica:
        - Si el ticket no existe, devolver `404 Not Found`.
        - Si el ticket está en estado **ABIERTO**, cambiar a **EN_PROGRESO**.
        - Si el ticket está en estado **EN_PROGRESO**, cambiar a **CERRADO**.
        - Si el ticket está en estado **CERRADO**, devolver `400 Bad Request` con el mensaje: "El ticket ya está cerrado y no puede cambiar de estado".
    - Retorna: **`TicketResponseDTO`** actualizado y estado `200 OK`.

## Criterios de Evaluación
1. **Configuración de Entidades**: Definición correcta de claves primarias y foráneas para la relación 1:N.
2. **Validaciones**: Uso adecuado de aserciones (`@NotBlank`, `@Positive`, `@PastOrPresent`, etc., según el framework).
3. **Manejo de Errores RESTful**: Controladores consistentes que devuelven los HTTP Status correctos (`201`, `200`, `404`, `400`).
4. **Lógica de Transiciones de Estado**: Implementación correcta de las reglas de progresión (ABIERTO → EN_PROGRESO → CERRADO), con validación de que no se permite retroceder ni avanzar desde CERRADO.
5. **Uso de Query Parameters**: Extraer correctamente parámetros de la URL para filtrar búsquedas personalizadas.
6. **Arquitectura limpia**: Separación correcta entre Controllers, Services, Repositories y DTOs.

---

## Notas Importantes

- El **estado** de un ticket sigue una **progresión irreversible**: ABIERTO → EN_PROGRESO → CERRADO.
- Un ticket **CERRADO no puede volver a estados anteriores** ni cambiar de estado.
- Todos los tickets **se crean en estado ABIERTO** automáticamente.
- El endpoint de avance de estado es especial: **no acepta parámetros de entrada** (solo calcula el siguiente estado basado en el actual).
- Se espera que utilices **ModelMapper** o similar para la conversión entre entidades y DTOs.
- El manejo de excepciones debe ser consistente y devolver mensajes claros al cliente.
- La **`fechaInicio`** no puede ser mayor al año actual.
- La **`fechaCreacion`** de un ticket no puede ser una fecha futura.