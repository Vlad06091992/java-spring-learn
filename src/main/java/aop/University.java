package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    public List<Student> getStudents() {
        System.out.println("Информация от метода getStudents");
        System.out.println(students.get(9));
        return students;
    }

    private List<Student> students = new ArrayList();

    public void addStudents(){
        Student st1 = new Student("Иван Иванов",2,4.5);
        Student st2 = new Student("Стас Михайлов",1,3.0);
        Student st3 = new Student("Иннокентий Петров",4,4.1);

        students.add(st1);
        students.add(st2);
        students.add(st3);

    }

    public String returnBook() {
        int a = 10/0;
        System.out.println("Возвращаем книгу в библиотеку");
        return "Война и мир";
    }
}
