package com.stackroute.helpdesk.commandDesignFramework.command;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/information")
public class Information {

    HashMap<String,Object> responseObject;

    @GetMapping
    public ResponseEntity<HashMap<String,Object>> getInformation(){
        responseObject = new HashMap<>();
        responseObject.put("result","generic helpdesk");
        responseObject.put("message","success");
        responseObject.put("error","false");
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}
