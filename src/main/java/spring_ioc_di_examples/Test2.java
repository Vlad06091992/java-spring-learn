package spring_ioc_di_examples;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Pet dog = context.getBean("cat", Pet.class);

        dog.say();

        context.close();
    }
}
