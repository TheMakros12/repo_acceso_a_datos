package org.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO implements InterfaceDAO<Articulo> {

    private Connection accesoBD = null;

    public ArticuloDAO() {
        accesoBD = GestionBD.getConexion();
    }

    @Override
    public int insertar(Articulo obj) {
        int filasAfectadas = 0;
        String sqlInsertar = "INSERT INTO articulos VALUES(?,?,?,?,?,?);";

        try {
            PreparedStatement psInsertar = accesoBD.prepareStatement(sqlInsertar);

            psInsertar.setString(1, obj.getId());
            psInsertar.setString(2, obj.getNombre());
            psInsertar.setFloat(3, obj.getPrecio());
            psInsertar.setInt(4, obj.getStock());
            psInsertar.setString(5, obj.getImagen());
            psInsertar.setString(6, obj.getDescripcion());

            filasAfectadas = psInsertar.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ArticulosDAO - Insertar: " + e.getMessage());
        }

        return filasAfectadas;
    }

    @Override
    public int actualizar(Articulo obj) {
        int filasAfectadas = 0;
        String sqlActualizar = "UPDATE articulos "
                + "SET nombre = ?, precio = ?, stock = ?, imagen = ?, descripcion = ? "
                + "WHERE id = ?;";

        try {
            PreparedStatement psActualizar = accesoBD.prepareStatement(sqlActualizar);

            psActualizar.setString(1, obj.getNombre());
            psActualizar.setFloat(2, obj.getPrecio());
            psActualizar.setInt(3, obj.getStock());
            psActualizar.setString(4, obj.getImagen());
            psActualizar.setString(5, obj.getDescripcion());
            psActualizar.setString(6, obj.getId());

            filasAfectadas = psActualizar.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ArticulosDAO - Actualizar: " + e.getMessage());
        }

        return filasAfectadas;
    }

    @Override
    public int eliminar(Articulo obj) {
        int filasAfectadas = 0;
        String sqlEliminar = "DELETE FROM articulos WHERE id = ?;";

        try {
            PreparedStatement psEliminar = accesoBD.prepareStatement(sqlEliminar);

            psEliminar.setString(1, obj.getId());

            filasAfectadas = psEliminar.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ArticulosDAO - Eliminar: " + e.getMessage());
        }

        return filasAfectadas;
    }

    @Override
    public Articulo buscarPorId(int id) {
        Articulo obj = new Articulo();
        String sqlBuscarPorId = "SELECT FROM articulos WHERE id = ?;";

        try {
            PreparedStatement psBuscarPorId = accesoBD.prepareStatement(sqlBuscarPorId);

            psBuscarPorId.setInt(1, id);

            ResultSet resultadoBuscarPorId = psBuscarPorId.executeQuery();
            while (resultadoBuscarPorId.next()) {
                obj.setId(resultadoBuscarPorId.getString(1));
                obj.setNombre(resultadoBuscarPorId.getString(2));
                obj.setPrecio(resultadoBuscarPorId.getFloat(3));
                obj.setStock(resultadoBuscarPorId.getInt(4));
                obj.setImagen(resultadoBuscarPorId.getString(5));
                obj.setDescripcion(resultadoBuscarPorId.getString(6));
            }
        } catch (SQLException e) {
            System.out.println("Error ArticulosDAO - Buscar Por Id: " + e.getMessage());
        }

        return obj;
    }

    @Override
    public List<Articulo> obtenerTodos() {
        List<Articulo> listaArticulos = new ArrayList<>();
        String sqlObtenerTodos = "SELECT * FROM articulos;";

        try {
            PreparedStatement psObtenerTodos = accesoBD.prepareStatement(sqlObtenerTodos);
            ResultSet resultadoObtenerTodos = psObtenerTodos.executeQuery();

            while (resultadoObtenerTodos.next()) {
                Articulo art = new Articulo();
                art.setId(resultadoObtenerTodos.getString(1));
                art.setNombre(resultadoObtenerTodos.getString(2));
                art.setPrecio(resultadoObtenerTodos.getFloat(3));
                art.setStock(resultadoObtenerTodos.getInt(4));
                art.setImagen(resultadoObtenerTodos.getString(5));
                art.setDescripcion(resultadoObtenerTodos.getString(6));
                listaArticulos.add(art);
            }
        } catch (SQLException e) {
            System.out.println("Error ArticulosDAO - Obtener Todos: " + e.getMessage());
        }

        return listaArticulos;
    }

    @Override
    public List<Articulo> buscarPorNombre(String nombre) {
        List<Articulo> listaArticulos = new ArrayList<>();
        String sqlBuscarPorNombre = "SELECT * FROM articulos WHERE nombre LIKE ?;";

        try {
            PreparedStatement psBuscarPorName = accesoBD.prepareStatement(sqlBuscarPorNombre);

            psBuscarPorName.setString(1, '%' + nombre + '%');
            ResultSet resultadoBuscarPorNombre = psBuscarPorName.executeQuery();

            while (resultadoBuscarPorNombre.next()) {
                Articulo art = new Articulo();
                art.setId(resultadoBuscarPorNombre.getString(1));
                art.setNombre(resultadoBuscarPorNombre.getString(2));
                art.setPrecio(resultadoBuscarPorNombre.getFloat(3));
                art.setStock(resultadoBuscarPorNombre.getInt(4));
                art.setImagen(resultadoBuscarPorNombre.getString(5));
                art.setDescripcion(resultadoBuscarPorNombre.getString(6));
                listaArticulos.add(art);
            }
        } catch (SQLException e) {
            System.out.println("Error ArticulosDAO - Buscar Por Nombre: " + e.getMessage());
        }

        return listaArticulos;
    }

    @Override
    public int obtenerConteo() {
        int total = 0;
        String sqlConteo = "SELECT COUNT(*) FROM articulos;";

        try {
            PreparedStatement psObtenerConteo = accesoBD.prepareStatement(sqlConteo);

            ResultSet resultadoConteo = psObtenerConteo.executeQuery();

            if (resultadoConteo != null) {
                resultadoConteo.next();
                total = resultadoConteo.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error ArticulosDAO - Obtener Conteo: " + e.getMessage());
        }

        return total;
    }
}
