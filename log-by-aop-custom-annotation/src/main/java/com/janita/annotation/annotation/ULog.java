package com.janita.annotation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Janita on 2017-05-22 13:53
 *
 * 自定义注解
 * 使用此注解的方法就会使用log
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface ULog {
}
