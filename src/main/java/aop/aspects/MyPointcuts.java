package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyPointcuts {
    @Pointcut("execution(* aop.UniversityLibrary.add*(..))")
    //обязательно PUBLIC!!!
    public void beforeAllAddMethods(){}
}
