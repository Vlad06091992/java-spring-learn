package aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class UniversityLibrary extends AbstractLibrary {
    @Override
    public void getBook(Book book) {
        System.out.println("Мы берем книгу " + book.getName() + "из UniversityLibrary");
    }


    public String returnBook() {
        System.out.println("Мы возвращаем книгу в UniversityLibrary");
        return "OK";
    }


    public void getMagazine() {
        System.out.println("Мы берем журнал из UniversityLibrary");
    }
}
