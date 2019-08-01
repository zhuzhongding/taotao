package com.taotao.rest.jedis;

import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {

    @Test
    public void testJedisSingle() {
        //创建一个jedis的对象
        Jedis jedis = new Jedis("192.168.92.129",6379);
        //设置jedis的值
        jedis.set("key1","jedis test");
        String string = jedis.get("key1");
        System.out.println(string);
        //关闭jedis
        jedis.close();
    }

    /**
     * 使用连接池
     */
    @Test
    public void testJedisPool() {
        //创建Jedis连接池
        JedisPool  jedisPool = new JedisPool("192.168.92.129",6379);
        Jedis jedis = jedisPool.getResource();
        String string = jedis.get("key1");
        System.out.println(string);
        //关闭jedis对象
        jedis.close();
        jedisPool.close();
    }
    
    /**
     * 测试集群
     * 
     */
    @Test
    public void testJedisCluster() {
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.92.129", 7001));
        nodes.add(new HostAndPort("192.168.92.129", 7002));
        nodes.add(new HostAndPort("192.168.92.129", 7003));
        nodes.add(new HostAndPort("192.168.92.129", 7004));
        nodes.add(new HostAndPort("192.168.92.129", 7005));
        nodes.add(new HostAndPort("192.168.92.129", 7006));
        JedisCluster jedisCluster = new JedisCluster(nodes);
        jedisCluster.set("key1", "1000");
        String string = jedisCluster.get("key1");
        System.out.println(string);
        jedisCluster.close();
    }
    
    @Test
    public void testSpringSingle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");
        JedisPool pool = (JedisPool)applicationContext.getBean("redisClient");
        Jedis jedis = pool.getResource();
        String string = jedis.get("key1");
        System.out.println(string);
        jedis.close();
        pool.close();
    }
    
    @Test
    public void testSpringCluster() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");
        JedisCluster jedisCluster = (JedisCluster)applicationContext.getBean("redisClient");
        String string = jedisCluster.get("key1");
        System.out.println(string);
        jedisCluster.close();
    }
    
}
