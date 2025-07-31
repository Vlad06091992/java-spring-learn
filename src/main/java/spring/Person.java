package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {

//    @Autowired
//    пример @Qualifier в методе
//    @Qualifier("dogBean")
//    @Qualifier("catBean")
    private Pet pet;
    private String surname;
    private int age;


    //    пример @Qualifier в конструкторе
    @Autowired
    public Person(@Qualifier("catBean") Pet pet) {
        System.out.println("person bean created");
        this.pet = pet;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("set age");
        this.age = age;
    }

//    пример @Qualifier в сеттере
//    @Autowired
//    @Qualifier("catBean")
    public void setPet(Pet pet) {
        System.out.println("pet setted");
        this.pet = pet;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("set surname");
        this.surname = surname;
    }

    public void callMyPet(){
        System.out.println("hello, my pet");
        pet.say();
    }
}
