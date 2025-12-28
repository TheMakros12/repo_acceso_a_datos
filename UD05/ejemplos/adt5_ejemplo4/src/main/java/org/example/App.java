package org.example;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Arma arma1 = new Arma("Fusil", "Man-O-War", 150);
        Arma arma2 = new Arma("Subfusil", "Kuda", 90);

        Personaje personaje1 = new Personaje("Mario", 110, 100);
        Personaje personaje2 = new Personaje("Luigi", 110, 100);

        arma1.getPersonajes().add(personaje1);
        arma1.getPersonajes().add(personaje2);

        personaje1.getArmas().add(arma1);
        personaje2.getArmas().add(arma1);

        Arma arma3 = new Arma("Escopeta", "KRM-262", 75);

        Personaje personaje3 = new Personaje("Bowser", 110, 100);
        Personaje personaje4 = new Personaje("Daisy", 110, 100);

        List<Personaje> listaPersonajes = new ArrayList<Personaje>();
        listaPersonajes.add(personaje3);
        listaPersonajes.add(personaje4);

        arma3.setPersonajes(listaPersonajes);

        personaje3.getArmas().add(arma3);
        personaje4.getArmas().add(arma3);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.persist(personaje1);
        session.persist(personaje2);
        session.persist(arma2);
        session.persist(arma3);

        session.getTransaction().commit();

        session.close();
        HibernateUtil.closeSessionFactory();

    }

}