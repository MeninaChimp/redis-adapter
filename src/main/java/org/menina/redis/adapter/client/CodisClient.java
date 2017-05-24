package org.menina.redis.adapter.client;

import org.menina.redis.adapter.AbstractRedisSupport;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.ScanResult;

import java.util.List;
import java.util.Set;

/**
 * author: Menina
 */

@Component("codisClient")
public class CodisClient extends AbstractRedisSupport {

    @Override
    public Set<String> keys(String pattern) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Codis not support the method of 'keys'");
    }

    @Override
    public Set<byte[]> keys(byte[] pattern) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Codis not support the method of 'keys'");
    }

    @Override
    public ScanResult<String> scan(String cursor) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Codis not support the method of 'scan'");
    }

    @Override
    public List<String> sort(String key) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Codis not support the method of 'sort'");
    }

    @Override
    public List<byte[]> sort(byte[] key) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Codis not support the method of 'sort'");
    }

    @Override
    public Long publish(String channel, String message) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Codis not support the method of 'publish'");
    }

    @Override
    public void subscribe(JedisPubSub jedisPubSub, String... channels) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Codis not support the method of 'subscribe'");
    }

    @Override
    public Long move(String key, int dbIndex) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Codis not support the method of 'move'");
    }
}
