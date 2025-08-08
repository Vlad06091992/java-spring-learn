package hibernate_one_to_many_bi.entity.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OneToMany {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            //создание департамента с работниками
//            Department department = new Department("IT", 300, 1500);
//
//            Employee ivan = new Employee("Ivan", "Ivanov", 500);
//            Employee igor = new Employee("Igor", "Petrov", 1500);
//
//
//            department.addEmployeeToDepartment(ivan);
//            department.addEmployeeToDepartment(igor);
//
//            session.save(department);

//            получение департамента и его работников через департамент
            Employee igor = session.get(Employee.class,403);

            session.delete(igor);
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




