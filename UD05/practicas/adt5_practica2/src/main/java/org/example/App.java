package org.example;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void menu() {
        System.out.println("|===========================MENÚ===========================|");
        System.out.println("|1. - Ejercicio 1 - Insertar en la entidad Seguro          |");
        System.out.println("|2. - Ejercicio 1 - Actualizar en la entidad Seguro        |");
        System.out.println("|3. - Ejercicio 1 - Borrar en la entidad Seguro            |");
        System.out.println("|4. - Ejercicio 1 - Leer de la entidad Seguro              |");
        System.out.println("|5. - Ejercicio 2 - Creación de la entidad AsistenciaMedica|");
        System.out.println("|6. - Ejercicio 3 - Consultas a la base de datos           |");
        System.out.println("|7. - Salir                                                |");
        System.out.println("|==========================================================|");
        System.out.println("Elige una opción: ");
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            menu();
            String opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("\t1. - Ejercicio 1 - Insertar en la entidad Seguro.");

                    Seguro seguro1_1 = new Seguro(1, "24506951Z", "Marcos", "Durá", "Blasco", 22, 0, LocalDate.now());
                    Seguro seguro1_2 = new Seguro(2, "20799790Q", "Inma", "Blasco", "Pons", 56, 1, LocalDate.now());

                    Session session1 = HibernateUtil.getSession();
                    session1.beginTransaction();

                    session1.persist(seguro1_1);
                    session1.persist(seguro1_2);

                    session1.getTransaction().commit();
                    session1.close();
                    break;
                case "2":
                    System.out.println("\t2.- Ejercicio1 - Actualizar en la entidad Seguro.");

                    Seguro seguro2 = new Seguro(2, "12345678A", "Lucia", "Calatayud", "Oliver", 20, 0, LocalDate.now());

                    Session session2 = HibernateUtil.getSession();
                    session2.beginTransaction();

                    session2.merge(seguro2);

                    session2.getTransaction().commit();
                    session2.close();
                    break;
                case "3":
                    System.out.println("\t3. - Ejercicio1 - Borrar en la entidad Seguro.");

                    Seguro seguro3 = new Seguro();
                    seguro3.setIdSeguro(1);

                    Session session3 = HibernateUtil.getSession();
                    session3.beginTransaction();

                    session3.remove(seguro3);

                    session3.getTransaction().commit();
                    session3.close();
                    break;
                case "4":
                    System.out.println("\t4.- Ejercicio1 - Leer de la entidad Seguro.");

                    Query<Seguro> query = HibernateUtil.getSession().createQuery("FROM Seguro", Seguro.class);
                    List<Seguro> seguros = query.list();

                    for (Seguro seguroItem : seguros) {
                        System.out.println(seguroItem);
                    }
                    break;
                case "5":
                    System.out.println("\t5. - Ejercicio 2 - Creación de la entidad AsistenciaMedica.");

                    Seguro seguro5_1 = new Seguro(321, "12345678Z", "Juan", "Chafer", "Bellver", 66, 3, LocalDate.now());
                    AsistenciaMedica asistenciaMedica1 = new AsistenciaMedica(1, "Médico de cabecera", "Mislata", 800F, seguro5_1);
                    AsistenciaMedica asistenciaMedica2 = new AsistenciaMedica(2, "Operación de bypass", "Sevilla", 4500F, seguro5_1);

                    Seguro seguro5_2 = new Seguro(654, "48573562T", "Amparo", "Martí", "López", 26, 0, LocalDate.now());
                    AsistenciaMedica asistenciaMedica3 = new AsistenciaMedica(3, "Médico de cabecera", "Valencia", 700F, seguro5_2);
                    AsistenciaMedica asistenciaMedica4 = new AsistenciaMedica(4, "Operación de miopía", "Valencia", 4500F, seguro5_2);
                    AsistenciaMedica asistenciaMedica5 = new AsistenciaMedica(5, "Operación estética", "Madrid", 14500F, seguro5_2);

                    Session session4 = HibernateUtil.getSession();
                    session4.beginTransaction();

                    session4.persist(asistenciaMedica1);
                    session4.persist(asistenciaMedica2);
                    session4.persist(asistenciaMedica3);
                    session4.persist(asistenciaMedica4);
                    session4.persist(asistenciaMedica5);

                    session4.getTransaction().commit();
                    session4.close();
                    break;
                case "6":
                    System.out.println("\t6. - Ejercicio 3 - Consultas a la base de datos.");

                    Session session5 = HibernateUtil.getSession();

                    System.out.println("6.1 - Todos los seguros de la base de datos.");

                    Query<Seguro> query6_1 = session5.createQuery("FROM Seguro", Seguro.class);
                    List<Seguro> lista6_1 = query6_1.list();

                    for (Seguro seguroItem : lista6_1) {
                        System.out.println(seguroItem);
                    }

                    System.out.println("================================================================");
                    System.out.println("6.2. - Solo las columnas NIF y Nombre de todos los Seguros que hay en la BD.");

                    Query<Object[]> query6_2 = session5.createQuery("SELECT nif, nombre FROM Seguro", Object[].class);
                    List<Object[]> lista6_2 = query6_2.list();

                    for (Object[] resultado : lista6_2) {
                        System.out.println("NIF: " + resultado[0] + " - Nombre: " + resultado[1]);
                    }

                    System.out.println("================================================================");
                    System.out.println("6.3. - Solo el NIF para el seguro con nombre 'Juan Chafer Bellver'.");

                    Query<String> query6_3 = session5.createQuery("SELECT s.nif FROM Seguro AS s " +
                            "WHERE s.nombre = :nombre AND s.ape1 = :ape1 AND s.ape2 = :ape2", String.class);
                    query6_3.setParameter("nombre", "Juan");
                    query6_3.setParameter("ape1", "Chafer");
                    query6_3.setParameter("ape2", "Bellver");
                    String resultado6_3 = query6_3.uniqueResult();

                    System.out.println("NIF: " + resultado6_3);

                    System.out.println("================================================================");
                    System.out.println("6.4. - El idAsistenciaMedica de todas las asistencias médicas cuyo saldo esté entre 2.000 y 5.000 euros.");

                    Query<Integer> query6_4 = session5.createQuery("SELECT idAsistenciaMedica FROM AsistenciaMedica AS s " +
                            "WHERE importe >= ?1 AND importe <= ?2", Integer.class);
                    query6_4.setParameter(1, 2000);
                    query6_4.setParameter(2, 5000);
                    List<Integer> lista6_4 = query6_4.list();

                    for(Integer numeroItem : lista6_4) {
                        System.out.println("AsistenciaMedica: (id) - " + numeroItem);
                    }

                    System.out.println("================================================================");
                    System.out.println("6.5. - Calcula la suma del importe de todas las Asistencias Médicas.");

                    Query<Double> query6_5 = session5.createQuery("SELECT SUM(importe) FROM AsistenciaMedica", Double.class);
                    Double resultado6_5 = query6_5.uniqueResult();

                    System.out.println("Importe total de todas las Asistencias Médicas: " + resultado6_5 + "€");

                    System.out.println("================================================================");
                    System.out.println("6.6. - Calcula el saldo medios de todas las Asistencias Médicas.");

                    Query<Double> query6_6 = session5.createQuery("SELECT AVG(importe) FROM AsistenciaMedica", Double.class);
                    Double resultado6_6 = query6_6.uniqueResult();

                    System.out.println("Saldo medio de todas las Asistencias Médicas: " + resultado6_6 + "€");

                    System.out.println("================================================================");
                    System.out.println("6.7. - Calcula cuántos Seguros hay en total.");

                    Query<Long> query6_7 = session5.createQuery("SELECT COUNT(*) FROM Seguro", Long.class);
                    Long resultado6_7 = query6_7.uniqueResult();

                    System.out.println("En totoal hay: " + resultado6_7 + " seguros.");

                    System.out.println("================================================================");
                    System.out.println("6.8. - Muestra, por cada Seguro, las Asistencia Médicas que posee cada uno.");

                    Query<Object[]> query6_8 = session5.createQuery("SELECT a.seguro.idSeguro, COUNT(*) " +
                            "FROM AsistenciaMedica AS a GROUP BY a.seguro.idSeguro", Object[].class);
                    List<Object[]> lista6_8 = query6_8.list();

                    for (Object[] resultado : lista6_8) {
                        System.out.println("Seguro ID: " + resultado[0] + " - Num. Asistencias: " + resultado[1]);
                    }

                    System.out.println("================================================================");
                    System.out.println("6.9. - Consulta sobre la tabla Seguro pero con una SQL Nativa de MySQL.");

                    Query<Object[]> query6_9 = session5.createQuery("SELECT nif, fechaCreacion " +
                            "FROM Seguro", Object[].class);
                    List<Object[]> lista6_9 = query6_9.list();

                    for (Object[] resultado : lista6_9) {
                        System.out.println("Seguro NIF: " + resultado[0] + " - Fecha Creacióhn: " + resultado[1]);
                    }
                    break;
                case "7":
                    System.out.println("\t7. - Salir.");
                    salir = true;
                    System.out.println("Has salido de la aplicación.x");
                    break;
                default:
                    System.out.println("Opción incorrecta!!!");
                    break;
            }
        }

    }

}