package spring;

public class Person {
    private Pet pet;

    public Person(Pet pet) {
        this.pet = pet;
    }

    public void callMyPet(){
        System.out.println("hello, my pet");
        pet.say();
    }
}
