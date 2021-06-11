package com.example.demointerceptor.service;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AccessCheckService {

    public boolean isAllow(String orgId) {
        log.info(" == check access == org_id: {}", orgId);

        return orgId.equals("1");
    }
    
}
