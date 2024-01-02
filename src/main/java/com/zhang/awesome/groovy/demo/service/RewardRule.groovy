package com.zhang.awesome.groovy.demo.service

import com.zhang.awesome.groovy.demo.domain.User

/**
 * 编写完后需要将文件内容存储到数据库表
 */
class RewardRule implements IRewardRule {

    @Override
    Integer getRewardCount(User user) {
        if (user.getAge() <= 10) {
            return 5
        }else if (user.getAge() <= 20 && user.getAge() > 10) {
            return 3
        }else {
            return 1
        }
    }
}
