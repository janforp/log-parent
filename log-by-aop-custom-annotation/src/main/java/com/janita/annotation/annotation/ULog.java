package com.janita.annotation.annotation;

import java.lang.annotation.*;

/**
 * Created by Janita on 2017-05-22 13:53
 *
 * 自定义注解
 * 使用此注解的方法就会使用log
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ULog {
}
