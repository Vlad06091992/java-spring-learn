package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
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
@Order(10)
public class LoggingAspect {
    @Before("aop.aspects.MyPointcuts.beforeAllGetMethods()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice1: логирование при попытке получения книги/журнала");
    }

}
