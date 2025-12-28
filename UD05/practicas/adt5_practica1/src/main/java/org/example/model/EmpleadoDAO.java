package org.example.model;

import org.hibernate.query.Query;
import org.hibernate.Session;

import java.util.List;

public class EmpleadoDAO implements InterfaceDAO<Empleado> {

    Session session = null;

    public EmpleadoDAO() {
        session = HibernateUtil.getSession();
    }

    @Override
    public int insert(Empleado obj) {
        Empleado empleado = (Empleado) obj;
        int numFAfectadas = 0;

        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(empleado);
        session.getTransaction().commit();
        session.close();

        return numFAfectadas;
    }

    @Override
    public int delete(Empleado obj) {
        Empleado empleado = (Empleado) obj;
        int numFAfectadas = 0;

        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(empleado);
        session.getTransaction().commit();
        session.close();

        return numFAfectadas;
    }

    @Override
    public List<Empleado> getAll() {
        List<Empleado> listaEmpleados;

        session = HibernateUtil.getSession();
        session.beginTransaction();

        Query<Empleado> query = session.createQuery("from Empleado", Empleado.class);
        listaEmpleados = query.list();

        for (Empleado e : listaEmpleados) {
            System.out.println(e);
        }

        session.getTransaction().commit();
        session.close();

        return listaEmpleados;
    }

}
