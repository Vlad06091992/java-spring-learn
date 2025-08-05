package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Method main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);
        String bookName = university.returnBook();
        System.out.println("в библиотеку вернули: " +bookName);
        context.close();
        System.out.println("Method main ends");
    }


}

