package com.stackroute.helpdesk.commandRegistry.getbasiccommands;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("/docs")
public class BasicCommands {

    private HashMap<String,Object> responseObject;

    @GetMapping
    public <T> T checkForBasicCommands(){
        return (T)new ResponseEntity<>("",HttpStatus.OK);
    }




    public<T> T getBasicCommands(){
        RestTemplate restTemplate =new RestTemplate();
//        return (T)restTemplate.getForObject("http://spring-boot-command-framework:8080/basic-commands",Object.class);
        return (T)restTemplate.getForObject("http://localhost:8080/basic-commands",Object.class);
    }
}
