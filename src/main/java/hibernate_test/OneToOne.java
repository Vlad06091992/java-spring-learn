package hibernate_test;

import hibernate_test.entity.Detail;
import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

//Uni-directional - отношения, когда одна сторона о них не знает
//(Однонаправленные отношения)

//public class Parent {
//    Child child;
//}
//
//public class Child {
//}


//bi-directional - отношения, когда обе стороны о них знают
//(Двунаправленные отношения)

//public class Parent {
//    Child child;
//}
//
//public class Child {
// Parent parent;
//}

public class OneToOne {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee olga = new Employee("Olga", "Ivanova", "Analyst", 4500);
            Detail detail = new Detail("email","43423","city");
            olga.setDetail(detail);
            detail.setEmployee(olga);
            session.save(olga);



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




