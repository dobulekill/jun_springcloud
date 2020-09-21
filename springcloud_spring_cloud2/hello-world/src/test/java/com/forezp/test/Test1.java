package com.forezp.test;

import com.forezp.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {
    @Test
    public void contextLoads(){

    }
    @Autowired
    RedisDao redisDao;

    @Test
    public void testRedis(){
        redisDao.setKey("name","zhangsan");
        redisDao.setKey("age","12");
        System.out.println(redisDao.getValue("name"));
        System.out.println(redisDao.getValue("age"));
    }
}
