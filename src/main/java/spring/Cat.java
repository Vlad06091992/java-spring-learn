package spring;

public class Cat implements Pet {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Cat() {
    }

    public void say(){
        System.out.println("Meow");
    }
}
