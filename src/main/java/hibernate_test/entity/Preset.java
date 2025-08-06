package hibernate_test.entity;

import java.util.ArrayList;
import java.util.List;

public  class Preset {
    static List<Employee> employees = new ArrayList<>();
    public static List<Employee> getEmployees(){

        employees.add(new Employee("Vlad", "Smirnov", "Programmer", 4000));
        employees.add(new Employee("Ivan", "Petrov", "Designer", 3500));
        employees.add(new Employee("Anna", "Sidorova", "Manager", 5000));
        employees.add(new Employee("Olga", "Ivanova", "Analyst", 4500));
        employees.add(new Employee("Sergey", "Kuznetsov", "Developer", 4800));
        employees.add(new Employee("Dmitry", "Makarov", "Tester", 3800));
        employees.add(new Employee("Tatiana", "Nikolaeva", "HR", 4200));
        employees.add(new Employee("Alexey", "Fedorov", "Administrator", 3900));
        employees.add(new Employee("Marina", "Semenova", "Support", 3200));
        employees.add(new Employee("Maxim", "Gavrilov", "Architect", 6000));

        return employees;

    }
}
