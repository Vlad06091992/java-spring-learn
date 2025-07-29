package spring;

public class Person {
    public Person() {
        System.out.println("constructor called");
    }

    public void setPet(Pet pet) {
        System.out.println("pet setted");
        this.pet = pet;
    }

    private Pet pet;


    public void callMyPet(){
        System.out.println("hello, my pet");
        pet.say();
    }
}
