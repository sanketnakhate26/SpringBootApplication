package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfig {

    Logger logger = LoggerFactory.getLogger(getClass());

    // All class and all methods with all parameters in controller package
//    @Before(value = "execution(* com.example.controller.*.*(..))")
//    public void beforeAdvice(JoinPoint joinPoint){
//        logger.info("Inside Before advice");
//    }

    // All class and all methods with all parameters in controller package with one parameter
//        @Before(value = "execution(* com.example.controller.*.*(..)) and args(object1,object2)")
//        public void beforeAdvice(JoinPoint joinPoint, Object object1, Object object2){
//            logger.info("Request param 1 =  "+object1);
//            logger.info("Request param 2 =  "+object2);
//        }

        //@After in the same way

//    @AfterReturning(value = "execution(* com.example.controller.*.*(..)) and args(object1,object2)",
//            returning = "returningObject")
//    public void afterReturningAdvice(JoinPoint joinPoint, Object object1, Object object2, Object returningObject){
//        logger.info("Request param 1 =  "+object1);
//        logger.info("Request param 2 =  "+object2);
//        logger.info("Request Return  =  "+returningObject);
//    }

    @Around(value = "execution(* com.example.controller.*.*(..)) and args(object1,object2)")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint, Object object1, Object object2) throws Throwable {

            logger.info("Before Around");

            Object returningObject = proceedingJoinPoint.proceed();

            logger.info("After Around "+returningObject);

    }
}
