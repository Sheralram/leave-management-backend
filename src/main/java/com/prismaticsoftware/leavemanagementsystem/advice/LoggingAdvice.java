package com.prismaticsoftware.leavemanagementsystem.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Purpose : Implement AOP to handle logging mechanism so than dry principle will not be affected
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 15-12-2021
 */
@Aspect
@Component
@Slf4j
public class LoggingAdvice {

    /**
     * Purpose : This method is used to apply the PointCut(logging mechanism) around the whole application
     */
    @Pointcut(value="execution(* com.prismaticsoftware.leavemanagementsystem.*.*.*(..) )")
    public void myPointCut() {

    }
    /**
     * Purpose : This method is used to define the source methods and class to invoke log and also getting response after logging execution
     *
     * @param : the  proceeding Join Point to access the logging mechanism
     * @return the response after execution of log
     * @throws Throwable throws an exception if occurred
     */

    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper(); //to get the output in JSON format
        String methodName = proceedingJoinPoint.getSignature().getName(); //to get the method name
        String className = proceedingJoinPoint.getTarget().getClass().toString(); //to get the class name
        Object[] array = proceedingJoinPoint.getArgs(); //to get the inputs
        //before executing the method invoking method and class name corresponding the arguments
        log.info("method invoked"+className+" : "+methodName+"()"+"arguments : "
                +mapper.writeValueAsString(array));
        Object object = proceedingJoinPoint.proceed();
        //after executing the method get back the response of that particular class or method
        log.info(className+" : "+methodName+"()"+"response : "
                +mapper.writeValueAsString(object));
        return object;
    }
}
