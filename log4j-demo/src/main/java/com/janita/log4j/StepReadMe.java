package com.janita.log4j;

/**
 * Created by Janita on 2017-05-22 15:36
 */
public class StepReadMe {

    /**
     * springboot默认使用logback
     *
     * 现在使用log4j的步骤
     *
     * 1.<dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter</artifactId>
     <exclusions>
     <exclusion>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-logging</artifactId>
     </exclusion>
     </exclusions>
     </dependency>

     <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-log4j</artifactId>
     </dependency>
     */


    /**
     * 2.  <artifactId>spring-boot-starter-aop</artifactId>
     */

    /**
     * log4j.properties
     */
}
