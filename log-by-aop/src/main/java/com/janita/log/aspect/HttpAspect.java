package com.janita.log.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Janita on 2017-05-22 10:29
 * User服务接口
 */
@Aspect
@Component
public class HttpAspect {

    //spring自带的
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //指定切点
    @Pointcut("execution(public * com.janita.log.controller.*.*(..))")
    public void log() {

    }

   //方法执行之前打印日志
    @Before("log()")
    public void logBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName());

        //方法参数
        logger.info("args={}", joinPoint.getArgs());
    }

    //方法执行之后打印日志
    @After("log()")
    public void doAfter() {
        logger.info("after");
    }

    //打印出方法的返回值
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object);
    }

    //异常时的日志
    @AfterThrowing("log()")
    public void doAfterException() {

    }
}
