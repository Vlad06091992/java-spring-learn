package spring_ioc_di_examples;

public class Mouse implements Pet {
    @Override
    public void say() {
        System.out.println("squeak");
    }
}
