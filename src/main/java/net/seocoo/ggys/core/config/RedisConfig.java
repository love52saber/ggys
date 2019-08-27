package net.seocoo.ggys.core.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.seocoo.ggys.core.util.StringEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author xieheng
 * @Data 2018/5/24
 * @Email xieheng91@163.com
 * @Desc  redis配置加载
 */
@Configuration
public class RedisConfig
{
    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);
    @Value("${spring.redis.database}")
    public  int database ;

    @Value("${spring.redis.enablecluster}")
    public  String enableCluster ;

    @Value("${spring.redis.host}")
    public  String host;

    @Value("${spring.redis.port}")
    public  int port;

    @Value("${spring.redis.password}")
    public  String password;

    @Value("${spring.redis.pool.max-active}")
    public  String max_active;

    @Value("${spring.redis.pool.max-wait}")
    public  String max_wait;

    @Value("${spring.redis.pool.max-idle}")
    public  String max_idle;

    @Value("${spring.redis.pool.min-idle}")
    public  String min_idle;

    @Value("${spring.redis.timeout}")
    public  String timeout;

    public  int MaxTotal = 64;

    private int parseIntFromString(String s, int def) {
        if ((s == null) || (s.isEmpty())) return def;
        return Integer.parseInt(s);
    }



    private JedisPoolConfig jedisPoolConfig()
    {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(Integer.valueOf(max_idle));
        jedisPoolConfig.setMaxTotal(Integer.valueOf(max_idle));
        jedisPoolConfig.setMaxWaitMillis(Integer.valueOf(max_wait));
        return jedisPoolConfig;
    }

    private RedisClusterConfiguration redisClusterConfiguration() {
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        String[] hosts = host.split(",");
        Set redisNodes = new HashSet();
        for (String h : hosts) {
            String[] info = h.split(":");
            RedisClusterNode node = new RedisClusterNode(info[0], info.length < 2 ? port : Integer.valueOf(info[1]).intValue());
            redisNodes.add(node);
        }
        redisClusterConfiguration.setClusterNodes(redisNodes);
        redisClusterConfiguration.setMaxRedirects(10);
        return redisClusterConfiguration;
    }
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {

        JedisConnectionFactory factory;
        if (Boolean.valueOf(enableCluster)) {
            factory = new JedisConnectionFactory(redisClusterConfiguration(), jedisPoolConfig());
        } else {
            factory = new JedisConnectionFactory(jedisPoolConfig());
            factory.setHostName(host);
            factory.setPort(port);
        }
        factory.setDatabase(database);

        if (!StringEx.stringIsNullOrEmpty(password))
            factory.setPassword(password);
        factory.setTimeout(Integer.valueOf(timeout));

        return factory;
    }
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate template = new RedisTemplate();
        RedisSerializer stringSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();

        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(stringSerializer);
        template.setHashKeySerializer(stringSerializer);
        template.setValueSerializer(jsonRedisSerializer);
        template.setHashValueSerializer(jsonRedisSerializer);

        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jsonRedisSerializer.setObjectMapper(om);

        return template;
    }
}