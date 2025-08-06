package hibernate_test.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "departament")
    private String departament;
    @Column(name = "salary")
    private int salary;

    @OneToOne //создай связь(в данном случае одно направленная так как в details нет такой аннотации и он ничего не знает про Employee
    @JoinColumn(name = "details_id") //Создай такую колонку для того чтобы хранить внешний ключ который ссылается на primary key  Detail
    private Detail detail;

    public Employee() {
    }

    public Employee(String name, String surname, String departament, int salary) {
        this.name = name;
        this.surname = surname;
        this.departament = departament;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Empolyee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", departament='" + departament + '\'' +
                ", salary=" + salary +
                '}';
    }
}
