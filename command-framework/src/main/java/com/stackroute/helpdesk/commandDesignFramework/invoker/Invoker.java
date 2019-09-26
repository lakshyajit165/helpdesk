package com.stackroute.helpdesk.commandDesignFramework.invoker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class Invoker {

    static String paramString = "";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/execute/{commandString}")
    public <T> T execute(@PathVariable("commandString") String commandString) {
        String[] command_string = commandString.split(" ");
        String command = command_string[0];
        String parameters = "";
        if(command_string.length > 1)
        parameters = createParameter(command_string[1]);

        String commandexec = "http://spring-boot-command-framework:8080/"+command+"?"+parameters;
        return (T)restTemplate.getForObject(commandexec,String.class);
    }

    public String createParameter(String parameterList){
       String[] listOfParameters = parameterList.split(",");
        AtomicInteger index = new AtomicInteger(0);
        Arrays.asList(listOfParameters).stream().forEach((parameter) -> {
            int counter = index.getAndIncrement();
            paramString += "param"+ counter +"="+listOfParameters[counter]+"&";
            System.out.println(paramString);
        });
        return paramString;
    }
}
