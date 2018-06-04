package com.hust.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HYLJ on 2018/6/3 0003.
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


   /* 重复的太多，用下面的替换
   @Before("execution(public * com.hust.Controller.GrilController.*(..))")
    public void log(){
        System.out.println("拦截成功");
    }

    @After("execution(public * com.hust.Controller.GrilController.*(..))")
    public void doAfter(){
        System.out.println("之后");
    }*/

    @Pointcut("execution(public * com.hust.Controller.GrilController.*(..))")
    public void log(){
    }


    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("22222");
        //System.out.println("之后");
    }

   @AfterReturning(returning ="object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object);
    }

}
