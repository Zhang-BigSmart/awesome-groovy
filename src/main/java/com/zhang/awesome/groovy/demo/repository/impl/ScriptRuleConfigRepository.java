package com.zhang.awesome.groovy.demo.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.awesome.groovy.demo.domain.ScriptRuleConfig;
import com.zhang.awesome.groovy.demo.mapper.ScriptRuleConfigMapper;
import com.zhang.awesome.groovy.demo.repository.IScriptRuleConfigRepository;
import org.springframework.stereotype.Service;

/**
* @author edison
* @description 针对表【script_rule_config(规则配置表)】的数据库操作Service实现
*/
@Service
public class ScriptRuleConfigRepository extends ServiceImpl<ScriptRuleConfigMapper, ScriptRuleConfig> implements IScriptRuleConfigRepository {

    /**
     * 根据name查询脚本规则
     *
     * @param name
     * @return
     */
    public ScriptRuleConfig selectByName(String name) {
        LambdaQueryWrapper<ScriptRuleConfig> wrapper = Wrappers.<ScriptRuleConfig>lambdaQuery()
                .eq(ScriptRuleConfig::getName, name);
        return this.getOne(wrapper);
    }

}
