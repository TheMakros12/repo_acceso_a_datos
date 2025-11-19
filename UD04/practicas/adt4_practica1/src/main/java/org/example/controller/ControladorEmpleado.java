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

    public ControladorEmpleado(JFEmpleados vistaEmpleado,  EmpleadoDAO modeloEmpleado) {
        this.vista = vistaEmpleado;
        this.modelo = modeloEmpleado;

        this.vista.btnInsert.addActionListener(this);
        this.vista.btnDelete.addActionListener(this);
        this.vista.btnList.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnInsert) {
            String nuevoDni = this.vista.txtDni.getText();
            String nuevoNombre = this.vista.txtName.getText();
            String nuevoApellido = this.vista.txtLastName.getText();
            int nuevoEdad = Integer.parseInt(this.vista.txtYears.getText());
            Float nuevoSalario = Float.parseFloat(this.vista.txtSalary.getText());

            Empleado isertEmpleado = new Empleado(nuevoDni, nuevoNombre, nuevoApellido, nuevoEdad, nuevoSalario);

            int numRegistrosInsert = 0;
            numRegistrosInsert = modelo.insert(isertEmpleado);

            if (numRegistrosInsert != 0) {
                JOptionPane.showMessageDialog(null, "Guardado el Empleado con dni: " + nuevoDni);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido guardar el Empleado con dni: " + nuevoDni);
            }

            limpiarCampos();
        }

        if (e.getSource() == this.vista.btnDelete) {
            String deleteDni = this.vista.txtDni.getText();
            Empleado deleteEmpleado = new Empleado();
            deleteEmpleado.setDni(deleteDni);

            int numRegistrosDelete = 0;
            numRegistrosDelete = modelo.delete(deleteEmpleado);

            if (numRegistrosDelete != 0) {
                JOptionPane.showMessageDialog(null, "Eliminado el Empleado con dni: " + deleteDni);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido eliminar el Empleado con dni: " + deleteDni);
            }

            limpiarCampos();
        }

        if (e.getSource() == this.vista.btnList) {
            DefaultTableModel modeloT = new DefaultTableModel();
            vista.jtEmpleados.setModel(modeloT);

            modeloT.addColumn("DNI");
            modeloT.addColumn("NOMBRE");
            modeloT.addColumn("APELLIDOS");
            modeloT.addColumn("EDAD");
            modeloT.addColumn("SALARIO");

            Object[] colunas = new Object[5];
            List<Empleado> listaEmpleados = modelo.getAll();

            for (Empleado empleado : listaEmpleados) {
                colunas[0] = empleado.getDni();
                colunas[1] = empleado.getNombre();
                colunas[2] = empleado.getApellidos();
                colunas[3] = empleado.getEdad();
                colunas[4] = empleado.getSalario();
                modeloT.addRow(colunas);
            }

            vista.jtEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            vista.jtEmpleados.getTableHeader().setReorderingAllowed(false);
        }

    }
    private void limpiarCampos() {
        this.vista.txtDni.setText("");
        this.vista.txtName.setText("");
        this.vista.txtLastName.setText("");
        this.vista.txtYears.setText("");
        this.vista.txtSalary.setText("");
    }

}

