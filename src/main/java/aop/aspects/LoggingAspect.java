package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;



/**
 * примеры и обязательные поля для написания pointcut
 * execution -> обязательно
 * (modifiers-pattern? - public
 * return-type-pattern - void -> обязательно
 * declaring-type-pattern? aop.UniversityLibrary.getBook()
 * method-name-pattern(parameters-pattern) -> обязательно
 * throws-pattern?
 * )
 *
 */



@Component
@Aspect
public class LoggingAspect {
    //advice - метод в аспекте который содержит сквозную логику. определяет
    // что и когда должно происходить
    //в скобках pointcut - когда должен выполниться сквозной код
//    @Before("execution(public void aop.UniversityLibrary.getBook())")

    //сработает для всех методов, которые начинаются в get
    @Before("execution(public void aop.UniversityLibrary.get*())")
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }


//    @Before("execution(public * returnBook())") // * - любой returnType подходит
    @Before("execution(* returnBook())") //любой модификатор доступа + * - любой returnType подходит
//    @Before("execution(public String returnBook())")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка вернуть книгу");
    }
}
