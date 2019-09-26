package com.stackroute.helpdesk.commandDesignFramework.basiccommands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/basic-commands")
public class BasicCommands {

    private HashMap<String,Object> responseObject;

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    public BasicCommands(RequestMappingHandlerMapping requestMappingHandlerMapping){
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
    }

    @GetMapping
    public ResponseEntity<HashMap<String,Object>> getBasicCommands(){
        List<String> basicCommandsList = new ArrayList<>();
        Map<RequestMappingInfo, HandlerMethod> listOfCommands = this.requestMappingHandlerMapping.getHandlerMethods();
        listOfCommands.forEach((x,y) -> {
            basicCommandsList.add(x+"/n"+y+"/n");
        } );
        responseObject = new HashMap<>();
        responseObject.put("result",basicCommandsList);
        responseObject.put("message","success");
        responseObject.put("error","false");
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}
