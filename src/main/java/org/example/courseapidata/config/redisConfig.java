package org.example.courseapidata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class redisConfig {

    @Bean
    public RedisConnectionFactory getConnectionFactory()
    {
        return new LettuceConnectionFactory();
    }

//    @Bean
//    public RedisTemplate<Integer,topics> redisTemplate()
//    {
//        RedisTemplate<Integer,topics> redisTemplate=new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(getConnectionFactory());
//        return redisTemplate;
//    }


}