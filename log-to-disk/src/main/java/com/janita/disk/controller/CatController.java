package com.janita.disk.controller;

import com.janita.disk.annotation.CatLog;
import com.janita.disk.bean.Cat;
import com.janita.disk.result.Result;
import com.janita.disk.result.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-05-22 14:15
 */
@RestController
@RequestMapping("/cat")
public class CatController {



    @CatLog
    @GetMapping("/{name}")
    public Result getCatByName (@PathVariable String name) {

        Cat cat = new Cat();
        cat.setColor("红色");
        cat.setName(name);

        return ResultUtils.success(cat);
    }
}
