package com.xh.export.service.impl;

import com.xh.export.pojo.Lansen;
import com.xh.export.service.XhExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author xt
 * @date 2020/8/10
 */
@Service
public class XhExportServiceImpl implements XhExportService {


    private final MongoTemplate mongoTemplate;

    private  RedisTemplate redisTemplate;

    @Autowired
    public  XhExportServiceImpl(MongoTemplate mongoTemplate,
                                RedisTemplate redisTemplate){
        this.mongoTemplate = mongoTemplate;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String test() {
        Lansen lansen= new Lansen();
        lansen.setName("lansen1");
        lansen.setZjb("xll1");
        mongoTemplate.save(lansen);
        this.setRedis("xh:redis:xx" , "11111122223333");




        return "XhExportServiceImpl";
    }

    private void setRedis(final String key , Object value){
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key , value  , 10000);
    }
}
