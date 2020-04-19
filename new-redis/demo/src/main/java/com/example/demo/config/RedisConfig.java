package com.example.demo.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;


@Configuration
public class RedisConfig {

    private final RedisProperties properties;

    public RedisConfig(RedisProperties properties) {
        this.properties = properties;
    }


    @Bean
    public JedisConnectionFactory redisConnectionFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setTestOnBorrow(true);
        RedisClusterConfiguration redisClusterConfiguration  = new RedisClusterConfiguration(properties.getCluster().getNodes());


        return  new JedisConnectionFactory(redisClusterConfiguration, jedisPoolConfig);


}

}
