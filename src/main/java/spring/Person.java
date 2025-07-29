package spring;

public class Person {

    private Pet pet;
    private String surname;
    private int age;

    public Person() {
        System.out.println("constructor called");
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("set age");
        this.age = age;
    }


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
