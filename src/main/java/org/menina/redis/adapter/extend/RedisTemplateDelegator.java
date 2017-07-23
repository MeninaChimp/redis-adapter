package org.menina.redis.adapter.extend;


/**
 * author: Menina
 *
 * 对于实现对复杂对象操作的支持，想不出更好的办法来实现，在一开始RedisTemplate就不应该对序列化方式
 * 的操作权限，RedisTemplate应该只提供最基础的redis操作，复杂对象的操作应该交由上层调用基础方法再
 * 做序列化处理，所以从1.2.0开始把原本在RedisTemplate里的序列化方式提了出来，类名以Delegator结尾，
 * 是因为本质上这个类还是委托RedisTemplate实现的。
 */
public class RedisTemplateDelegator extends AbstractRedisTemplateDelegator {

}
