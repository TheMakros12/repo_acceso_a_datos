package org.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements InterfaceDAO<Empleado> {

    private Connection accesoBD = null;

    public EmpleadoDAO() {
        accesoBD = GestionBD.getConnection();
    }

    @Override
    public int insert(Empleado obj) {
        int filasAfectadas = 0;

        try {
            String sqlInsert = "INSERT INTO empleados VALUES (?, ?, ?, ?, ?);";
            PreparedStatement psInsert = accesoBD.prepareStatement(sqlInsert);
            psInsert.setString(1, obj.getDni());
            psInsert.setString(2, obj.getNombre());
            psInsert.setString(3, obj.getApellidos());
            psInsert.setInt(4, obj.getEdad());
            psInsert.setFloat(5, obj.getSalario());
            filasAfectadas = psInsert.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error EmpleadoDAO - INSERTAR: " + e.getMessage());
        }

        return filasAfectadas;
    }

    @Override
    public int delete(Empleado obj) {
        int filasAfectadas = 0;

        try {
            String sqlDelete = "DELETE FROM empleados WHERE idEmpleado = ?;";
            PreparedStatement psdelete = accesoBD.prepareStatement(sqlDelete);
            psdelete.setString(1, obj.getDni());
            filasAfectadas = psdelete.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error EmpleadoDAO - ELIMINAR: " + e.getMessage());
        }

        return filasAfectadas;
    }

    @Override
    public List<Empleado> getAll() {
        List<Empleado> listaEmpleados = new ArrayList<>();
        Empleado emp;

        try {
            String sqlGetAll = "SELECT * FROM empleados;";
            PreparedStatement psGetAll = accesoBD.prepareStatement(sqlGetAll);
            ResultSet resultado = psGetAll.executeQuery();
            while (resultado.next()) {
                emp = new Empleado();
                emp.setDni(resultado.getString(1));
                emp.setNombre(resultado.getString(2));
                emp.setApellidos(resultado.getString(3));
                emp.setEdad(resultado.getInt(4));
                emp.setSalario(resultado.getFloat(5));
                listaEmpleados.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Error EmpleadoDAO - LISTAR: " + e.getMessage());
        }

        return listaEmpleados;
    }
}
