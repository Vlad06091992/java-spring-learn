package hibernate_many_to_many;


import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createNativeQuery("TRUNCATE TABLE children CASCADE").executeUpdate();
            session.createNativeQuery("TRUNCATE TABLE children_sections CASCADE").executeUpdate();
            session.createNativeQuery("TRUNCATE TABLE sections CASCADE").executeUpdate();

            Child vlad = new Child("Vlad", 7);
            Child igor = new Child("Igor", 9);
            Child vanya = new Child("Vanya", 8);
            Child egor = new Child("Egor", 9);
            Child sanya = new Child("Sanya", 10);

            Section football = new Section("football");
            Section volleyball = new Section("volleyball");
            Section karate = new Section("karate");
            football.addChildToSection(vanya);
            football.addChildToSection(vlad);
            football.addChildToSection(igor);
            karate.addChildToSection(egor);
            karate.addChildToSection(sanya);
            karate.addChildToSection(vlad);

            vlad.addSectionToChild(volleyball);

            session.persist(vlad);
            session.persist(football);
            session.persist(karate);
            factory.getCurrentSession();
            session.getTransaction().commit();

            Session newSession = factory.getCurrentSession();
            newSession.beginTransaction();
            Child Vlad = (Child) newSession.createQuery("FROM Child where name ='Vlad'").getResultList().get(0);
            String name = Vlad.getName();
            System.out.println(name);
            newSession.delete(Vlad);
            newSession.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("exception : " + e);
        } finally {
            //Закрывать Session следует после каждого завершения работы с конкретной сессией
            session.close();
            //SessionFactory закрывается один раз при завершении приложения.
            factory.close();
        }
    }


}