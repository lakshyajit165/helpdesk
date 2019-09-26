package com.stackroute.helpdesk.getbasiccommands;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/docs")
public class BasicCommands {

    private HashMap<String,Object> responseObject;

    @GetMapping
    public ResponseEntity<HashMap<String,Object>> getBasicCommands(){
        RestTemplate restTemplate =new RestTemplate();
        String basicCommands = restTemplate.getForObject("http://spring-boot-command-framework:8080/basic-commands",String.class);
        responseObject = new HashMap<>();
        responseObject.put("result",basicCommands);
        responseObject.put("message","success");
        responseObject.put("error","false");
        return new ResponseEntity<>(responseObject,HttpStatus.OK);
    }
}
