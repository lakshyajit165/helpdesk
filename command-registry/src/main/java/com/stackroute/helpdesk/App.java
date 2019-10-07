package com.stackroute.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients("com.stackroute.helpdesk.commandregistry.*")
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
