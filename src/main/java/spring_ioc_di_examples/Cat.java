package spring_ioc_di_examples;

import org.springframework.stereotype.Component;

@Component("catBean")
public class Cat implements Pet {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Cat() {
        System.out.println("cat bean created");
    }

    public void say(){
        System.out.println("Meow");
    }
}
