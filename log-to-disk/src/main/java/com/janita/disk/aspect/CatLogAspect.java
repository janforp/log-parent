package com.janita.disk.aspect;

import com.janita.disk.controller.CatController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Janita on 2017-05-22 14:19
 */
@Aspect
@Component
public class CatLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(CatController.class);

    @Pointcut("@annotation(com.janita.disk.annotation.CatLog)")
    public void logPointCut() {}

    //方法执行之前打印日志
    @Before("logPointCut()")
    public void logBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //method
        logger.info("method={}", request.getMethod());

        //url
        logger.info("url={}", request.getRequestURL());

        //类方法
        logger.info("class_method={}",
                joinPoint.getSignature().getDeclaringTypeName()
                        + "." + joinPoint.getSignature().getName());

        //方法参数
        logger.info("args={}", joinPoint.getArgs());
    }

    //打印出方法的返回值
//    @AfterReturning(returning = "object",pointcut = "logPointCut()")
//    public void doAfterReturning(Object object) {
//        logger.info("response={}", object);
//    }

    //异常时的日志
    @AfterThrowing(throwing = "e", pointcut = "logPointCut()")
    public void doAfterException(Throwable e) {
        logger.info("exception={}", e.getMessage());
    }
}
