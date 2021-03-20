package com.huifrank.jedis;

import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.JedisCluster;

import java.nio.charset.Charset;

/**
 * redis集群由无密码模式 热切换 到有密码模式
 */
public class ClusterPass {

    private final String password_key ="password::auth";

    private String password;


    public void init(){

    }


    public boolean authConn(BinaryJedis jedis) {
        try {
            jedis.auth(password);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
