package org.example.controller;

import org.example.model.User;
import org.example.model.UserDAO;
import org.example.view.JFListado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ControladorListado {

    JFListado vista;
    UserDAO modelo;

    public ControladorListado(JFListado vistaListado, UserDAO modeloListado) {
        this.vista = vistaListado;
        this.modelo = modeloListado;

        llenarDatos(vista.jtUsuarios, vista.lUsuarios);
    }

    public void llenarDatos(JTable tabla, JList<User> lista){
        DefaultListModel modeloList =  new DefaultListModel<>();
        lista.setModel(modeloList);

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tabla.setModel(modeloTabla);

        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("USUARIO");
        modeloTabla.addColumn("CONTRASEÑA");

        Object[] columna = new Object[3];

        List<User> listaUsers = modelo.getAll();
        int numRegistros = listaUsers.size();

        for (User user : listaUsers) {
            columna[0] = user.getId();
            columna[1] = user.getUsername();
            columna[2] = user.getPassword();
            modeloTabla.addRow(columna);

            modeloList.addElement(user.toString());
        }

        tabla.setEnabled(false);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.getTableHeader().setReorderingAllowed(false);
    }

}
