package spring_ioc_di_examples;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {

        //можем передать несколько файлов с контекстом
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext2.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.setName("Strelka");
        Dog otherDog = context.getBean("myPet", Dog.class);
        otherDog.setName("Belka");

        System.out.println(myDog.getName());
        System.out.println(otherDog.getName());

        System.out.println("переменные сслыаются на один и тот же объект? " + (myDog == otherDog));


        System.out.println("-------------------------------------------------------------------------------");


        Cat myCat = context.getBean("myPet2", Cat.class);
        myCat.setName("Fedya");
        Cat otherCat = context.getBean("myPet2", Cat.class);
        otherCat.setName("Basya");

        System.out.println(myCat.getName());
        System.out.println(otherCat.getName());

        System.out.println("переменные сслыаются на один и тот же объект? " + (myCat == otherCat));


    }
}
