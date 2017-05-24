package org.menina.redis.adapter.utils;


/**
 * author: Menina
 */

public enum WriteOperation {

    SET("set"),
    EXPIRE("expire"),
    EXPIREAT("expireAt"),
    SETBIT("setbit"),
    SETRANGE("setrange"),
    GETSET("getSet"),
    SETNX("setnx"),
    SETEX("setex"),
    DECRBY("decrBy"),
    DECR("decr"),
    INCRBY("incrBy"),
    INCR("incr"),
    APPEND("append"),
    HSET("hset"),
    HSETNX("hsetnx"),
    HMSET("hmset"),
    HINCRBY("hincrBy"),
    DEL("del"),
    HDEL("hdel"),
    RPUSH("rpush"),
    LPUSH("lpush"),
    LSET("lset"),
    LPOP("lpop"),
    RPOP("rpop"),
    LREM("lrem"),
    SADD("sadd"),
    SREM("srem"),
    SPOP("spop"),
    ZADD("zadd"),
    ZREM("zrem"),
    ZINCRBY("zincrby"),
    ZREMRANGEBYRANK("zremrangeByRank"),
    ZREMRANGEBYSCORE("zremrangeByScore"),
    LINSERT("linsert"),
    PUBLISH("publish"),
    SUBSCRIBE("subscribe"),
    MOVE("move"),
    PERSIST("persist");

    private String value;

    private WriteOperation(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public static WriteOperation getWriteOperationByValue(String value){
        WriteOperation[] writeOperations = WriteOperation.values();
        for(WriteOperation writeOperation : writeOperations){
            if(value.equals(writeOperation.value)){
                return writeOperation;
            }
        }

        return null;
    }

    public static Boolean isWriteOperation(String value){
        return getWriteOperationByValue(value) != null;
    }

}
