package org.example;

import org.hibernate.Session;

public class App {

    public static void main(String[] args) {

        Direccion direccion = new Direccion();
        direccion.setCalle("Calle Castellón, 20");

        Persona persona = new Persona();
        persona.setNombre("Marcos");
        persona.setDireccion(direccion);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.persist(persona);

        session.getTransaction().commit();
        session.close();

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        persona = session2.get(Persona.class, 1);
        System.out.println("Valor desacoplado de la persona sin cambios: " + persona);

        persona.setNombre("Lucia");
        persona.getDireccion().setCalle("Calle Ramón y Cajal, 79");

        System.out.println("Valor desacoplado de la persona con cambios: " + persona);

        session2.refresh(persona);

        System.out.println("Valor acoplado de persona recuperado de la bases de datos: " + persona);

        session2.getTransaction().commit();
        session2.close();

        HibernateUtil.closeSessionFactory();

    }

}