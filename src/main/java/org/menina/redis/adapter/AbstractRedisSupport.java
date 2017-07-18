package org.menina.redis.adapter;

import org.menina.redis.adapter.extend.ExtendOperationSupport;
import org.menina.redis.adapter.template.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * author: Menina
 */

public abstract class AbstractRedisSupport implements RedisSupport {

    @Autowired
    protected RedisTemplate redisTemplate;

    @Autowired
    protected ExtendOperationSupport extendOperationSupport;

    @Override
    public String get(String key) {
        return redisTemplate.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisTemplate.set(key, value);
    }

    @Override
    public void expireAt(String key, long unixTimeSeconds) {
        redisTemplate.expireAt(key, unixTimeSeconds);
    }

    @Override
    public void expire(String key, int seconds) {
        redisTemplate.expire(key, seconds);
    }

    @Override
    public Long ttl(String key) {
        return redisTemplate.ttl(key);
    }

    @Override
    public Long del(String key) {
        return redisTemplate.del(key);
    }

    @Override
    public String hget(String key, String field) {
        return redisTemplate.hget(key,field);
    }

    @Override
    public void hset(String key, String field, String value) {
        redisTemplate.hset(key, field, value);
    }

    @Override
    public void hmset(String key, Map<String, String> hash) {
        redisTemplate.hmset(key, hash);
    }

    @Override
    public List<String> hmget(String key, String... fields) {
        return redisTemplate.hmget(key, fields);
    }

    @Override
    public Boolean exists(String key) {
        return redisTemplate.exists(key);
    }

    @Override
    public Boolean hexists(String key, String field) {
        return redisTemplate.hexists(key, field);
    }

    @Override
    public void hdel(String key, String field) {
        redisTemplate.hdel(key, field);
    }

    @Override
    public Long setnx(String key, String value) {
        return redisTemplate.setnx(key, value);
    }

    @Override
    public void setex(String key, int seconds, String value) {
        redisTemplate.setex(key, seconds, value);
    }

    @Override
    public Long decr(String key) {
        return redisTemplate.decr(key);
    }

    @Override
    public Long decrBy(String key, long number) {
        return redisTemplate.decrBy(key, number);
    }

    @Override
    public Long incr(String key) {
        return redisTemplate.incr(key);
    }

    @Override
    public Long incrBy(String key, long number) {
        return redisTemplate.incrBy(key, number);
    }

    @Override
    public Long append(String key, String value) {
        return redisTemplate.append(key, value);
    }

    @Override
    public String substr(String key, int start, int end) {
        return redisTemplate.substr(key, start, end);
    }

    @Override
    public byte[] get(byte[] key) {
        return redisTemplate.get(key);
    }

    @Override
    public void set(byte[] key, byte[] value) {
        redisTemplate.set(key, value);
    }

    @Override
    public void expireAt(byte[] key, long unixTime) {
        redisTemplate.expireAt(key, unixTime);
    }

    @Override
    public void expire(byte[] key, int seconds) {
        redisTemplate.expire(key, seconds);
    }

    @Override
    public Long ttl(byte[] key) {
        return redisTemplate.ttl(key);
    }

    @Override
    public Long del(byte[] key) {
        return redisTemplate.del(key);
    }

    @Override
    public byte[] hget(byte[] key, byte[] field) {
        return redisTemplate.hget(key,field);
    }

    @Override
    public void hset(byte[] key, byte[] field, byte[] value) {
        redisTemplate.hset(key, field, value);
    }

    @Override
    public void hmset(byte[] key, Map<byte[], byte[]> hash) {
        redisTemplate.hmset(key, hash);
    }

    @Override
    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        return redisTemplate.hmget(key, fields);
    }

    @Override
    public Boolean exists(byte[] key) {
        return redisTemplate.exists(key);
    }

    @Override
    public Boolean hexists(byte[] key, byte[] field) {
        return redisTemplate.hexists(key, field);
    }

    @Override
    public void hdel(byte[] key, byte[] field) {
        redisTemplate.hdel(key, field);
    }

    @Override
    public Long setnx(byte[] key, byte[] value) {
        return redisTemplate.setnx(key, value);
    }

    @Override
    public void setex(byte[] key, int seconds, byte[] value) {
        redisTemplate.setex(key, seconds, value);
    }

    @Override
    public Long decr(byte[] key) {
        return redisTemplate.decr(key);
    }

    @Override
    public Long decrBy(byte[] key, long number) {
        return redisTemplate.decrBy(key, number);
    }

    @Override
    public Long incr(byte[] key) {
        return redisTemplate.incr(key);
    }

    @Override
    public Long incrBy(byte[] key, long number) {
        return redisTemplate.incrBy(key, number);
    }

    @Override
    public String type(byte[] key) {
        return redisTemplate.type(key);
    }

    @Override
    public String type(String key) {
        return redisTemplate.type(key);
    }

    @Override
    public Long hsetnx(String key, String field, String value) {
        return redisTemplate.hsetnx(key, field, value);
    }

    @Override
    public Long hsetnx(byte[] key, byte[] field, byte[] value) {
        return redisTemplate.hsetnx(key, field, value);
    }

    @Override
    public Long hlen(String key) {
        return redisTemplate.hlen(key);
    }

    @Override
    public Long hlen(byte[] key) {
        return redisTemplate.hlen(key);
    }

    @Override
    public Set<String> hkeys(String key) {
        return redisTemplate.hkeys(key);
    }

    @Override
    public Set<byte[]> hkeys(byte[] key) {
        return redisTemplate.hkeys(key);
    }

    @Override
    public List<String> hvals(String key) {
        return redisTemplate.hvals(key);
    }

    @Override
    public List<byte[]> hvals(byte[] key) {
        return redisTemplate.hvals(key);
    }

    @Override
    public Long hincrBy(String key, String field, long number) {
        return redisTemplate.hincrBy(key, field, number);
    }

    @Override
    public Long hincrBy(byte[] key, byte[] field, long number) {
        return redisTemplate.hincrBy(key, field, number);
    }

    @Override
    public Long rpush(String key, String value) {
        return redisTemplate.rpush(key, value);
    }

    @Override
    public Long rpush(byte[] key, byte[] value) {
        return redisTemplate.rpush(key, value);
    }

    @Override
    public Long lpush(String key, String value) {
        return redisTemplate.lpush(key, value);
    }

    @Override
    public Long lpush(byte[] key, byte[] value) {
        return redisTemplate.lpush(key, value);
    }

    @Override
    public Long llen(String key) {
        return redisTemplate.llen(key);
    }

    @Override
    public Long llen(byte[] key) {
        return redisTemplate.llen(key);
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        return redisTemplate.lrange(key, start, end);
    }

    @Override
    public List<byte[]> lrange(byte[] key, long start, long end) {
        return redisTemplate.lrange(key, start, end);
    }

    @Override
    public Long sadd(String setName, String member) {
        return redisTemplate.sadd(setName, member);
    }

    @Override
    public Long sadd(byte[] setName, byte[] member) {
        return redisTemplate.sadd(setName, member);
    }

    @Override
    public Set<String> smembers(String setName) {
        return redisTemplate.smembers(setName);
    }

    @Override
    public Set<byte[]> smembers(byte[] setName) {
        return redisTemplate.smembers(setName);
    }

    @Override
    public Long srem(String setName, String member) {
        return redisTemplate.srem(setName, member);
    }

    @Override
    public Long srem(byte[] setName, byte[] member) {
        return redisTemplate.srem(setName, member);
    }

    @Override
    public String spop(String key) {
        return redisTemplate.spop(key);
    }

    @Override
    public byte[] spop(byte[] key) {
        return redisTemplate.spop(key);
    }

    @Override
    public String lpop(String key) {
        return redisTemplate.lpop(key);
    }

    @Override
    public byte[] lpop(byte[] key) {
        return  redisTemplate.lpop(key);
    }

    @Override
    public String rpop(String key) {
        return redisTemplate.rpop(key);
    }

    @Override
    public byte[] rpop(byte[] key) {
        return redisTemplate.rpop(key);
    }

    @Override
    public Long scard(String key) {
        return redisTemplate.scard(key);
    }

    @Override
    public Long scard(byte[] key) {
        return redisTemplate.scard(key);
    }

    @Override
    public Boolean sismember(String key, String member) {
        return redisTemplate.sismember(key, member);
    }

    @Override
    public Boolean sismember(byte[] key, byte[] member) {
        return redisTemplate.sismember(key, member);
    }

    @Override
    public String srandmember(String key) {
        return redisTemplate.srandmember(key);
    }

    @Override
    public byte[] srandmember(byte[] key) {
        return redisTemplate.srandmember(key);
    }

    @Override
    public Long setrange(String key, long offset, String value) {
        return redisTemplate.setrange(key, offset, value);
    }

    @Override
    public String getrange(String key, long startOffset, long endOffset) {
        return redisTemplate.getrange(key, startOffset, endOffset);
    }

    @Override
    public String getSet(String key, String value) {
        return redisTemplate.getSet(key, value);
    }

    @Override
    public String ltrim(String key, long start, long end) {
        return redisTemplate.ltrim(key, start, end);
    }

    @Override
    public String ltrim(byte[] key, long start, long end) {
        return redisTemplate.ltrim(key, start, end);
    }

    @Override
    public String lindex(String key, long index) {
        return redisTemplate.lindex(key, index);
    }

    @Override
    public byte[] lindex(byte[] key, long index) {
        return redisTemplate.lindex(key, index);
    }

    @Override
    public String lset(String key, long index, String value) {
        return redisTemplate.lset(key, index, value);
    }

    @Override
    public String lset(byte[] key, long index, byte[] value) {
        return redisTemplate.lset(key, index, value);
    }

    @Override
    public Long lrem(String key, long count, String value) {
        return redisTemplate.lrem(key, count, value);
    }

    @Override
    public Long lrem(byte[] key, long count, byte[] value) {
        return redisTemplate.lrem(key, count, value);
    }

    @Override
    public Long zadd(String key, double score, String member) {
        return redisTemplate.zadd(key, score, member);
    }

    @Override
    public Long zadd(byte[] key, double score, byte[] member) {
        return redisTemplate.zadd(key, score, member);
    }

    @Override
    public Set<String> zrange(String key, long start, long end) {
        return redisTemplate.zrange(key, start, end);
    }

    @Override
    public Set<byte[]> zrange(byte[] key, long start, long end) {
        return redisTemplate.zrange(key, start, end);
    }

    @Override
    public Long zrem(String key, String member) {
        return redisTemplate.zrem(key, member);
    }

    @Override
    public Long zrem(byte[] key, byte[] member) {
        return redisTemplate.zrem(key, member);
    }

    @Override
    public Double zincrby(String key, double score, String member) {
        return redisTemplate.zincrby(key, score, member);
    }

    @Override
    public Double zincrby(byte[] key, double scope, byte[] member) {
        return redisTemplate.zincrby(key, scope, member);
    }

    @Override
    public Long zrank(String key, String member) {
        return redisTemplate.zrank(key, member);
    }

    @Override
    public Long zrank(byte[] key, byte[] member) {
        return redisTemplate.zrank(key, member);
    }

    @Override
    public Long zrevrank(String key, String member) {
        return redisTemplate.zrevrank(key, member);
    }

    @Override
    public Long zrevrank(byte[] key, byte[] member) {
        return redisTemplate.zrevrank(key, member);
    }

    @Override
    public Set<String> zrevrange(String key, long start, long end) {
        return redisTemplate.zrevrange(key, start, end);
    }

    @Override
    public Set<byte[]> zrevrange(byte[] key, long start, long end) {
        return redisTemplate.zrevrange(key, start, end);
    }

    @Override
    public Set<Tuple> zrangeWithScores(String key, long start, long end) {
        return redisTemplate.zrangeWithScores(key, start, end);
    }

    @Override
    public Set<Tuple> zrangeWithScores(byte[] key, long start, long end) {
        return redisTemplate.zrangeWithScores(key, start, end);
    }

    @Override
    public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
        return redisTemplate.zrevrangeWithScores(key, start, end);
    }

    @Override
    public Set<Tuple> zrevrangeWithScores(byte[] key, long start, long end) {
        return redisTemplate.zrevrangeWithScores(key, start, end);
    }

    @Override
    public Long zcard(String key) {
        return redisTemplate.zcard(key);
    }

    @Override
    public Long zcard(byte[] key) {
        return redisTemplate.zcard(key);
    }

    @Override
    public Double zscore(String key, String member) {
        return redisTemplate.zscore(key, member);
    }

    @Override
    public Double zscore(byte[] key, byte[] member) {
        return redisTemplate.zscore(key, member);
    }

    @Override
    public Long zcount(String key, double min, double max) {
        return redisTemplate.zcount(key, min, max);
    }

    @Override
    public Long zcount(byte[] key, double min, double max) {
        return redisTemplate.zcount(key, min, max);
    }

    @Override
    public Long zremrangeByRank(String key, long min, long max) {
        return redisTemplate.zremrangeByRank(key, min, max);
    }

    @Override
    public Long zremrangeByRank(byte[] key, long min, long max) {
        return redisTemplate.zremrangeByRank(key, min, max);
    }

    @Override
    public Long zremrangeByScore(String key, long min, long max) {
        return redisTemplate.zremrangeByScore(key, min, max);
    }

    @Override
    public Long zremrangeByScore(byte[] key, long min, long max) {
        return redisTemplate.zremrangeByScore(key, min, max);
    }

    @Override
    public Long persist(String key) {
        return redisTemplate.persist(key);
    }

    @Override
    public Long sadd(String key, Set<String> members) {
        if(members.size() == 0){
            return 0L;
        }

        String[] strArr = members.toArray(new String[]{});
        return redisTemplate.sadd(key, strArr);
    }

    @Override
    public Long sadd(byte[] key, Set<byte[]> members) {
        if(members.size() == 0){
            return 0L;
        }

        byte[][] byteArr = members.toArray(new byte[][]{});
        return redisTemplate.sadd(key, byteArr);
    }

    @Override
    public Long sadd(String key, List<String> members) {
        if(members.size() == 0){
            return 0L;
        }

        String[] strArr = members.toArray(new String[]{});
        return redisTemplate.sadd(key, strArr);
    }

    @Override
    public Long sadd(byte[] key, List<byte[]> members) {
        if(members.size() == 0){
            return 0L;
        }

        byte[][] byteArr = members.toArray(new byte[][]{});
        return redisTemplate.sadd(key, byteArr);
    }

    @Override
    public List<String> hmget(String key, List<String> fields) {
        String[] strArr = fields.toArray(new String[]{});
        return redisTemplate.hmget(key, strArr);
    }

    @Override
    public Long del(List<String> keys) {
        if(keys.size() == 0){
            return 0L;
        }

        String[] strArr = keys.toArray(new String[]{});
        return redisTemplate.del(strArr);
    }

    @Override
    public Long del(Set<String> keys) {
        if(keys.size() == 0){
            return 0L;
        }

        String[] strArr = keys.toArray(new String[]{});
        return redisTemplate.del(strArr);
    }

    @Override
    public Long delByPattern(String pattern) throws UnsupportedOperationException {
        if("".equals(pattern)){
            return 0L;
        }

        Set<String> keys = this.keys(pattern);
        return this.del(keys);
    }

    @Override
    public List<String> srandmember(String key, int count) {
        return redisTemplate.srandmember(key, count);
    }

    @Override
    public List<byte[]> srandmember(byte[] key, int count) {
        return redisTemplate.srandmember(key, count);
    }

    @Override
    public Long srem(String setName, List<String> members) {
        return redisTemplate.srem(setName, members.toArray(new String[]{}));
    }

    @Override
    public Long srem(byte[] setName, byte[]... members) {
        return redisTemplate.srem(setName, members);
    }

    @Override
    public Long setOnExpire(String key, String value, int liveTime, TimeUnit timeUnit, boolean exist) {
        long millsSeconds = TimeUnit.MILLISECONDS.convert(liveTime, timeUnit);
        String result = null;
        if(exist){
            result = redisTemplate.set(key, value, "XX", "PX", millsSeconds);
        }else {
            result = redisTemplate.set(key, value, "NX", "PX", millsSeconds);
        }

        return "OK".equals(result) ? 1L : 0;
    }

    @Override
    public Long setOnExpire(byte[] key, byte[] value, int liveTime, TimeUnit timeUnit, boolean exist) {
        long millsSeconds = TimeUnit.MILLISECONDS.convert(liveTime, timeUnit);
        String result = null;
        if(exist){
            result = redisTemplate.set(key, value, "XX".getBytes(), "PX".getBytes(), millsSeconds);
        }else {
            result = redisTemplate.set(key, value, "NX".getBytes(), "PX".getBytes(), millsSeconds);
        }

        return "OK".equals(result) ? 1L :0;
    }

    @Override
    public Set<String> sdiff(String... keys) {
        return redisTemplate.sdiff(keys);
    }

    @Override
    public Set<byte[]> sdiff(byte[]... keys) {
        return redisTemplate.sdiff(keys);
    }

    @Override
    public ExtendOperationSupport extend() {
        return this.extendOperationSupport;
    }
}
