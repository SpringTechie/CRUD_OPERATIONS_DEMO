package com.springtechie.schedular;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@Profile(value = {"prod","dev"})
public class Job {
    // 1 sec = 1000 ms

    @Scheduled(fixedRate = 5000,initialDelay = 1000)
    public void myJob() {
        System.out.println("Hello Good Morning");
    }

}
