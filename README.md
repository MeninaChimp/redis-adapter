# redis-adapter

 [![redis-adapter Release](https://img.shields.io/github/release/MeninaChimp/redis-adapter.svg)](https://github.com/MeninaChimp/redis-adapter/releases)
 [![license](https://img.shields.io/github/license/mashape/apistatus.svg?maxAge=2592000)](https://github.com/MeninaChimp/redis-adapter/blob/master/LICENSE)

  A redis client for redis，redis read/write split，codis，auto configuration，user-defined by using redis.properties under resources directory。 

Features
--------
- autoconfiguration
- read/write split
- codis
- loadbalance for codis-proxy

How To Use
------

- Add redis.properties

  you need create properties file named redis.properties under resources.

  if you uesd for redis:

``` properties
    
    host: 127.0.0.1
    port: 6379
    pass:
    timeout: 2000
    maxIdle: 50
    minIdle: 2
    maxTotal: 50
    maxWaitMillis: 2000
    timeBetweenEvictionRunsMillis: 30000
    minEvictableIdleTimeMillis: 30000
    testOnBorrow: true
    testOnCreate: false
    encode: utf-8
    unlock: false
    db: 0
    clientName: redis-support
```

if you ued for redis read/write split:

``` properties
    
    enable.readwrite.config: true
    read.host: 127.0.0.1
    read.port: 6379
    read.pass:
    read.timeout: 2000
    read.maxIdle: 50
    read.minIdle: 2
    read.maxActive: 50
    read.maxWaitMillis: 2000
    read.timeBetweenEvictionRunsMillis: 30000
    read.minEvictableIdleTimeMillis: 30000
    read.testOnBorrow: true
    read.testOnCreate: false
    read.encode: utf-8
    read.unlock: false
    read.db: 0
    
    write.host: 127.0.0.1
    write.port: 6380
    write.pass:
    write.timeout: 2000
    write.maxIdle: 50
    write.minIdle: 2
    write.maxActive: 50
    write.maxWaitMillis: 2000
    write.timeBetweenEvictionRunsMillis: 30000
    write.minEvictableIdleTimeMillis: 30000
    write.testOnBorrow: true
    write.testOnCreate: false
    write.encode: utf-8
    write.unlock: false
    write.db: 0
```

if you uesd for codis:

``` properties    
    enable.codis.config: true
    pass:
    timeout: 2000
    maxIdle: 50
    minIdle: 2
    maxTotal: 50
    maxWaitMillis: 2000
    timeBetweenEvictionRunsMillis: 120000
    minEvictableIdleTimeMillis: 120000
    testOnBorrow: false
    testOnCreate: false
    encode: utf-8
    unlock: false
    db: 0
    zookeeperAddress:127.0.0.1:4379
    zookeeperSessionTimeout: 60000
    zookeeperConnectTimeout: 10000
    nodePath:/codis3/${produce_name}/proxy  
```
- compnent scan the package.
```
  @ComponentScan(com.xxx, org.menina)
```  

- Used In Your Code

 if you used this for redis/redis read/write split:
    
```
@Autowired
private RedisSupport RedisClient;
```
 
  if you used this for codis:
    
```
@Autowired
private RedisSupport CodisClient;
```  

extend
------

for complex operation, like set a Business Object, you can implement by following the way below:

```
redisClient.extend().set(key, BO);
```  

user-defined
----

so far, the default serializer is JacksonSerializer, the default strategy for load balancing is RoundRobinBalance, but you can change them.

if you want to use JDK Serializer, you can follow the way below:

```
@Bean
	public Serializer jdkSerializer(){
		return new JdkSerializer();
	}
```

if you do not want to use RoundRobinBalance, there is another implement for LB:

```
	@Bean
	public Balance IpHashBalance(){
		return new IpHashBalance();
	}
```

more implements for LB will provide soon.
