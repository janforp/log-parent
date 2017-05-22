package com.janita.annotation.bean;

import lombok.Data;

/**
 * Created by Janita on 2017-05-22 13:44
 */
@Data
public class Dog {

    private String name;

    private Double weight;

    private Integer type;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", type=" + type +
                '}';
    }
}
