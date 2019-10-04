package com.stackroute.helpdesk.commanddesignframework.command;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Information {

    HashMap<String,Object> responseObject;

    @GetMapping("/information")
    public ResponseEntity<HashMap<String,Object>> getInformation(){
        responseObject = new HashMap<>();
        responseObject.put("result","generic helpdesk");
        responseObject.put("message","success");
        responseObject.put("error","false");
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}
