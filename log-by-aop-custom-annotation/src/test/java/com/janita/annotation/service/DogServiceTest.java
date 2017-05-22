package com.janita.annotation.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Janita on 2017-05-22 14:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DogServiceTest {

    @Autowired
    private DogService dogService;

    @Test
    public void getDogByName() throws Exception {
        dogService.getDogByName("xiaox");
    }

}