package spring_ioc_di_examples;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

//        People people = context.getBean("peopleBean", People.class);
        People people = context.getBean("people", People.class);
        people.sayHello();

    }
}
