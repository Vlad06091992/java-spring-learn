package hibernate_one_to_many_uni.entity.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Run {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();


            //создание департамента с работниками
            Department department = new Department("IT", 300, 1500);

            Employee ivan = new Employee("Ivan", "Ivanov", 500);
            Employee igor = new Employee("Igor", "Petrov", 1500);


            department.addEmployeeToDepartment(ivan);
            department.addEmployeeToDepartment(igor);
            session.beginTransaction();
            session.save(department);

            System.out.println(department.getEmployees());

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




