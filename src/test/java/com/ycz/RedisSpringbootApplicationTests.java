package com.ycz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycz.pojo.User;
import com.ycz.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisSpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {

        //  opsForValue 操作字符串
        //  opsForList  操作List
        //  opsForSet    操作Set
        //  opsForHash  操作Hash
        //opsForZSet()
        //  opsForGeo() 操作地理位置
        //opsForHyperLogLog()
        //redisTemplate.multi();

//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();

        redisTemplate.opsForValue().set("ycz","zqj");
        Object ycz = redisTemplate.opsForValue().get("ycz");
        System.out.println(ycz);
    }


    @Test
    public void test2() throws JsonProcessingException {
        User user = new User("ycz", 18);
       // String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    public void test3(){
        redisUtil.set("ycz","12312412");
        System.out.println(redisUtil.get("ycz"));
    }

}
