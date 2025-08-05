package aop.aspects;

import aop.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
    //Before выполняется до метода с основной логикой
    @Before("execution(* aop.University.getStudents())")
    public void BeforeGetStudentsLoggingAdvice() {
        System.out.println("BeforeGetStudentsLoggingAdvice: логируем получение списка студентов перед методов getStudents");
    }

    //AfterReturning выполняется только после нормального окончания метода с основной логикой
    //Можем перехватывать и менять значения
    @AfterReturning(pointcut = "execution(* aop.University.getStudents())", returning = "students")
    public void AfterReturningGetStudentsLoggingAdvice(JoinPoint joinPoint, List<Student> students) {
        //также можем работать с JoinPoint + MethodSignature в этом advice
        System.out.println("args" + joinPoint.getArgs());


        Student firstStudent = students.get(0);
        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mr." + nameSurname;
        firstStudent.setNameSurname(nameSurname);
        firstStudent.setAvgScore(10);

        System.out.println("AfterReturningGetStudentsLoggingAdvice: логируем получение списка студентов после работы метода getStudents");
    }

    //AfterThrowing выполняется только после окончания метода если в нем было выброшено исключение
    //нельзя обработать исключение, можно получить лишь доступ к исключению
    @After("execution(* aop.University.getStudents())")
    public void AfterGetStudentsLoggingAdvice(JoinPoint joinPoint) {
        joinPoint.getSignature();
        System.out.println("AfterGetStudentsLoggingAdvice: логируем нормальную работу метода или выброс исключения");
    }

    //AfterThrowing выполняется только после окончания метода если в нем было выброшено исключение
    //нельзя обработать исключение, можно получить лишь доступ к исключению
    @AfterThrowing(pointcut = "execution(* aop.University.getStudents())",throwing = "exception")
    public void AfterThrowingGetStudentsLoggingAdvice(Throwable exception) {
        System.out.println("AfterThrowingGetStudentsLoggingAdvice: логируем выброс исключения в getStudents " + exception);
    }
}

