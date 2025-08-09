package hibernate_one_to_many_bi.entity.entity;

//Дефолтные типы загрузки
//@OneToOne -> Eager
//@ManyToOne -> Eager
//@OneToMany -> Lazy
//@ManyToOne -> Lazy


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerAndLazyLoading {
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
            Department dep = session.get(Department.class, 252);
            System.out.println("get emplyees");
            System.out.println(dep.getEmployees());

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




