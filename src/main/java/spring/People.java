package spring;

import org.springframework.stereotype.Component;

@Component("peopleBean")
//@Component
public class People {
    public People() {
        System.out.println("People bean is created");
    }

    public void sayHello(){
        System.out.println("Hello");
    }
}
