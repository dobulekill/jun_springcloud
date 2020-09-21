package com.zscat.user;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Scheduled(fixedRate = 30000)
    public void consume() {
        System.out.println("qqq");
    }
}
