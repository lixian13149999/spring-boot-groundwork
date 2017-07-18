//package com.bcdbook.common.demo.redis;
//
///**
// * Created by lason on 2017/7/18.
// */
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//
//@Configuration
//@EnableCaching // 启用缓存特性
//public class RedisConfig extends CachingConfigurerSupport {
//    // 缓存数据时Key的生成器，可以依据业务和技术场景自行定制
////  @Bean
////  public KeyGenerator customizedKeyGenerator() {
////      return new KeyGenerator() {
////          @Override
////          public Object generate(Object target, Method method, Object... params) {
////              StringBuilder sb = new StringBuilder();
////              sb.append(target.getClass().getName());
////              sb.append(method.getName());
////              for (Object obj : params) {
////                  sb.append(obj.toString());
////              }
////              return sb.toString();
////          }
////      };
////
////  }
//    // 定制缓存管理器的属性，默认提供的CacheManager对象可能不能满足需要
//    // 因此建议依赖业务和技术上的需求，自行做一些扩展和定制
//    @Bean
//    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
//        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
//        redisCacheManager.setDefaultExpiration(300);
//        return redisCacheManager;
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }
//}