package org.example.model;

import java.util.List;

public interface InterfaceDAO<T> {

    /**
     * Inserta un objeto en la base de datos.
     * @param obj Objeto a insertar.
     * @return Número de filas afectadas.
     */
    int insertar(T obj);

    /**
     * Actualiza un objeto existente en la base de datos.
     * @param obj Objeto con los datos actualizados.
     * @return Número de filas afectadas.
     */
    int actualizar(T obj);

    /**
     * Elimina un objeto de la base de datos.
     * @param obj Objeto a eliminar.
     * @return Número de filas afectadas.
     */
    int eliminar(T obj);

    /**
     * Busca un objeto específico en la base de datos.
     * @param id Identificador del objeto a buscar.
     * @return Objeto encontrado o null si no existe.
     */
    T buscarPorId(int id);

    /**
     * Obtiene todos los objetos de una tabla en la base de datos.
     * @return Lista de todos los objetos.
     */
    List<T> obtenerTodos();

    /**
     * Obtiene todos los objetos cuyo nombre coincida con el valor dado.
     * @param nombre Nombre o criterio de búsqueda.
     * @return Lista de objetos coincidentes.
     */
    List<T> buscarPorNombre(String nombre);

    /**
     * Obtiene el número total de registros en la tabla.
     * @return Cantidad de registros.
     */
    int obtenerConteo();
}
