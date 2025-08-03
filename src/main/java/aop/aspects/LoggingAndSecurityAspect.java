package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
public class LoggingAndSecurityAspect {

    //Объявление pointcut
    @Pointcut("execution(* get*(..))") //правила для вызова
    private void allGetMethods(){}


    //использование
    @Before("allGetMethods()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу или журнал");
    }

    //использование
    @Before("allGetMethods()")
    public void beforeGetSecurityAdvice() {
        System.out.println("beforeGetBookAdvice: проверка прав на получение книги или журнала");
    }
}
