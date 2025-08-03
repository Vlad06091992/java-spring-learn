package aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class UniversityLibrary {
    public void getBook() {
        System.out.println("Мы берем книгу " +  "из UniversityLibrary");
    }


    public void getMagazine() {
        System.out.println("Мы берем журнал из UniversityLibrary");
    }
}
