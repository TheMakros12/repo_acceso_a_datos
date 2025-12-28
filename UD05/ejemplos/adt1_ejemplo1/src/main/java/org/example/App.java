package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();

        User user1 = new User();
        user1.setId(1);
        user1.setUserName("Marcos");
        user1.setUserMessage("Mensaje de Marcos!");

        User user2 = new User();
        user2.setId(2);
        user2.setUserName("Lucia");
        user2.setUserMessage("Mensaje de Lucia!");

        session.beginTransaction();

        session.persist(user1);
        session.persist(user2);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

    }

}