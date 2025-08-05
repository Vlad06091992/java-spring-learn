package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
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
 */

//Advice — это действие, которое выполняется в определенный момент во время выполнения программы,
// например, перед вызовом метода (пример с @Before).


@Component
@Aspect
@Order(10)
public class LoggingAspect {
    @Before("aop.aspects.MyPointcuts.beforeAllAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod(): " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType(): " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName(): " + methodSignature.getName());

        String methodName = methodSignature.getName();
        if (methodName.equals("addBook")) {
            Object[] args = joinPoint.getArgs();

            for(Object arg:args){

                if(arg instanceof String){
                    System.out.println("добавил книгу :" + arg);
                }
                if(arg instanceof Book){
                    System.out.println("название книги:" + ((Book) arg).getName());
                    System.out.println("автор книги:" + ((Book) arg).getAuthor());
                    System.out.println("год публикации:" + ((Book) arg).getYearOfPublication());
                }
            }

        } else {

        }


        System.out.println("beforeAddLoggingAdvice1: логирование при попытке получения книги/журнала");
        System.out.println("---------------------------------------------------");
    }

}
