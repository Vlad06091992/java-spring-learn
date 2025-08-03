package spring_ioc_di_examples;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test7 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);


        Pet mouse = context.getBean("mouseBean", Mouse.class);
        Pet mouse1 = context.getBean("mouseBean", Mouse.class);
        mouse.say();

        System.out.println(mouse1 == mouse);

        People man = context.getBean("peopleBean", People.class);
        man.callMyPet();

    }
}
