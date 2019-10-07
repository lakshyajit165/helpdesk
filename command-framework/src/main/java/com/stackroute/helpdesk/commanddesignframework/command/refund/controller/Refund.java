package com.stackroute.helpdesk.commanddesignframework.command.refund.controller;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("")
public class Refund {

//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/refund")
    public ResponseEntity<String> initiateRefund(@RequestParam("param0") int ticketId,
                                       @RequestParam("param1") int userId){
        String returnString = "your refund is inititated for userId= "+ticketId+"for userId2= "+userId;
        return new ResponseEntity<>(returnString,HttpStatus.OK);
    }

}
