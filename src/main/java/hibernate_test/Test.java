package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Vlad", "Smirnov", "Programmer", 4000);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("exception : " + e);
        }

        finally {
            factory.close();
        }


    }
}
