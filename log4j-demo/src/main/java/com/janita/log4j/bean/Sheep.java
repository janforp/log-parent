package com.janita.log4j.bean;

import lombok.Data;

/**
 * Created by Janita on 2017-05-22 15:32
 */
@Data
public class Sheep {

    private String name;

    private String weight;

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
