package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            //удаляем по ид
            Employee Ivan = session.get(Employee.class, 653);
            if(Ivan != null){
                session.delete(Ivan);
            }
            // delete HQL
            session.createQuery("delete Employee where name = 'Marina'").executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("exception : " + e);
        } finally {
            factory.close();
        }


    }
}
