package com.janita.annotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Janita on 2017-05-22 13:55
 */
@Aspect
@Component
public class HLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(HLogAspect.class);
    /**
     * 自定义切面
     * 针对有此注解的方法增强操作
     * 即AOP操作
     */
    @Pointcut("@annotation(com.janita.annotation.annotation.ULog)")
    public void annotationPointCut() {}

    //方法执行之前打印日志
    @Before("annotationPointCut()")
    public void logBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        //method
        logger.info("method={}", request.getMethod());

        //url
        logger.info("url={}", request.getRequestURL());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",
                joinPoint.getSignature().getDeclaringTypeName()
                        + "." + joinPoint.getSignature().getName());

        //方法参数
        logger.info("args={}", joinPoint.getArgs());
    }

    //打印出方法的返回值
    @AfterReturning(returning = "object",pointcut = "annotationPointCut()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object);
    }


}
