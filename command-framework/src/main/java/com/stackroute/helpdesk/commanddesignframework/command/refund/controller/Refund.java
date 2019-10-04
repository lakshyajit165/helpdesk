package com.stackroute.helpdesk.commanddesignframework.command.refund.controller;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class Refund {

    @Value("${message: Default}")
    private String message;

    HashMap<String,Object> responseObject;

    @GetMapping("/refund")
    public ResponseEntity<HashMap<String,Object>> initiateRefund(@RequestParam("param0") int ticketId,
                                       @RequestParam("param1") int userId){


        responseObject = new HashMap<>();
        responseObject.put("result","your refund is inititated for userId= "+ticketId+"for userId2= "+userId);
        responseObject.put("message","success");
        responseObject.put("error","false");
//        responseObject.put("context", context);
        String returnString = "your refund is inititated for userId= "+ticketId+"for userId2= "+userId;
        responseObject.put("result",returnString);
        return new ResponseEntity<>(responseObject,HttpStatus.OK);
    }

}
