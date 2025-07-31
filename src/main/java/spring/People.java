package spring;

import org.springframework.stereotype.Component;

@Component("peopleBean")
//@Component
public class People {
    private Pet pet;

    public People(Pet pet) {
        System.out.println("People bean is created");
        this.pet = pet;
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public void callMyPet(){
        System.out.println("hello, my pet");
        pet.say();
    }
}
