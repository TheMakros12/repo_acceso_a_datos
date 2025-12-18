package org.example.ejercicio03.model;

import java.sql.*;

public class ProductoDAO implements InterfaceDAO<Producto> {

    private Connection accesoBD = null;

    public ProductoDAO() {
        accesoBD = GestionBD.getConexion();
    }

    @Override
    public int contar(String categoria) {
        int total = 0;
        String sqlContar = "SELECT COUNT(*) FROM productos WHERE categoria = ?;";

        try {
            PreparedStatement sentencia = accesoBD.prepareStatement(sqlContar);
            sentencia.setString(1, categoria);
            ResultSet resultSet = sentencia.executeQuery();
            resultSet.next();
            total = resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return total;
    }

    @Override
    public int actualizar(String nombre) {
        int actualizar = 0;

        String sqlActualizar = "UPDATE `productos` SET `stock` = stock+1 WHERE `nombre` = ?;";

        try {
            PreparedStatement sentenciaActualizar = accesoBD.prepareCall(sqlActualizar);
            sentenciaActualizar.setString(1, nombre);
            actualizar = sentenciaActualizar.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return actualizar;
    }
}
