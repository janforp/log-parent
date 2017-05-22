package com.janita.log.controller;

import com.janita.log.domain.User;
import com.janita.log.exception.UserException;
import com.janita.log.result.Result;
import com.janita.log.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Janita on 2017-05-22 10:33
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @PostMapping
    public Result createUser(@RequestBody User user){
        return ResultUtil.success(user);
    }

    @GetMapping
    public Result listUser(){

        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setUserId(1L);
        user1.setUsername("Janita");
        user1.setAge(25);
        User user2 = new User();
        user2.setUserId(2L);
        user2.setUsername("Jay");
        user2.setAge(35);

        users.add(user1);
        users.add(user2);

        return ResultUtil.success(users);
    }

    @GetMapping("/{userId}")
    public Result getUserById(@PathVariable Long userId){

        User user = new User();
        user.setUserId(userId);
        user.setUsername("张三");
        user.setAge(50);
        return ResultUtil.success(user);
    }

    @GetMapping("/age/{userId}")
    public Result getAge (@PathVariable Long userId) {
        Integer age = new Random().nextInt(20);

        if (age < 10) {
            throw new UserException(101,"你还在上小学吧");
        }

        if (age < 16) {
            throw new UserException(102, "你还在上初中吧");
        }

        if (age > 18) {
            throw new UserException(103, "加工资");
        }

        return ResultUtil.success(age);
    }
}
