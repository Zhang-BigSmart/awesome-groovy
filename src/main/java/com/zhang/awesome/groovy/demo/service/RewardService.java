package com.zhang.awesome.groovy.demo.service;

import cn.hutool.crypto.digest.MD5;
import com.zhang.awesome.groovy.demo.domain.User;
import com.zhang.awesome.groovy.demo.domain.ScriptRuleConfig;
import com.zhang.awesome.groovy.demo.repository.impl.ScriptRuleConfigRepository;
import groovy.lang.GroovyClassLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : edison
 */
@Slf4j
@Service
public class RewardService {

    private final static Map<String, Object> SCRIPT_CACHE = new ConcurrentHashMap<>();
    public static final String SCRIPT_RULE_REWARD_COUNT_RULE = "REWARD_COUNT";

    @Autowired
    private ScriptRuleConfigRepository scriptRuleConfigRepository;

    public int rewardCount(User user) {
        IRewardRule rewardRule = loadScriptInstance(SCRIPT_RULE_REWARD_COUNT_RULE, IRewardRule.class);
        if (rewardRule == null) {
            throw new RuntimeException();
        }
        return rewardRule.getRewardCount(user);
    }

    public <T> T loadScriptInstance(String key, Class<T> clazz) {
        // 数据库中查询脚本内容
        ScriptRuleConfig rule = scriptRuleConfigRepository.selectByName(key);
        if (Objects.isNull(rule)) {
            log.error("script config key:[{}] without match rule", key);
            return null;
        }
        T instance;
        String cacheKey = MD5.create().digestHex(rule.getRule());
        if (SCRIPT_CACHE.containsKey(cacheKey)) {
            instance = clazz.cast(SCRIPT_CACHE.get(cacheKey));
        } else {
            // 初始化
            instance = initialize(cacheKey, rule.getRule(), clazz);
        }
        return instance;
    }

    /**
     * 初始化Groovy脚本
     *
     * @param cacheKey
     * @param script
     * @param clazz
     * @param <T>
     * @return
     */
    public synchronized <T> T initialize(String cacheKey, String script, Class<T> clazz) {
        if (SCRIPT_CACHE.containsKey(cacheKey)) {
            return clazz.cast(SCRIPT_CACHE.get(cacheKey));
        }
        GroovyClassLoader classLoader = new GroovyClassLoader();
        try {
            Class<?> groovyClazz = classLoader.parseClass(script);
            if (clazz != null) {
                Object instance = groovyClazz.newInstance();
                classLoader.clearCache();
                SCRIPT_CACHE.put(cacheKey, instance);
                return clazz.cast(instance);
            }
        } catch (Exception e) {
            log.error("initialize exception", e);
        }
        return null;
    }

}
