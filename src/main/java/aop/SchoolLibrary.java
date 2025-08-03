package aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class SchoolLibrary extends AbstractLibrary {

    @Override
    public void getBook() {
        System.out.println("Мы берем книгу из SchoolLibrary");
    }
}
