package hibernate_test;

import hibernate_test.entity.Employee;
import hibernate_test.entity.Preset;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
//            Session session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            List<Employee> employees = Preset.getEmployees();
//
//            for(Employee employee:employees){
//                session.save(employee);
//            }
//
//          int id =  employees.get(3).getId();
//
//            session.getTransaction().commit();
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class,id );
//            System.out.println(emp.toString());


            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> employees = Preset.getEmployees();

            for(Employee employee:employees){
                session.save(employee);
            }

            int id =  employees.get(3).getId();
            session = factory.getCurrentSession();

            // получить по id
            Employee emp = session.get(Employee.class,id );

            // получить по другому признаку HQL
            List<Employee> res =  session.createQuery("from Employee where name ='Vlad'").getResultList();
            System.out.println(res);


            // получить по другому признаку сырой SQL
            List<Employee> resSalary =  session.createNativeQuery("SELECT salary,name,id FROM employees e WHERE e.salary > 4500").getResultList();
            System.out.println(resSalary);

            session.getTransaction().commit();
            System.out.println(emp.toString());


        } catch (Exception e){
            System.out.println("exception : " + e);
        }

        finally {
            factory.close();
        }


    }
}
