package com.zhang.awesome.groovy.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : zzh
 * create at:  2023/11/29
 */
@RestController
public class RewardController {

    @Resource
    private RewardService service;

    @PostMapping("/reward/count")
    public Integer rewardCount(User user) {
        return service.rewardCount(user);
    }
}
