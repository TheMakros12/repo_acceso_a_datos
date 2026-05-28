# Enunciado Examen Práctico: Plataforma de Gestión de Empresas (Empresas y Empleados)

## Contexto
Se requiere desarrollar una API RESTful para la gestión de recursos humanos de múltiples empresas. El sistema permitirá administrar las empresas registradas en la plataforma y los empleados contratados en cada una de ellas, permitiendo consultas específicas, actualizaciones de datos y mantenimiento de la integridad de las relaciones laborales.

## Requisitos Técnicos
- **Entidades y Relaciones**:
    - Una **Empresa** (1) puede tener empleados a muchos **Empleados** (N).
    - Para simplificar la arquitectura, en este sistema un empleado solo pertenece a una empresa (tiempo completo en una única compañía).
### Entidades

**Empresa:**
- `id`: Identificador único (Autogenerado).
- `nombre`: Cadena de texto (ej: "Tech Solutions S.L.").
- `sector`: Cadena de texto (ej: "Tecnología", "Finanzas", "Educación").
- `anoFundacion`: Número entero.
- `ingresosAnuales`: Número decimal.


**Empleado:**
- `id`: Identificador único (Autogenerado).
- `nombreCompleto`: Cadena de texto.
- `puesto`: Enumeración (DESARROLLADOR, ANALISTA, GERENTE, DIRECTOR_RECURSOS_HUMANOS).
- `salario`: Número decimal.
- `email`: Cadena de texto.
- `fechaContratacion`: Fecha (LocalDate / Date).
- `empresa`: Relación con la entidad Empresa.

### Enumeración de Puestos

Los puestos disponibles para un empleado son los siguientes:

| Valor ENUM | Descripción |
|-----------|-----------|
| `DESARROLLADOR` | Desarrollador de software |
| `ANALISTA` | Analista de sistemas |
| `GERENTE` | Gerente de proyecto/área |
| `DIRECTOR_RECURSOS_HUMANOS` | Director de Recursos Humanos |

### Validaciones Requeridas
- El **`nombre`** de la Empresa es **obligatorio** y debe ser único (si el stack lo permite fácilmente) o al menos no estar en blanco.
- El **`sector`** de la Empresa es **obligatorio**.
- El **`anoFundacion`** de la Empresa debe ser un **número menor o igual al año actual**.
- Los **`ingresosAnuales`** de la Empresa deben ser un **número positivo** mayor a cero.
- El **`nombreCompleto`** del Empleado es **obligatorio**.
- El **`puesto`** del Empleado es **obligatorio**.
- El **`salario`** del Empleado debe ser un **número positivo** mayor a cero.
- El **`email`** del Empleado es **obligatorio** y debe tener un **formato de correo electrónico válido**.
- La **`fechaContratacion`** del Empleado no puede ser una fecha futura (debe ser la fecha actual o una fecha pasada).
- En caso de fallar alguna validación, el servidor debe responder con un `400 Bad Request` informando del motivo.
### Endpoints a Desarrollar

Se requieren exactamente **4 endpoints diferentes** para este examen:

1. **Crear una nueva Empresa**
    - `POST /api/empresas`
    - Body: **`EmpresaRequestDTO`** (datos de la empresa a crear, sin ID).
    - Retorna: **`EmpresaResponseDTO`** y estado `201 Created`.
2. **Contratar un nuevo Empleado en una Empresa**
    - `POST /api/empresas/{empresaId}/empleados`
    - Path variable: `empresaId`.
    - Body: **`EmpleadoRequestDTO`** (datos del empleado a contratar, sin ID).
    - Lógica: Verificar que la empresa exista. Si no existe, devolver `404 Not Found`. Si existe, crear el empleado asociado a esa empresa.
    - Retorna: **`EmpleadoResponseDTO`** y estado `201 Created`.
3. **Buscar un Empleado por su Email**
    - `GET /api/empleados/busqueda?email={email}`
    - Query parameter: `email`.
    - Retorna: **`EmpleadoResponseDTO`** si se encuentra, o un `404 Not Found` si no existe ningún empleado con ese correo.
4. **Actualizar la información de un Empleado**
    - `PUT /api/empleados/{id}`
    - Path variable: `id` del empleado.
    - Body: **`EmpleadoRequestDTO`** (todos los datos del empleado, sin ID).
    - Lógica: Si el empleado no existe, devolver `404 Not Found`. Si existe, se reemplazan sus datos validando de nuevo la información.
    - Retorna: **`EmpleadoResponseDTO`** actualizado y estado `200 OK`.
## Criterios de Evaluación
1. **Configuración de Entidades**: Definición correcta de claves primarias y foráneas para la relación 1:N.
2. **Validaciones**: Uso adecuado de aserciones (`@Email`, `@PastOrPresent`, `@Positive`, `@NotBlank`, etc., según el framework).
3. **Manejo de Errores RESTful**: Controladores consistentes que devuelven los HTTP Status correctos (`201`, `200`, `404`, `400`).
4. **Implementación de PUT**: Capacidad para localizar una entidad existente, mutar su estado manteniendo la integridad y guardarla nuevamente.
5. **Uso de Query Parameters**: Extraer correctamente parámetros de la URL para filtrar búsquedas personalizadas.
6. **Arquitectura limpia**: Separación correcta entre Controllers, Services, Repositories y DTOs.


---