package com.springtechie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomBeans {

    @Bean(name = "restTemplate")
    @Scope("prototype")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
