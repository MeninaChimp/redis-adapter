package org.menina.redis.adapter.template;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * author: Menina
 */

public class RedisTemplate extends BinaryRedisTemplate{

    public String set(String key, String value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.set(key, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String get(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.get(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Boolean exists(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.exists(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String type(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.type(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long expire(String key, int seconds) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.expire(key, seconds);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long expireAt(String key, long unixTime) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.expireAt(key, unixTime);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long ttl(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.ttl(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Boolean setbit(String key, long offset, boolean value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.setbit(key, offset, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Boolean getbit(String key, long offset) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.getbit(key, offset);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long setrange(String key, long offset, String value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.setrange(key, offset, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String getrange(String key, long startOffset, long endOffset) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.getrange(key, startOffset, endOffset);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String getSet(String key, String value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.getSet(key, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long setnx(String key, String value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.setnx(key, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String setex(String key, int seconds, String value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.setex(key, seconds, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long decrBy(String key, long integer) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.decrBy(key, integer);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long decr(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.decr(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long incrBy(String key, long integer) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.incrBy(key, integer);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long incr(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.incr(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long append(String key, String value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.append(key, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String substr(String key, int start, int end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.substr(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long hset(String key, String field, String value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hset(key, field, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String hget(String key, String field) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hget(key, field);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long hsetnx(String key, String field, String value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hsetnx(key, field, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String hmset(String key, Map<String, String> hash) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hmset(key, hash);
        } finally {
            this.returnResource(jedis);
        }
    }

    public List<String> hmget(String key, String... fields) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hmget(key, fields);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long hincrBy(String key, String field, long value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hincrBy(key, field, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Boolean hexists(String key, String field) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hexists(key, field);
        } finally {
            this.returnResource(jedis);
        }
    }

    public ScanResult<String> scan(String cursor) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.scan(cursor);
        } finally {
            this.returnResource(jedis);
        }
    }

    public ScanResult<Entry<String, String>> hscan(String key, String cursor) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hscan(key, cursor);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long del(String... key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.del(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long del(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.del(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long hdel(String key, String field) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hdel(key, field);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long hlen(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hlen(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<String> hkeys(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hkeys(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public List<String> hvals(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hvals(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Map<String, String> hgetAll(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.hgetAll(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long rpush(String key, String string) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.rpush(key, string);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long rpush(String key, String... strings) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.rpush(key, strings);
        } finally {
            this.returnResource(jedis);
        }
    }


    public Long lpush(String key, String... strings) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lpush(key, strings);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long lpush(String key, String string) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lpush(key, string);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long llen(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.llen(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public List<String> lrange(String key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lrange(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String ltrim(String key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.ltrim(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String lindex(String key, long index) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lindex(key, index);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String lset(String key, long index, String value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lset(key, index, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long lrem(String key, long count, String value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lrem(key, count, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String lpop(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.lpop(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String rpop(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.rpop(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long sadd(String key, String... member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.sadd(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long sadd(String key, String member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.sadd(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<String> smembers(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.smembers(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long srem(String key, String... member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.srem(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String spop(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.spop(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long scard(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.scard(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Boolean sismember(String key, String member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.sismember(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String srandmember(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.srandmember(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public List<String> srandmember(String key, int count) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.srandmember(key, count);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zadd(String key, double score, String member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zadd(key, score, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<String> zrange(String key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrange(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zrem(String key, String member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrem(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Double zincrby(String key, double score, String member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zincrby(key, score, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zrank(String key, String member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrank(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zrevrank(String key, String member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrank(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<String> zrevrange(String key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrange(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<Tuple> zrangeWithScores(String key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrangeWithScores(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrangeWithScores(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zcard(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zcard(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Double zscore(String key, String member) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zscore(key, member);
        } finally {
            this.returnResource(jedis);
        }
    }

    public List<String> sort(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.sort(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public List<String> sort(String key, SortingParams sortingParameters) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.sort(key, sortingParameters);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zcount(String key, double min, double max) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zcount(key, min, max);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<String> zrangeByScore(String key, double min, double max) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrangeByScore(key, min, max);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<String> zrevrangeByScore(String key, double max, double min) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrangeByScore(key, max, min);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrangeByScore(key, min, max, offset, count);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrangeByScore(key, max, min, offset, count);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrangeByScoreWithScores(key, min, max);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrangeByScoreWithScores(key, max, min);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrangeByScoreWithScores(key, min, max, offset, count);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zremrangeByRank(String key, long start, long end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zremrangeByRank(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long zremrangeByScore(String key, double start, double end) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.zremrangeByScore(key, start, end);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long linsert(String key, LIST_POSITION where, String pivot, String value) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.linsert(key, where, pivot, value);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Set<String> keys(String pattern) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.keys(pattern);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long publish(String channel, String message) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.publish(channel, message);
        } finally {
            this.returnResource(jedis);
        }
    }

    public void subscribe(JedisPubSub jedisPubSub, String... channels) {
        Jedis jedis = resourcePool.getResource();
        if (jedis == null) {
            return;
        }
        try {
            jedis.subscribe(jedisPubSub, channels);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long move(String key, int dbIndex) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.move(key, dbIndex);
        } finally {
            this.returnResource(jedis);
        }
    }

    public Long persist(String key) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.persist(key);
        } finally {
            this.returnResource(jedis);
        }
    }

    public String set(String key, String value, String nxxx, String expx, long time) {
        Jedis jedis = resourcePool.getResource();
        try {
            return jedis.set(key, value, nxxx, expx, time);
        } finally {
            this.returnResource(jedis);
        }
    }
}
