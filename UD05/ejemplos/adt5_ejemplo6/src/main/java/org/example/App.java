package org.example;

import org.hibernate.Session;

public class App {

    public static void main(String[] args) {

        Empleado emp1 = new Empleado("Mario Bros");
        Empleado emp2 = new Empleado();
        Empleado emp3 = new Empleado();

        emp2.setNombre("Luigi");
        emp3.setNombre("Bowser");

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.persist(emp1);
        session.persist(emp2);
        session.persist(emp3);

        session.getTransaction().commit();

        emp3.setNombre("Princesa Daisy");
        session.beginTransaction();

        session.merge(emp3);

        session.getTransaction().commit();

        session.close();
        HibernateUtil.closeSessionFactory();

    }

}