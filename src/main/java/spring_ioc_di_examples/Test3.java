package spring_ioc_di_examples;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("person", Person.class);

        System.out.println(person.getAge());
        System.out.println(person.getSurname());

        person.callMyPet();
        context.close();
    }
}
