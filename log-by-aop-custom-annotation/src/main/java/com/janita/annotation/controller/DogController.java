package com.janita.annotation.controller;

import com.janita.annotation.annotation.ULog;
import com.janita.annotation.result.Result;
import com.janita.annotation.result.ResultUtils;
import com.janita.annotation.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-05-22 13:45
 */
@RestController
@RequestMapping(value = "/dog")
public class DogController {


    @Autowired
    private DogService dogService;

    /**
     *  @ULog针对此进行AOP增强
     * @param name
     * @return
     */
    @ULog
    @GetMapping("/{name}")
    public Result getDogByName(@PathVariable String name) {

        return ResultUtils.success(dogService.getDogByName(name));
    }
}
