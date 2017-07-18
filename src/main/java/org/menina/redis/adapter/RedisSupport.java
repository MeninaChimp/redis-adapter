package org.menina.redis.adapter;

import org.menina.redis.adapter.extend.ExtendOperationSupport;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * author: Menina
 */

public interface RedisSupport {
    
    /**
     * 获取一个值
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 存一个键值对
     *
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 指定键在unix时间超时过期
     *
     * @param key
     * @param unixTimeSeconds
     */
    void expireAt(String key, long unixTimeSeconds);

    /**
     * 指定键在传入秒数后超时过期
     *
     * @param key
     * @param seconds
     */
    void expire(String key, int seconds);

    /**
     * 键剩余存活毫秒数
     *
     * @param key
     * @return
     */
    Long ttl(String key);

    /**
     * 删除一个键值对
     *
     * @param key
     * @return
     */
    Long del(String key);

    /**
     * 获取指定键，域下的值
     *
     * @param key
     * @param field
     * @return
     */
    String hget(String key, String field);

    /**
     * 保存一个键-域-值对
     *
     * @param key
     * @param field
     * @param value
     */
    void hset(String key, String field, String value);

    /**
     * 保存一个键-域值Map对
     *
     * @param key
     * @param hash
     */
    void hmset(String key, Map<String, String> hash);

    /**
     * 获取键下多个域的值
     *
     * @param key
     * @param fields
     * @return
     */
    List<String> hmget(String key, String... fields);

    /**
     * 键值对是否存在
     *
     * @param key
     * @return
     */
    Boolean exists(String key);

    /**
     * 键下域值对是否存在
     *
     * @param key
     * @param field
     * @return
     */
    Boolean hexists(String key, String field);

    /**
     * 删除键下指定域的值
     *
     * @param key
     * @param field
     */
    void hdel(String key, String field);

    /**
     * 键不存在时保存
     *
     * @param key
     * @param value
     * @return 1 保存成功
     * 0 键已存在，保存失败
     */
    Long setnx(String key, String value);

    /**
     * 附带超时功能的保存键值对
     *
     * @param key
     * @param seconds
     * @param value
     */
    void setex(String key, int seconds, String value);

    /**
     * 键的值自减操作, 键的值需能被转换为数字, 减数为1
     *
     * @param key
     * @return
     */
    Long decr(String key);

    /**
     * 键的值自减操作，键的值需能被转换为数字, 减数为number
     *
     * @param key
     * @param number
     * @return
     */
    Long decrBy(String key, long number);

    /**
     * 键的值自增操作，键的值需能被转换为数字, 增数为1
     *
     * @param key
     * @return
     */
    Long incr(String key);

    /**
     * 键的值自增操作，键的值需能被转换为数字, 增数为number
     *
     * @param key
     * @param number
     * @return
     */
    Long incrBy(String key, long number);

    /**
     * 键的值后追加内容
     *
     * @param key
     * @param value
     * @return
     */
    Long append(String key, String value);

    /**
     * 截取键的值返回, 可使用getrange方法替换
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    String substr(String key, int start, int end);

    /**
     * 获取一个键值对
     *
     * @param key
     * @return
     */
    byte[] get(byte[] key);

    /**
     * 保存一个键值对
     *
     * @param key
     * @param value
     */
    void set(byte[] key, byte[] value);

    /**
     * 键在指定unix时间处超时过去
     *
     * @param key
     * @param unixTime
     */
    void expireAt(byte[] key, long unixTime);

    /**
     * 指定键在传入秒数后超时过去
     *
     * @param key
     * @param seconds
     */
    void expire(byte[] key, int seconds);

    /**
     * 键值对剩余存活秒数
     *
     * @param key
     * @return
     */
    Long ttl(byte[] key);

    /**
     * 删除键值对
     *
     * @param key
     * @return
     */
    Long del(byte[] key);

    /**
     * 获取键的指定域下值
     *
     * @param key
     * @param field
     * @return
     */
    byte[] hget(byte[] key, byte[] field);

    /**
     * 键下新增域值对
     *
     * @param key
     * @param field
     * @param value
     */
    void hset(byte[] key, byte[] field, byte[] value);

    /**
     * 键下新增多个域值对
     *
     * @param key
     * @param hash
     */
    void hmset(byte[] key, Map<byte[], byte[]> hash);

    /**
     * 获取指定键下多个域的值
     *
     * @param key
     * @param fields
     * @return
     */
    List<byte[]> hmget(byte[] key, byte[]... fields);

    /**
     * 键值对是否存在
     *
     * @param key
     * @return
     */
    Boolean exists(byte[] key);

    /**
     * 指定键下域值对是否存在
     *
     * @param key
     * @param field
     * @return
     */
    Boolean hexists(byte[] key, byte[] field);

    /**
     * 删除键下指定域值对
     *
     * @param key
     * @param field
     */
    void hdel(byte[] key, byte[] field);

    /**
     * 键不存在时保存
     *
     * @param key
     * @param value
     * @return 1 保存成功
     * 0 键已存在 保存失败
     */
    Long setnx(byte[] key, byte[] value);

    /**
     * 附带超时功能的保存键值对
     *
     * @param key
     * @param seconds
     * @param value
     */
    void setex(byte[] key, int seconds, byte[] value);

    /**
     * 键的值自减操作，键的值需能转换为数字，减数为1
     *
     * @param key
     * @return
     */
    Long decr(byte[] key);

    /**
     * 键的值自减操作，键的值需能转换为数字，减数为number
     *
     * @param key
     * @param number
     * @return
     */
    Long decrBy(byte[] key, long number);

    /**
     * 键的值自增操作，键的值需能转换为数字，增数为1
     *
     * @param key
     * @return
     */
    Long incr(byte[] key);

    /**
     * 键的值自增操作，键的值需能转换为数字，增数为number
     *
     * @param key
     * @param number
     * @return
     */
    Long incrBy(byte[] key, long number);

    /**
     * 键的值的类型
     *
     * @param key
     * @return
     */
    String type(byte[] key);

    /**
     * 键的值的类型
     *
     * @param key
     * @return
     */
    String type(String key);

    /**
     * 键下指定域不存在时，保存值
     *
     * @param key
     * @param field
     * @param value
     * @return 1 保存成功
     * 0 域已存在，保存失败
     */
    Long hsetnx(String key, String field, String value);

    /**
     * 键下指定域不存在时，保存值
     *
     * @param key
     * @param field
     * @param value
     * @return 1 保存成功
     * 0 域已存在，保存失败
     */
    Long hsetnx(byte[] key, byte[] field, byte[] value);

    /**
     * 键下域的个数
     *
     * @param key
     * @return
     */
    Long hlen(String key);

    /**
     * 键下域的个数
     *
     * @param key
     * @return
     */
    Long hlen(byte[] key);

    /**
     * 匹配所有符合表达式的键
     * db中key数量过多时慎用
     *
     * @param pattern
     * @return
     * @throws UnsupportedOperationException
     */
    Set<String> keys(String pattern) throws UnsupportedOperationException;

    /**
     * 匹配所有符合表达式的键
     * db中key数量过多时慎用
     *
     * @param pattern
     * @return
     * @throws UnsupportedOperationException
     */
    Set<byte[]> keys(byte[] pattern) throws UnsupportedOperationException;

    /**
     * 获取键下所有域
     *
     * @param key
     * @return
     */
    Set<String> hkeys(String key);

    /**
     * 获取键下所有域
     *
     * @param key
     * @return
     */
    Set<byte[]> hkeys(byte[] key);

    /**
     * 获取键下所有域的值
     *
     * @param key
     * @return
     */
    List<String> hvals(String key);

    /**
     * 获取键下所有域的值
     *
     * @param key
     * @return
     */
    List<byte[]> hvals(byte[] key);

    /**
     * 键下域的自增操作，增数number
     *
     * @param key
     * @param field
     * @param number
     * @return
     */
    Long hincrBy(String key, String field, long number);

    /**
     * 键下域的自增操作，增数number
     *
     * @param key
     * @param field
     * @param number
     * @return
     */
    Long hincrBy(byte[] key, byte[] field, long number);

    /**
     * 替换键下指定索引开始的值
     *
     * @param key
     * @param offset
     * @param value
     * @return
     */
    Long setrange(String key, long offset, String value);

    /**
     * 截取键的值返回
     *
     * @param key
     * @param startOffset
     * @param endOffset
     * @return
     */
    String getrange(String key, long startOffset, long endOffset);

    /**
     * 键的值为链表，从右加入值.
     *
     * @param key
     * @param value
     * @return
     */
    Long rpush(String key, String value);

    /**
     * 键的值为链表，从右加入值.
     *
     * @param key
     * @param value
     * @return
     */
    Long rpush(byte[] key, byte[] value);

    /**
     * 键的值为链表，从左加入值.
     *
     * @param key
     * @param value
     * @return
     */
    Long lpush(String key, String value);

    /**
     * 键的值为链表，从左加入值.
     *
     * @param key
     * @param value
     * @return
     */
    Long lpush(byte[] key, byte[] value);

    /**
     * 键的值为链表，删除并返回左起第一个元素
     *
     * @param key
     * @return
     */
    String lpop(String key);

    /**
     * 键的值为链表，删除并返回左起第一个元素
     *
     * @param key
     * @return
     */
    byte[] lpop(byte[] key);

    /**
     * 键的值为链表，删除并返回右起第一个元素
     *
     * @param key
     * @return
     */
    String rpop(String key);

    /**
     * 键的值为链表，删除并返回右起第一个元素
     *
     * @param key
     * @return
     */
    byte[] rpop(byte[] key);

    /**
     * 键的值为链表，值的长度
     *
     * @param key
     * @return
     */
    Long llen(String key);

    /**
     * 键的值为链表，值的长度
     *
     * @param key
     * @return
     */
    Long llen(byte[] key);

    /**
     * 获取键下指定索引范围内的所有元素
     * 最后一个元素用-1描述
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    List<String> lrange(String key, long start, long end);

    /**
     * 获取键下指定索引范围内的所有元素
     * 最后一个元素用-1描述
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    List<byte[]> lrange(byte[] key, long start, long end);

    /**
     * 键的值为集合，添加值
     *
     * @param setName
     * @param member
     * @return
     */
    Long sadd(String setName, String member);

    /**
     * 键的值为集合，添加值
     *
     * @param setName
     * @param member
     * @return
     */
    Long sadd(byte[] setName, byte[] member);

    /**
     * 键的值为集合，获取集合中的所有元素
     *
     * @param setName
     * @return
     */
    Set<String> smembers(String setName);

    /**
     * 键的值为集合，获取集合中的所有元素
     *
     * @param setName
     * @return
     */
    Set<byte[]> smembers(byte[] setName);

    /**
     * 键的值为集合，删除集合中的某个值
     *
     * @param setName
     * @param member
     * @return
     */
    Long srem(String setName, String member);

    /**
     * 键的值为集合，批量删除集合中的值
     * @param setName
     * @param members
     * @return
     */
    Long srem(String setName, List<String> members);

    /**
     * 键的值为集合，删除集合中的某个值
     *
     * @param setName
     * @param member
     * @return
     */
    Long srem(byte[] setName, byte[] member);

    /**
     * 键的值为集合，批量删除集合中的值
     *
     * @param setName
     * @param members
     * @return
     */
    Long srem(byte[] setName, byte[]... members);

    /**
     * 键的值为集合，随机删除并返回一个元素
     *
     * @param key
     * @return
     */
    String spop(String key);

    /**
     * 键的值为集合，随机删除并返回一个元素
     *
     * @param key
     * @return
     */
    byte[] spop(byte[] key);

    /**
     * 键的值为集合，获取集合中元素的数量
     *
     * @param key
     * @return
     */
    Long scard(String key);

    /**
     * 键的值为集合，获取集合中元素的数量
     *
     * @param key
     * @return
     */
    Long scard(byte[] key);

    /**
     * 键的值为集合，判断member是否是键的值的成员
     *
     * @param key
     * @param member
     * @return
     */
    Boolean sismember(String key, String member);

    /**
     * 键的值为集合，判断member是否是键的值的成员
     *
     * @param key
     * @param member
     * @return
     */
    Boolean sismember(byte[] key, byte[] member);

    /**
     * 键的值为集合，随机返回集合中的一个元素
     *
     * @param key
     * @return
     */
    String srandmember(String key);

    /**
     * 键的值为集合，随机从集合中返回指定个数的元素
     *
     * @param key
     * @return
     */
    List<String> srandmember(String key, int count);

    /**
     * 键的值为集合，随机返回集合中的一个元素
     *
     * @param key
     * @return
     */
    byte[] srandmember(byte[] key);

    /**
     * 键的值为集合，随机从集合中返回指定个数的元素
     *
     * @param key
     * @return
     */
    List<byte[]> srandmember(byte[] key, int count);

    /**
     * 分阶段获取所有键，弥补keys命令在键数量过大时造成的阻塞
     * 每一阶段获取的key以cursor游标作为标记
     * cursor放回0表示键已被遍历完
     *
     * @param cursor
     * @return
     * @throws UnsupportedOperationException
     */
    ScanResult<String> scan(String cursor) throws UnsupportedOperationException;

    /**
     * 获取原来的值并保存新的值
     *
     * @param key
     * @param value
     * @return
     */
    String getSet(String key, String value);

    /**
     * 键的值为链表，对链表进行裁剪，只保留指定区间内的元素
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    String ltrim(String key, long start, long end);

    /**
     * 键的值为链表，对链表进行裁剪，只保留指定区间内的元素
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    String ltrim(byte[] key, long start, long end);

    /**
     * 键的值为链表，根据索引获取元素
     *
     * @param key
     * @param index
     * @return
     */
    String lindex(String key, long index);

    /**
     * 键的值为链表，根据索引获取元素
     *
     * @param key
     * @param index
     * @return
     */
    byte[] lindex(byte[] key, long index);

    /**
     * 键的值为链表，替换指定索引上的值
     *
     * @param key
     * @param index
     * @param value
     * @return
     */
    String lset(String key, long index, String value);

    /**
     * 键的值为链表，替换指定索引上的值
     *
     * @param key
     * @param index
     * @param value
     * @return
     */
    String lset(byte[] key, long index, byte[] value);


    /**
     * 键的值为链表，移除链表中的元素
     * count > 0 : 从表头开始向表尾搜索，移除与 VALUE 相等的元素，数量为 COUNT 。
     * count < 0 : 从表尾开始向表头搜索，移除与 VALUE 相等的元素，数量为 COUNT 的绝对值。
     * count = 0 : 移除表中所有与 VALUE 相等的值。
     *
     * @param key
     * @param count
     * @param value
     * @return
     */
    Long lrem(String key, long count, String value);

    /**
     * 键的值为链表，移除链表中的元素
     * count > 0 : 从表头开始向表尾搜索，移除与 VALUE 相等的元素，数量为 COUNT 。
     * count < 0 : 从表尾开始向表头搜索，移除与 VALUE 相等的元素，数量为 COUNT 的绝对值。
     * count = 0 : 移除表中所有与 VALUE 相等的值。
     *
     * @param key
     * @param count
     * @param value
     * @return
     */
    Long lrem(byte[] key, long count, byte[] value);

    /**
     * 键的值为有序集合
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    Long zadd(String key, double score, String member);

    /**
     * 键的值为有序集合
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    Long zadd(byte[] key, double score, byte[] member);

    /**
     * 键的值为有序集合，获取给定区间内的元素，以元素分数从小到大排序
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<String> zrange(String key, long start, long end);

    /**
     * 键的值为有序集合，获取给定区间内的元素，以元素分数从小到大排序
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<byte[]> zrange(byte[] key, long start, long end);

    /**
     * 键的值为有序集合，移除集合中的某个元素
     *
     * @param key
     * @param member
     * @return
     */
    Long zrem(String key, String member);

    /**
     * 键的值为有序集合，移除集合中的某个元素
     *
     * @param key
     * @param member
     * @return
     */
    Long zrem(byte[] key, byte[] member);

    /**
     * 键的值为有序集合，对集合中某个元素做加法操作，增数为scope
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    Double zincrby(String key, double score, String member);

    /**
     * 键的值为有序集合，对集合中某个元素做加法操作，增数为scope
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    Double zincrby(byte[] key, double score, byte[] member);

    /**
     * 键的值为有序集合，获取某个元素在集合中的排名
     *
     * @param key
     * @param member
     * @return
     */
    Long zrank(String key, String member);

    /**
     * 键的值为有序集合，获取某个元素在集合中的排名
     *
     * @param key
     * @param member
     * @return
     */
    Long zrank(byte[] key, byte[] member);

    /**
     * 键的值为有序集合，获取某个元素在集合中的排名
     *
     * @param key
     * @param member
     * @return
     */
    Long zrevrank(String key, String member);

    /**
     * 键的值为有序集合，获取某个元素在集合中的排名
     *
     * @param key
     * @param member
     * @return
     */
    Long zrevrank(byte[] key, byte[] member);

    /**
     * 键的值为有序集合，获取给定区间内的元素，以元素分数从大到小排序
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<String> zrevrange(String key, long start, long end);

    /**
     * 键的值为有序集合，获取给定区间内的元素，以元素分数从大到小排序
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<byte[]> zrevrange(byte[] key, long start, long end);

    /**
     * 键的值为有序集合，获取给定区间内的元素及其分数，以元素分数从小到大排序
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<Tuple> zrangeWithScores(String key, long start, long end);

    /**
     * 键的值为有序集合，获取给定区间内的元素及其分数，以元素分数从小到大排序
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<Tuple> zrangeWithScores(byte[] key, long start, long end);

    /**
     * 键的值为有序集合，获取给定区间内的元素及其分数，以元素分数从大到小排序
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<Tuple> zrevrangeWithScores(String key, long start, long end);

    /**
     * 键的值为有序集合，获取给定区间内的元素及其分数，以元素分数从大到小排序
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<Tuple> zrevrangeWithScores(byte[] key, long start, long end);

    /**
     * 键的值为有序集合，获取集合元素的数量
     *
     * @param key
     * @return
     */
    Long zcard(String key);

    /**
     * 键的值为有序集合，获取集合元素的数量
     *
     * @param key
     * @return
     */
    Long zcard(byte[] key);

    /**
     * 键的值为有序集合，获取成员的分数值
     *
     * @param key
     * @param member
     * @return
     */
    Double zscore(String key, String member);

    /**
     * 键的值为有序集合，获取成员的分数值
     *
     * @param key
     * @param member
     * @return
     */
    Double zscore(byte[] key, byte[] member);

    /**
     * 键的值为有序集合，返回给定分数范围内的元素数量
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    Long zcount(String key, double min, double max);

    /**
     * 键的值为有序集合，返回给定分数范围内的元素数量
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    Long zcount(byte[] key, double min, double max);

    /**
     * 键的值为有序集合，移除集合内给定排名范围内的元素
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    Long zremrangeByRank(String key, long min, long max);

    /**
     * 键的值为有序集合，移除集合内给定排名范围内的元素
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    Long zremrangeByRank(byte[] key, long min, long max);

    /**
     * 键的值为有序集合，移除集合内给定分数范围内的元素
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    Long zremrangeByScore(String key, long min, long max);

    /**
     * 键的值为有序集合，移除集合内给定分数范围内的元素
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    Long zremrangeByScore(byte[] key, long min, long max);

    /**
     * 键的值能被转换为数字，从小到大排序
     *
     * @param key
     * @return
     * @throws UnsupportedOperationException
     */
    List<String> sort(String key) throws UnsupportedOperationException;

    /**
     * 键的值能被转换为数字，从小到大排序
     *
     * @param key
     * @return
     * @throws UnsupportedOperationException
     */
    List<byte[]> sort(byte[] key) throws UnsupportedOperationException;

    /**
     * 发布
     *
     * @param channel
     * @param message
     * @return
     * @throws UnsupportedOperationException
     */
    Long publish(String channel, String message) throws UnsupportedOperationException;

    /**
     * 订阅
     *
     * @param jedisPubSub
     * @param channels
     * @throws UnsupportedOperationException
     */
    void subscribe(JedisPubSub jedisPubSub, String... channels) throws UnsupportedOperationException;

    /**
     * 移库
     *
     * @param key
     * @param dbIndex
     * @return
     * @throws UnsupportedOperationException
     */
    Long move(String key, int dbIndex) throws UnsupportedOperationException;

    /**
     * 持久化，移除键值对的过期时间
     *
     * @param key
     * @return
     */
    Long persist(String key);

    /**
     * 存放一个Set集合到Key中
     *
     * @param key
     * @param members
     * @return
     */
    Long sadd(String key, Set<String> members);

    /**
     * 存放一个Set集合到Key中
     *
     * @param key
     * @param members
     * @return
     */
    Long sadd(byte[] key, Set<byte[]> members);

    /**
     * 存放一个List集合到Key中
     *
     * @param key
     * @param members
     * @return
     */
    Long sadd(String key, List<String> members);

    /**
     * 存放一个List集合到Key中
     *
     * @param key
     * @param members
     * @return
     */
    Long sadd(byte[] key, List<byte[]> members);

    /**
     * 传入一个Field列表,获取对应在Map中的Value
     *
     * @param key
     * @param fields
     * @return
     */
    List<String> hmget(String key, List<String> fields);

    /**
     * 传入一个Key集合,将List中元素对应的value删除
     *
     * @param keys
     * @return
     */
    Long del(List<String> keys);

    /**
     * 传入一个Key集合,将List中元素对应的value删除
     *
     * @param keys
     * @return
     */
    Long del(Set<String> keys);

    /**
     * 传入一个匹配可以的正则表达式,删除匹配到的Keys
     *
     * @param pattern
     * @return
     */
    Long delByPattern(String pattern) throws UnsupportedOperationException;

    /**
     * 如果方法参数exist为true，则此键值仅在键已存在于redis的情况下保存成功。
     * 如果方法参数exist为false，则此键值仅在键不存在于redis的情况下保存成功。
     *
     * @param key      键
     * @param value    值
     * @param liveTime 键生存时间
     * @param timeUnit 生存时间单位
     * @param exist    键是否已存在
     * @return 保存成功： 1
     * 保存失败： 0
     */
    Long setOnExpire(String key, String value, int liveTime, TimeUnit timeUnit, boolean exist);

    /**
     * 如果方法参数exist为true，则此键值仅在键已存在于redis的情况下保存成功。
     * 如果方法参数exist为false，则此键值仅在键不存在于redis的情况下保存成功。
     *
     * @param key      键
     * @param value    值
     * @param liveTime 键生存时间
     * @param timeUnit 生存时间单位
     * @param exist    键是否已存在
     * @return 保存成功： 1
     * 保存失败： 0
     */
    Long setOnExpire(byte[] key, byte[] value, int liveTime, TimeUnit timeUnit, boolean exist);

    /**
     * 计算提供的集合的差集，方法第一个参数是要被差集操作的集合。
     * key1 = [x, a, b, c]
     * key2 = [c]
     * key3 = [a, d]
     * SDIFF key1,key2,key3 =&gt; [x, b]
     *
     * @param keys
     * @return
     */
    Set<String> sdiff(String... keys);

    /**
     * 计算提供的集合的差集，方法第一个参数是要被差集操作的集合。
     * key1 = [x, a, b, c]
     * key2 = [c]
     * key3 = [a, d]
     * SDIFF key1,key2,key3 =&gt; [x, b]
     *
     * @param keys
     * @return
     */
    Set<byte[]> sdiff(byte[]... keys);

    /**
     * 复杂对象存取扩展接口
     * @return
     */
    ExtendOperationSupport extend();

}
