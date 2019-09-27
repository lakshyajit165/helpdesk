package com.stackroute.helpdesk.commanddesignframework.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BasicCommandsConfiguration {
    @Bean
    public RestTemplate getRestTemplate(){
        System.out.println("bean created");
        return new RestTemplate();
    }
}
