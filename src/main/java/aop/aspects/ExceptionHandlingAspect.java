package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(30)
public class ExceptionHandlingAspect {
    @Before("aop.aspects.MyPointcuts.beforeAllAddMethods()")
    public void beforeAddExceptionHandlingAdvice(){
        System.out.println("beforeAddLoggingAdvice3: ловим/обрабатываем исключения при логирование при попытке получения книги/журнала");
        System.out.println("---------------------------------------------------");
    }

}
