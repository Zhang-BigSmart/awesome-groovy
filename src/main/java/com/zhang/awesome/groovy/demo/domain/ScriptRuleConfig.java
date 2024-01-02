package com.zhang.awesome.groovy.demo.domain;

import java.io.Serializable;

/**
 * 规则配置表
 * @TableName script_rule_config
 */
public class ScriptRuleConfig implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 规则名称
     */
    private String name;

    /**
     * 规则脚本
     */
    private String rule;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 规则名称
     */
    public String getName() {
        return name;
    }

    /**
     * 规则名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 规则脚本
     */
    public String getRule() {
        return rule;
    }

    /**
     * 规则脚本
     */
    public void setRule(String rule) {
        this.rule = rule;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ScriptRuleConfig other = (ScriptRuleConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getRule() == null ? other.getRule() == null : this.getRule().equals(other.getRule()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getRule() == null) ? 0 : getRule().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", rule=").append(rule);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}