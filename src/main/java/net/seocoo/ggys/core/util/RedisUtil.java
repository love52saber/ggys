package net.seocoo.ggys.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author xieheng
 * @Data 2018/5/24
 * @Email xieheng91@163.com
 * @Desc redis工具类
 */
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @Description: 批量删除缓存
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * @Description: 批量删除缓存(通配符)
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * @Description: 删除缓存
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * @Description: 判断缓存中是否有对应的value
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * @Description: 读取缓存
     */
    public Object get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * @Description: 写入缓存
     * @A
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        redisTemplate.opsForValue().set(key, value);
        result = true;
        return result;
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public boolean expire(final String key, Long expireTime, TimeUnit timeUnit) {
        return redisTemplate.expire(key, expireTime, timeUnit);
    }

    /**
     * @Description: 写入缓存(可以配置过期时间)
     */
    public boolean set(final String key, Object value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, expireTime, timeUnit);
        result = true;
        return result;
    }


    /**
     * 根据主键key获取hash所有的值转化成bean
     *
     * @param type bean的类型
     * @param key  key
     * @return
     */
    public <T> T selectByPrimaryKey(Class<T> type, String key) {
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        String jsonStr = JSONObject.toJSONString(map);
        return JSON.parseObject(jsonStr, type);
    }

    /**
     * redis hash set 数据
     *
     * @param obj 保存的对象
     * @param key 保存的key前缀
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public <T> void setRedisHash(T obj, String key) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            if (!"class".equals(name) && !Modifier.isStatic(field.getModifiers())) {
                // 将属性的首字符大写，方便构造get，set方法
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                Method m;
                Object value = null;
                m = obj.getClass().getMethod("get" + name);
                value = m.invoke(obj);
                redisTemplate.opsForHash().put(key.toString(), field.getName(), coverToString(value));
            }
        }
    }

    /**
     * 将其他数据类型转换为string
     *
     * @param obj 数据字段
     * @return
     */
    public String coverToString(Object obj) {
        if (obj != null) {
            if (obj instanceof Date) {
                SimpleDateFormat formatter = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");
                return formatter.format(obj);
            } else {
                return String.valueOf(obj);
            }
        } else {
            return "";
        }
    }

    /**
     * list数据插入,当key存在时,在原list上增加,不会覆盖
     * @param key
     * @param list
     * @param <T>
     */
    public <T> void setRedisList(String key, List<T> list,Long expireTime, TimeUnit timeUnit) {
        redisTemplate.opsForList().leftPushAll(key, list);
        redisTemplate.expire(key, expireTime, timeUnit);
    }

    /**
     * list数据获取
     * @param key
     * @return
     */
    public  List getRedisList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * list数据插入,当key存在时,在原list上增加,不会覆盖
     * @param key
     * @param object
     * @param <T>
     */
    public <T> void setRedisList(String key,T object){
        redisTemplate.opsForList().leftPush(key,object);
    }

    /**
     * 增加zset，默认失效时间为1天
     * @param key
     * @param object
     * @param score
     * @param <T>
     * @param <R>
     */
    public <T,R> void addRedisZSet(String key, T object, double score) {
        redisTemplate.opsForZSet().add(key, object, score);
        redisTemplate.expire(key, 1L, TimeUnit.DAYS);
    }

    public <T,R> void addRedisZSet(String key, T object, double score, Long expireTime, TimeUnit timeUnit) {
        redisTemplate.opsForZSet().add(key, object, score);
        redisTemplate.expire(key, expireTime, timeUnit);
    }

    public <K,V> Set<V> getZSetRang(K key, long start, long end ) {
       return redisTemplate.opsForZSet().range(key, start, end);
    }

    public  Long getZSetSize(Object key) {
        return this.redisTemplate.opsForZSet().size(key);
    }
}
