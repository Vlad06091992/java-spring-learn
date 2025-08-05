package aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class UniversityLibrary {
    public void getBook() {
        System.out.println("Мы берем книгу из UniversityLibrary");
        System.out.println("---------------------------------------------------");
    }

    public void returnBook() {
        System.out.println("Мы возвращаем книгу в UniversityLibrary");
        System.out.println("---------------------------------------------------");
    }

    public void addBook(String personName, Book book) {
        System.out.println("Мы добавляем книгу в UniversityLibrary");
        System.out.println("---------------------------------------------------");
    }


    public void getMagazine() {
        System.out.println("Мы берем журнал из UniversityLibrary");
        System.out.println("---------------------------------------------------");
    }

    public void returnMagazine() {
        System.out.println("Мы возвращаем журнал в UniversityLibrary");
        System.out.println("---------------------------------------------------");
    }

    public void addMagazine() {
        System.out.println("Мы добавляем журнал в UniversityLibrary");
        System.out.println("---------------------------------------------------");
    }
}
