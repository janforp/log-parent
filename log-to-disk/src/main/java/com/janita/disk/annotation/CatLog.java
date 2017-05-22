package com.janita.disk.annotation;

import java.lang.annotation.*;

/**
 * Created by Janita on 2017-05-22 14:17
 */

@Documented
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CatLog {
}
