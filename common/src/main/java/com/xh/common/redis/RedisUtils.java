package com.xh.common.redis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.xh.common.base.BaseEntity;
import com.xh.common.exportions.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author xt
 * @date 2020/9/7
 */
@Component
public class RedisUtils {

    private static final Logger log = LoggerFactory.getLogger(RedisUtils.class);
    private final RedisTemplate<String, Object> redisTemplate;
    private final ValueOperations<String, Object> valueOperations;
    public static final long DEFAULT_EXPIRE = 86400L;
    public static final long NOT_EXPIRE = -1L;

    @Autowired
    public RedisUtils(RedisTemplate<String, Object> redisTemplate, ValueOperations<String, Object> valueOperations) {
        this.redisTemplate = redisTemplate;
        this.valueOperations = valueOperations;
    }

    public Object getValue(String key) {
        return this.valueOperations.get(key);
    }

    public void setValue(String key, Object value) {
        this.valueOperations.set(key, value);
    }

    public void set(String key, Object value, long expire) {
        this.valueOperations.set(key, this.toJson(value));
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }

    }

    public void expire(String key, long expire) {
        this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    public <T extends BaseEntity> void batchSet(String keyPrefix, List<T> datas) {
        this.valueOperations.multiSet((Map)datas.stream().collect(Collectors.toMap((d) -> {
            return keyPrefix + ":" + d.getId();
        }, this::toJson, (k1, k2) -> {
            return k1;
        })));
    }

    public void set(String key, Object value) {
        this.set(key, value, 86400L);
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        Object value = this.valueOperations.get(key);
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }

        return value == null ? null : this.fromJson(value, clazz);
    }

    public <T> T get(String key, Class<T> clazz) {
        return this.get(key, clazz, -1L);
    }

    // public <T> T get(String key, TypeReference valueTypeRef) {
    //     Object value = this.valueOperations.get(key);
    //     return value == null ? null : this.fromJson(value, valueTypeRef);
    // }

    public String get(String key, long expire) {
        Object value = this.valueOperations.get(key);
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }

        return value == null ? null : value.toString();
    }

    public String get(String key) {
        return this.get(key, -1L);
    }

    public void delete(String key) {
        this.redisTemplate.delete(key);
    }

    public Long incr(String key) {
        return this.redisTemplate.opsForValue().increment(key, 1L);
    }

    public Boolean getLock(String key, String value, long expire) {
        if (expire <= 0L) {
            expire = 5L;
        }

        Boolean absent = this.redisTemplate.opsForValue().setIfAbsent(key, value, expire, TimeUnit.SECONDS);
        return absent == null ? false : absent;
    }

    public Boolean getLock(String key) {
        Boolean absent = this.redisTemplate.opsForValue().setIfAbsent(key, "locked", 5L, TimeUnit.SECONDS);
        return absent == null ? false : absent;
    }

    // public Set<String> keys(String keyPrefix) {
    //     String realKey = keyPrefix + "*";
    //
    //     try {
    //         return (Set)this.redisTemplate.execute((connection) -> {
    //             Set<String> binaryKeys = new HashSet();
    //             Cursor cursor = connection.scan((new ScanOptions.ScanOptionsBuilder()).match(realKey).count(2147483647L).build());
    //
    //             while(cursor.hasNext()) {
    //                 binaryKeys.add(new String((byte[])cursor.next()));
    //             }
    //
    //             try {
    //                 cursor.close();
    //             } catch (IOException var5) {
    //                 log.error("cursor close exception:{}", var5.getMessage());
    //             }
    //             return binaryKeys;
    //         });
    //     } catch (Throwable var4) {
    //         log.error("redis批量获取异常:{}", var4.getMessage());
    //          throw new ApiException("");
    //     }
    // }

    // public <T> List<T> like(String keyPrefix, TypeReference valueTypeRef) {
    //     Set<String> keys = this.keys(keyPrefix);
    //     return Objects.nonNull(keys) && keys.size() > 0 ? (List)this.fromJson(Objects.requireNonNull(this.valueOperations.multiGet(keys)), valueTypeRef) : null;
    // }

    /** @deprecated */
    @Deprecated
    public Set<String> like(String keyPrefix) {
        return this.redisTemplate.keys(keyPrefix + "*");
    }

    // public void deleteLike(String keyPrefix) {
    //     try {
    //         Set<String> keys = this.keys(keyPrefix);
    //         this.redisTemplate.delete(keys);
    //     } catch (Throwable var3) {
    //         log.warn(var3.getMessage(), var3);
    //         throw new ApiException("");
    //     }
    //
    // }

    private String toJson(Object object) {
        try {
            if (!(object instanceof Integer) && !(object instanceof Long) && !(object instanceof Float) && !(object instanceof Double) && !(object instanceof Boolean) && !(object instanceof String)) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new Jdk8Module());
                JavaTimeModule module = new JavaTimeModule();
                module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                mapper.registerModule(module);
                mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                return mapper.writeValueAsString(object);
            } else {
                return String.valueOf(object);
            }
        } catch (JsonProcessingException var4) {
            log.error("RedisJson toJson 数据转换异常:{}", var4.getMessage());
            throw new ApiException("");
        }
    }

    private <T> T fromJson(Object json, Class<T> clazz) {
        try {
            return this.covertJavaTime().readValue(json.toString(), clazz);
        } catch (IOException var4) {
            log.error("RedisJson fromJson数据转换异常:", var4);
            throw new ApiException("");
        }
    }

    // private <T> T fromJson(Object json, TypeReference valueTypeRef) {
    //     //     try {
    //     //         return this.covertJavaTime().readValue(json.toString(), valueTypeRef);
    //     //     } catch (IOException var4) {
    //     //         log.error("RedisJson fromJson数据转换异常:", var4);
    //     //         throw new ApiException("");
    //     //     }
    //     // }

    private ObjectMapper covertJavaTime() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
