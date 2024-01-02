## Awesome-Groovy

Java项目整合Groovy，实现代码热加载

目录 `demo` 下是基于一个营销场景的例子，基于用户不同的年龄阶段，获取不同的抽奖次数

MySQL数据库表：
```sql
CREATE TABLE `t_script_rule_config` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '规则名称',
  `rule` text NOT NULL COMMENT '规则脚本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='规则配置表'
;
```