package com.janita.annotation.service;

import com.janita.annotation.annotation.ULog;
import com.janita.annotation.bean.Dog;
import org.springframework.stereotype.Service;

/**
 * Created by Janita on 2017-05-22 13:45
 */
@Service
public class DogService {

    @ULog
    public Dog getDogByName(String name) {

        Dog dog = new Dog();
        dog.setName(name);
        dog.setType(1);
        dog.setWeight(20.00);

        return dog;
    }
}
