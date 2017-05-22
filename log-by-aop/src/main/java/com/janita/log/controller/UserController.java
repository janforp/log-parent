package com.janita.log.controller;

import com.janita.log.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janita on 2017-05-22 10:33
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @PostMapping
    public User createUser(@RequestBody User user){
        return user;
    }

    @GetMapping
    public List<User> listUser(){
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

        return users;
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){

        User user = new User();
        user.setUserId(userId);
        user.setUsername("张三");
        user.setAge(50);

        return user;
    }
}
