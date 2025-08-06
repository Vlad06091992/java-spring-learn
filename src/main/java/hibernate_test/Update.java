package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Update {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            //обновляем по ид
            Employee Anna = session.get(Employee.class, 254);
            Anna.setSalary(199999);
            // update HQL
            session.createQuery("update Employee set salary = 10000 where id in(255,256)").executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("exception : " + e);
        } finally {
            factory.close();
        }


    }
}
