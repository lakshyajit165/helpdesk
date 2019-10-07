package com.stackroute.helpdesk.commanddesignframework.command.basiccommands;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class BasicCommands {

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;
    private HashMap<String,String> basicCommandsList;
    private Map<RequestMappingInfo, HandlerMethod> listOfCommands;

    @Autowired
    public BasicCommands(RequestMappingHandlerMapping requestMappingHandlerMapping){
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
    }

    @GetMapping("/basic-commands")
    public ResponseEntity<HashMap<String,String>> getBasicCommands(){
        listOfCommands = this.requestMappingHandlerMapping.getHandlerMethods();
        basicCommandsList = new HashMap<>();
        listOfCommands.forEach((x,y) -> {
            basicCommandsList.put(x.toString(),y.toString());
        });
        return new ResponseEntity<>(basicCommandsList, HttpStatus.OK);
    }
}
