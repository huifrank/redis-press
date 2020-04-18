package com.example.demo.service;

import java.util.List;

public interface RedisService {


     void randomSet();

     void batchCollDel(List<String> list);

     void batchParallelDel(List<String> list);

     void batchNormalDel(List<String> list);
}
