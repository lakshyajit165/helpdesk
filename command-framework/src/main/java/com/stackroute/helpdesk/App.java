package com.stackroute.helpdesk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@RefreshScope
@SpringBootApplication
@EnableEurekaClient
public class App
{
    @Value("${message: Default}")
    private String message;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
