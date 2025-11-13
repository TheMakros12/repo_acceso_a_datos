package org.example.controller;

import org.example.model.Articulo;
import org.example.model.ArticuloDAO;
import org.example.view.JFArticulos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class ControladorArticulo implements ActionListener, KeyListener {

    private JFArticulos vista;
    private ArticuloDAO modelo;

    public ControladorArticulo(JFArticulos vistaArticulo, ArticuloDAO modeloArticulo) {
        this.vista = vistaArticulo;
        this.modelo = modeloArticulo;

        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnSeleccionar.addActionListener(this);

        this.vista.txtBusquedaNombre.addKeyListener(this);

        inicializarVista();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnNuevo) {
            inicializarVista();
        }

        if (e.getSource() == this.vista.btnGuardar) {
            String id = vista.txtId.getText();
            String nombre = vista.txtNombre.getText();
            Float precio = Float.parseFloat(vista.txtPrecio.getText());
            int stock = Integer.parseInt(vista.txtStock.getText());
            String imagen = vista.txtImagen.getText();
            String descripcion = vista.txtDescripcion.getText();
            Articulo articulo = new Articulo(id, nombre, precio, stock, imagen, descripcion);

            int numRegistros = 0;
            numRegistros = modelo.insertar(articulo);

            if (numRegistros != 0) {
                JOptionPane.showMessageDialog(null, "Guardado el Artículo con id: " + id);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR!!! No se ha podido Guardar el Artículo.");
            }

            inicializarVista();
        }

        if (e.getSource() == this.vista.btnModificar) {
            String id = vista.txtId.getText();
            String nombre = vista.txtNombre.getText();
            Float precio = Float.parseFloat(vista.txtPrecio.getText());
            int stock = Integer.parseInt(vista.txtStock.getText());
            String imagen = vista.txtImagen.getText();
            String descripcion = vista.txtDescripcion.getText();
            Articulo articulo = new Articulo(id, nombre, precio, stock, imagen, descripcion);

            int numRegistros = 0;
            numRegistros = modelo.actualizar(articulo);

            if (numRegistros != 0) {
                JOptionPane.showMessageDialog(null, "Actualizado el Artículo con id: " + id);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR!!! No se ha podido Actualizar el Artículo.");
            }

            inicializarVista();
        }

        if (e.getSource() == this.vista.btnEliminar) {
            String id = vista.txtId.getText();
            Articulo articulo = new Articulo();
            articulo.setId(id);

            int numRegistros = 0;
            numRegistros = modelo.eliminar(articulo);

            if (numRegistros != 0) {
                JOptionPane.showMessageDialog(null, "Eliminado el Artículo con id: " + id);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR!!! No se ha podido Eliminar el Artículo.");

            }

            inicializarVista();
        }

        if (e.getSource() == this.vista.btnSeleccionar) {
            int filaEditar = vista.jtArticulos.getSelectedRow();
            int numFS = vista.jtArticulos.getSelectedRowCount();

            if (filaEditar >= 0 && numFS == 1) {
                JOptionPane.showMessageDialog(null, "Seleccionado el artículo con id: " + vista.txtId.getText());
                vista.txtId.setText(String.valueOf(vista.jtArticulos.getValueAt(filaEditar, 0)));
                vista.txtNombre.setText(String.valueOf(vista.jtArticulos.getValueAt(filaEditar, 1)));
                vista.txtPrecio.setText(String.valueOf(vista.jtArticulos.getValueAt(filaEditar, 2)));
                vista.txtStock.setText(String.valueOf(vista.jtArticulos.getValueAt(filaEditar, 3)));
                vista.txtImagen.setText(String.valueOf(vista.jtArticulos.getValueAt(filaEditar, 4)));
                vista.txtDescripcion.setText(String.valueOf(vista.jtArticulos.getValueAt(filaEditar, 5)));
            } else {
                JOptionPane.showMessageDialog(null, "ERROR!!! No se ha podido Eliminar el Artículo.");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vista.txtBusquedaNombre) {
            String busqueda = vista.txtBusquedaNombre.getText();
            DefaultTableModel modeloT = new DefaultTableModel();
            vista.jtArticulos.setModel(modeloT);

            modeloT.addColumn("ID");
            modeloT.addColumn("NOMBRE");
            modeloT.addColumn("PRECIO");
            modeloT.addColumn("STOCK");
            modeloT.addColumn("IMAGEN");
            modeloT.addColumn("DESCRIPCIÓN");

            Object[] columna = new Object[6];

            List<Articulo> lista = modelo.buscarPorNombre(busqueda);

            for (Articulo a : lista) {
                columna[0] = a.getId();
                columna[1] = a.getNombre();
                columna[2] = a.getPrecio();
                columna[3] = a.getStock();
                columna[4] = a.getImagen();
                columna[5] = a.getDescripcion();
                modeloT.addRow(columna);
            }

            vista.txtTotalArticulos.setText(String.valueOf(lista.size()));
        }
    }

    public void inicializarVista() {
        limpiarElementos();
        llenarTabla(vista.jtArticulos);
    }

    public void limpiarElementos(){
        this.vista.txtId.setText("");
        this.vista.txtNombre.setText("");
        this.vista.txtPrecio.setText("");
        this.vista.txtStock.setText("");
        this.vista.txtImagen.setText("");
        this.vista.txtDescripcion.setText("");
        this.vista.txtBusquedaNombre.setText("");
        this.vista.txtTotalArticulos.setText("");
        this.vista.btnGuardar.setEnabled(true);
        this.vista.btnModificar.setEnabled(true);
        this.vista.btnEliminar.setEnabled(true);
        this.vista.btnSeleccionar.setEnabled(true);
    }

    public void llenarTabla(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("ID");
        modeloT.addColumn("NOMBRE");
        modeloT.addColumn("PRECIO");
        modeloT.addColumn("STOCK");
        modeloT.addColumn("IMAGEN");
        modeloT.addColumn("DESCRIPCIÓN");

        Object[] columna = new Object[6];

        List<Articulo> lista = modelo.obtenerTodos();

        for (Articulo articulo : lista) {
            columna[0] = articulo.getId();
            columna[1] = articulo.getNombre();
            columna[2] = articulo.getPrecio();
            columna[3] = articulo.getStock();
            columna[4] = articulo.getImagen();
            columna[5] = articulo.getDescripcion();
            modeloT.addRow(columna);
        }

        tablaD.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaD.getTableHeader().setReorderingAllowed(false);

        vista.txtTotalArticulos.setText(String.valueOf(lista.size()));
    }

}
