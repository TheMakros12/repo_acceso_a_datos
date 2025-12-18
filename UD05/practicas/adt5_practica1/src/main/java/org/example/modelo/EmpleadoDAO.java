package org.example.modelo;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class EmpleadoDAO implements InterfaceDAO {

    Session session = null;

    public EmpleadoDAO() {
        session = HibernateUtil.getSession();
    }

    @Override
    public int insert(Object obj) {
        Empleado emp = (Empleado) obj;
        int numFAfectadas = 0;

        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(emp);
        session.getTransaction().commit();
        session.close();

        return numFAfectadas;
    }

    @Override
    public int delete(Object obj) {
        Empleado emp = (Empleado) obj;
        int numFAfectadas = 0;

        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(emp);
        session.getTransaction().commit();
        session.close();

        return numFAfectadas;
    }

    @Override
    public ArrayList getAll() {
        ArrayList<Empleado> lista;

        session = HibernateUtil.getSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT e FROM Empleado e", Empleado.class);
        lista = (ArrayList<Empleado>) query.list();

        for (Empleado emp : lista) {
            System.out.println(emp);
        }

        session.getTransaction().commit();
        session.close();

        return lista;
    }

}
