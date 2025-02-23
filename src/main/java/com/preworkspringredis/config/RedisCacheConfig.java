package com.preworkspringredis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
public class RedisCacheConfig {

    @Value("${cache.config.entryTtl}")
    private int TTL;

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(TTL))
                .disableCachingNullValues()
                .serializeValuesWith( RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }
// CUSTOM TTL
//    @Bean
//    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
//        return builder -> {
//            var countryNamesConf = RedisCacheConfiguration.defaultCacheConfig()
//                    .entryTtl(Duration.ofMinutes(countryNamesEntryTtl));
//
//            builder.withCacheConfiguration(CacheNames.COUNTRY_NAMES, countryNamesConf);
//        };
//    }
}
