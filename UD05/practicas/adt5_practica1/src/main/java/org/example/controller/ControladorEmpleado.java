package org.example.controller;

import org.example.model.Empleado;
import org.example.model.EmpleadoDAO;
import org.example.view.JFEmpleados;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorEmpleado implements ActionListener {

    private JFEmpleados vista;
    private EmpleadoDAO modelo;

    public ControladorEmpleado(JFEmpleados vistaEmpleado, EmpleadoDAO modeloEmpleado) {
        this.vista = vistaEmpleado;
        this.modelo = modeloEmpleado;

        this.vista.btnInsertar.addActionListener(this);
        this.vista.btnBorrar.addActionListener(this);
        this.vista.btnListar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnInsertar) {
            String dni = this.vista.txtDni.getText();
            String nombre = this.vista.txtNombre.getText();
            String apellidos = this.vista.txtApellidos.getText();
            int edad = Integer.parseInt(this.vista.txtEdad.getText());
            Float salario = Float.parseFloat(this.vista.txtSalario.getText());

            Empleado empleadoInsert = new  Empleado(dni, nombre, apellidos, edad, salario);

            int numRegistros = 0;
            numRegistros = modelo.insert(empleadoInsert);

            if (numRegistros != 0) {
                JOptionPane.showMessageDialog(null,"Empleado insertado exitosamente", "INSERT", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,"ERROR al insertar el empleado", "INSERT", JOptionPane.ERROR_MESSAGE);
            }

            limpiarCampos();
        }

        if (e.getSource() == this.vista.btnBorrar) {
            String dni = this.vista.txtDni.getText();
            Empleado empleadoDelete = new Empleado();
            empleadoDelete.setDni(dni);

            int numRegistros = 0;
            numRegistros = modelo.delete(empleadoDelete);

            if (numRegistros != 0) {
                JOptionPane.showMessageDialog(null,"Empleado borrado exitosamente", "DELETE", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,"ERROR al borrar el empleado", "DELETE", JOptionPane.ERROR_MESSAGE);
            }

            limpiarCampos();
        }

        if (e.getSource() == this.vista.btnListar) {
            DefaultTableModel modeloTabla = new DefaultTableModel();
            vista.jtEmpleados.setModel(modeloTabla);

            modeloTabla.addColumn("DNI");
            modeloTabla.addColumn("NOMBRE");
            modeloTabla.addColumn("APELLIDOS");
            modeloTabla.addColumn("EDAD");
            modeloTabla.addColumn("SALARIO");

            Object[] columnas = new Object[5];
            List<Empleado> listaEmpleados = modelo.getAll();

            for (Empleado empleado : listaEmpleados) {
                columnas[0] = empleado.getDni();
                columnas[1] = empleado.getNombre();
                columnas[2] = empleado.getApellidos();
                columnas[3] = empleado.getEdad();
                columnas[4] = empleado.getSalario();
                modeloTabla.addRow(columnas);
            }

            vista.jtEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            vista.jtEmpleados.getTableHeader().setReorderingAllowed(false);
        }
    }

    private void limpiarCampos() {
        this.vista.txtDni.setText("");
        this.vista.txtNombre.setText("");
        this.vista.txtApellidos.setText("");
        this.vista.txtEdad.setText("");
        this.vista.txtSalario.setText("");
    }

}
