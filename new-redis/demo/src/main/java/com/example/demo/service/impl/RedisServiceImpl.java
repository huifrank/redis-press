package com.example.demo.service.impl;

import com.example.demo.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public void randomSet() {

        String key = RandomStringUtils.randomNumeric(5);
        String value = RandomStringUtils.randomNumeric(5);
        redisTemplate.opsForValue().set(key,value);

    }

    @Override
    public void batchCollDel(List<String> list){
        redisTemplate.delete(list);
    }

    @Override
    public void batchParallelDel(List<String> list){
        list.parallelStream().forEach(redisTemplate::delete);
    }

    @Override
    public void batchNormalDel(List< String> list){
        list.stream().forEach(redisTemplate::delete);
    }

    @Override
    public Optional<Object> get(String key){
        return Optional.ofNullable(redisTemplate.opsForValue().get(key));
    }
}
