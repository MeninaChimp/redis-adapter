package org.menina.redis.adapter.client;

import org.menina.redis.adapter.AbstractRedisSupport;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.ScanResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author: Menina
 */

@Component("redisClient")
public class RedisClient extends AbstractRedisSupport {

    @Override
    public Set<String> keys(String pattern){
        if("".equals(pattern)){
            return new HashSet<String>();
        }

        return redisTemplate.keys(pattern);
    }

    @Override
    public Set<byte[]> keys(byte[] pattern){
        if(pattern.length == 0){
            return new HashSet<byte[]>();
        }

        return redisTemplate.keys(pattern);
    }

    @Override
    public ScanResult<String> scan(String cursor){
        return redisTemplate.scan(cursor);
    }

    @Override
    public List<String> sort(String key){
        return redisTemplate.sort(key);
    }

    @Override
    public List<byte[]> sort(byte[] key){
        return redisTemplate.sort(key);
    }

    @Override
    public Long publish(String channel, String message){
        return redisTemplate.publish(channel, message);
    }

    @Override
    public void subscribe(JedisPubSub jedisPubSub, String... channels){
        if(jedisPubSub == null){
            return;
        }

        redisTemplate.subscribe(jedisPubSub, channels);
    }

    @Override
    public Long move(String key, int dbIndex){
        return redisTemplate.move(key, dbIndex);
    }

}
