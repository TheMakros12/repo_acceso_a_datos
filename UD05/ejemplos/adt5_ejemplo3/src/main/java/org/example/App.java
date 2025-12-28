package org.example;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Arma arma1 = new Arma("Fusil", "M8A7", 180);

        Personaje personaje1 = new Personaje("Mario", 100, 110);
        Personaje personaje2 = new Personaje("Luigi", 100, 110);

        List<Personaje> listaPersonajes = new ArrayList<Personaje>();
        listaPersonajes.add(personaje1);
        listaPersonajes.add(personaje2);

        arma1.setPersonaje(listaPersonajes);
        personaje1.setArma(arma1);
        personaje2.setArma(arma1);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.persist(arma1);

        session.getTransaction().commit();
        
        session.close();
        HibernateUtil.closeSessionFactory();

    }

}