package com.janita.disk;

/**
 * Created by Janita on 2017-05-22 14:13
 * 知道日志输出的位置
 * 即
 * 配置日志文件的位置
 */
public class StepReadMe {

    /**
     *
     * 1.首先打印日志的方法是前面一样的
     *
     * 2.配置logback.xml
     *
     * 3.在 application.properties 配置文件中配置：
     * logging.config=classpath:logback.xml
     * logging.path=D:/workspace/rock/jpa-test/log
     *
     * 则日志文件会在 D:/workspace/rock/jpa-test/log 文件夹下面
     */
}
