package com.janita.log4j.controller;

import com.janita.log4j.bean.Sheep;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-05-22 15:33
 */
@RestController
@RequestMapping("/sheep")
public class SheepController {

    @GetMapping("/{name}")
    public Sheep getSheepByName(@PathVariable String name) {

        Sheep sheep = new Sheep();
        sheep.setName(name);
        sheep.setWeight("50KG");

        return sheep;
    }
}
