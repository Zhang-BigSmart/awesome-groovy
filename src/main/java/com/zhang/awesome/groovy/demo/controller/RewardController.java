package com.zhang.awesome.groovy.demo.controller;

import com.zhang.awesome.groovy.demo.domain.User;
import com.zhang.awesome.groovy.demo.service.RewardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : edison
 */
@RestController
public class RewardController {

    @Resource
    private RewardService service;

    @PostMapping("/reward/count")
    public Integer rewardCount(@RequestBody User user) {
        return service.rewardCount(user);
    }
}
