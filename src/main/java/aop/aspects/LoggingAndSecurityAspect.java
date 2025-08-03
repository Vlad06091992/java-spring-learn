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


    //описывает, для какого действия(метода) должно выполниться
    @Pointcut("execution(* aop.UniversityLibrary.*(..))") //для такого pointcut.....
    private void allGetMethodsFromUniLibrary(){} //такой обработчик.....

    //описывает когда, и что должно выполнится
    @Before("allUniversityMethodsWithExcludingReturnMagazine()") //перед выполнением такого обработчика....
    public void beforeGetAndReturnLoggingAdvice(){ //выполни это!
        System.out.println("beforeLoggingAdvice: writing log 10");
    }

    @Pointcut("execution(* aop.UniversityLibrary.returnMagazine())")
    private void returnMagazineFromLibrary(){}

    //Комбинирование pointcut'ов
    @Pointcut("allGetMethodsFromUniLibrary() && !returnMagazineFromLibrary()")
    private void allUniversityMethodsWithExcludingReturnMagazine(){}






//    @Pointcut("execution(* aop.UniversityLibrary.get*())")
//        private void allGetMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(* aop.UniversityLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary(){}
//
//    //Комбинирование pointcut'ов
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary(){}
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeLoggingAdvice: writing log 1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeLoggingAdvice: writing log 2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeLoggingAdvice: writing log 3");
//    }

}
