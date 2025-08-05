package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    //Around позволяет
    // 1) произвести действия до вызова метода
    // 2) произвести действия после вызова метода
    // 3) получить результаты работы target метода/изменить его
    // 4) выполнить действия если из метода выбрасывается исключение
    @Around("execution(public String aop.University.returnBook())")
    public Object AroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        ProceedingJoinPoint – позволяет управлять вызовами методов в AOP

        System.out.println("AroundReturnBookLoggingAdvice: в библиотеку будут возвращать книгу");

        Object targetMethodResult = null;

        try {
            // этой строчкой вызываем целевой метод
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e){
            System.out.println("было выброшено исключение");
//             targetMethodResult = "Неизвестное название книги";
//             throw new Exception("Неизвестное название книги");
             throw e;
        }



        System.out.println("AroundReturnBookLoggingAdvice: в библиотеку вернули книгу");

//        return "Преступление и наказание"; //<- можем подменить ответ
        return targetMethodResult;




    }

}
