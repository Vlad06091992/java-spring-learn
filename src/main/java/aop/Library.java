package aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component("libraryBean")
@EnableAspectJAutoProxy
public class Library {
    public void getBook() {
        System.out.println("Мы берем книгу");

    }
}
