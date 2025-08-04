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
    @Before("aop.aspects.MyPointcuts.beforeAllGetMethods()")
    public void beforeGetExceptionHandlingAdvice(){
        System.out.println("beforeGetLoggingAdvice3: ловим/обрабатываем исключения при логирование при попытке получения книги/журнала");
    }

}
