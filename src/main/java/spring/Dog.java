package spring;

import org.springframework.stereotype.Component;

@Component("dogBean")
public class Dog implements Pet {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Dog() {
        System.out.println("Dog bean is created");
    }

    public void say(){
        System.out.println("Bow Wow");
    }

    //модификаторы доступа могут быть любыми, можем возвращать что угодно, но это не будет использоваться
    // в данных методах не должно быть параметров
    // в зависимости от scope методы вызываются либо один раз, либо нет
    private void init(){
        System.out.println("init");
    }

    public void destroy(){
        System.out.println("destroy");
    }
}
