package org.menina.redis.adapter.template;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;
import redis.clients.util.Pool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * author: Menina
 */

public class BinaryRedisTemplate extends Template{

    public Long del(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.del(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long sadd(byte[] key, byte[]... member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.sadd(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String set(byte[] key, byte[] value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.set(key, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public byte[] get(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.get(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Boolean exists(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.exists(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String type(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.type(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long expire(byte[] key, int seconds) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.expire(key, seconds);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long expireAt(byte[] key, long unixTime) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.expireAt(key, unixTime);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long ttl(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.ttl(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public byte[] getSet(byte[] key, byte[] value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.getSet(key, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long setnx(byte[] key, byte[] value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.setnx(key, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String setex(byte[] key, int seconds, byte[] value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.setex(key, seconds, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long decrBy(byte[] key, long integer) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.decrBy(key, integer);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long decr(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.decr(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long incrBy(byte[] key, long integer) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.incrBy(key, integer);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long incr(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.incr(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long append(byte[] key, byte[] value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.append(key, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public byte[] substr(byte[] key, int start, int end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.substr(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long hset(byte[] key, byte[] field, byte[] value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hset(key, field, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public byte[] hget(byte[] key, byte[] field) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hget(key, field);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long hsetnx(byte[] key, byte[] field, byte[] value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hsetnx(key, field, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String hmset(byte[] key, Map<byte[], byte[]> hash) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hmset(key, hash);
        } finally {
            this.returnResource(jedis);
        }
    }

    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hmget(key, fields);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long hincrBy(byte[] key, byte[] field, long value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hincrBy(key, field, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Boolean hexists(byte[] key, byte[] field) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hexists(key, field);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long hdel(byte[] key, byte[] field) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hdel(key, field);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long hlen(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hlen(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<byte[]> keys(byte[] pattern) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.keys(pattern);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<byte[]> hkeys(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hkeys(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public List<byte[]> hvals(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hvals(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Map<byte[], byte[]> hgetAll(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hgetAll(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long rpush(byte[] key, byte[] string) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.rpush(key, string);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long lpush(byte[] key, byte[] string) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lpush(key, string);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long llen(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.llen(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public List<byte[]> lrange(byte[] key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lrange(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String ltrim(byte[] key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.ltrim(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public byte[] lindex(byte[] key, long index) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lindex(key, index);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String lset(byte[] key, long index, byte[] value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lset(key, index, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long lrem(byte[] key, long count, byte[] value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lrem(key, count, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public byte[] lpop(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lpop(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public byte[] rpop(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.rpop(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long sadd(byte[] key, byte[] member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.sadd(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<byte[]> smembers(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.smembers(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long srem(byte[] key, byte[]... member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.srem(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public byte[] spop(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.spop(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long scard(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.scard(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Boolean sismember(byte[] key, byte[] member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.sismember(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<String> sdiff(String... keys){
        Jedis jedis = resourcePool.getResource();
        try{
            return jedis.sdiff(keys);
        }finally {
            this.returnResource(jedis);
        }
    }

    public Set<byte[]> sdiff(byte[]... keys){
        Jedis jedis = resourcePool.getResource();
        try{
            return jedis.sdiff(keys);
        }finally {
            this.returnResource(jedis);
        }
    }

    public byte[] srandmember(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.srandmember(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public List<byte[]> srandmember(byte[] key, int count) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.srandmember(key, count);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zadd(byte[] key, double score, byte[] member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zadd(key, score, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<byte[]> zrange(byte[] key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrange(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zrem(byte[] key, byte[] member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrem(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Double zincrby(byte[] key, double score, byte[] member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zincrby(key, score, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zrank(byte[] key, byte[] member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrank(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zrevrank(byte[] key, byte[] member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrank(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<byte[]> zrevrange(byte[] key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrange(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<Tuple> zrangeWithScores(byte[] key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrangeWithScores(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<Tuple> zrevrangeWithScores(byte[] key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrangeWithScores(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zcard(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zcard(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Double zscore(byte[] key, byte[] member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zscore(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public List<byte[]> sort(byte[] key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.sort(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public List<byte[]> sort(byte[] key, SortingParams sortingParameters) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.sort(key, sortingParameters);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zcount(byte[] key, double min, double max) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zcount(key, min, max);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<byte[]> zrangeByScore(byte[] key, double min, double max) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrangeByScore(key, min, max);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrangeByScore(key, min, max, offset, count);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrangeByScoreWithScores(key, min, max);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrangeByScoreWithScores(key, min, max, offset, count);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrangeByScore(key, max, min);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrangeByScore(key, max, min, offset, count);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrangeByScoreWithScores(key, max, min);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zremrangeByRank(byte[] key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zremrangeByRank(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zremrangeByScore(byte[] key, double start, double end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zremrangeByScore(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, long time) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.set(key, value, nxxx, expx, time);
        } finally {
            this.returnResource(jedis);
        }
    }

    @Override
    public void setDataSource(Pool<Jedis> resourcePool) {
        this.resourcePool = resourcePool;
    }

    @Override
    public void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
