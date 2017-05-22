package com.janita.log.controller;

import com.janita.log.domain.User;
import com.janita.log.enums.ResultEnum;
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
            throw new UserException(ResultEnum.PRIMARY_SCHOOL);
        }

        if (age < 16) {
            throw new UserException(ResultEnum.MIDDLE_SCHOOL);
        }

        if (age > 18) {
            throw new UserException(ResultEnum.RAISE_SALARY);
        }

        return ResultUtil.success(age);
    }

    @DeleteMapping
    public Result throwEx () throws Exception {
        throw new Exception("出错了");
    }
}
