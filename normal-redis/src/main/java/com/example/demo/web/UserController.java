package com.example.demo.web;

import com.example.demo.service.RedisService;
import com.google.common.collect.Range;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.data.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class UserController {

    private static String SUCCESS = "SUCCESS";

    @Autowired
    RedisService redisService;

    @GetMapping("/set")
    public String randomSet() {
        redisService .randomSet();

        return  SUCCESS;
    }

    @GetMapping("/batchCollDel")
    public String randomBatchDel(@RequestParam(defaultValue = "1000") int size){
        List<String> list  =new ArrayList<>(size);

        for(int i =0 ;i<size ;i++) {
            list.add(RandomStringUtils.randomAlphabetic(10));
        }

        redisService.batchCollDel(list);
        return SUCCESS;
    }

    @GetMapping("/batchParallelDel")
    public String randomParallelBatchDel(@RequestParam(defaultValue = "1000") int size){
        List<String> list  =new ArrayList<>(size);

        for(int i =0 ;i<size ;i++) {
            list.add(RandomStringUtils.randomAlphabetic(10));
        }

        redisService.batchParallelDel(list);
        return SUCCESS;
    }

    @GetMapping("/batchNormalDel")
    public String randomNormalBatchDel(@RequestParam(defaultValue = "1000") int size){
        List<String> list  =new ArrayList<>(size);

        for(int i =0 ;i<size ;i++) {
            list.add(RandomStringUtils.randomAlphabetic(10));
        }

        redisService.batchNormalDel(list);
        return SUCCESS;
    }
}