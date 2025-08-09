package hibernate_many_to_many;


import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

            Child vlad = new Child("Vlad",7);
            Child igor = new Child("Igor",9);
            Child vanya = new Child("Vanya",8);

            Section football = new Section("football");
            Section volleyball = new Section("volleyball");
            session.save(volleyball);
            football.addChildToSection(vanya);
            football.addChildToSection(vlad);

            igor.addSectionToChild(volleyball);
            vlad.addSectionToChild(volleyball);

            session.save(igor);
            session.save(vlad);
            session.save(football);
//            session.save(volleyball);

           Section footballFromDB =  session.get(Section.class,football.getId());

            System.out.println("в секции футбола: " + footballFromDB.getChildren());

            Child vladFromDB = session.get(Child.class,vlad.getId());
            System.out.println("в ходит на : " + vladFromDB.getSections());
            session.getTransaction().commit();


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