package com.janita.log.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Janita on 2017-05-22 10:31
 */
@Data
public class User implements Serializable {

    private Long userId;

    private String username;

    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
