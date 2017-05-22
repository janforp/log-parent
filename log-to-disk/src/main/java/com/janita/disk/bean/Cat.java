package com.janita.disk.bean;

import lombok.Data;

/**
 * Created by Janita on 2017-05-22 14:14
 */
@Data
public class Cat {

    private String name ;

    private String color;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
