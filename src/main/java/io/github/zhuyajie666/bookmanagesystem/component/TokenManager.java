package io.github.zhuyajie666.bookmanagesystem.component;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.zhuyajie666.bookmanagesystem.entity.Manager;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class TokenManager {

//    private Map<String, Manager> tokenManagerMap = new HashedMap();

    @Autowired
    private RedisTemplate redisTemplate;

    public String generateToken(Manager manager) {
        String token = UUID.randomUUID().toString();
//        tokenManagerMap.put(token, manager);

        String json = JSON.toJSONString(manager);
        redisTemplate.opsForValue().set(token,json,1, TimeUnit.DAYS);
        return token;
    }

    public Manager getByToken(String token) {
//        return tokenManagerMap.get(token);
        Object obj = redisTemplate.opsForValue().get(token);
        return obj == null ? null : JSON.parseObject(obj.toString(),Manager.class);
    }

}
