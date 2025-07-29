package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet dog = context.getBean("pet", Pet.class);
        Person person = new Person(dog);
        person.callMyPet();
        context.close();
    }
}
