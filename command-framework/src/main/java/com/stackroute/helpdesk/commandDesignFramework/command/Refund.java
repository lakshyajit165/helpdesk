package com.stackroute.helpdesk.commandDesignFramework.command;

import com.stackroute.helpdesk.commandDesignFramework.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/refund")
public class Refund {

    HashMap<String,Object> responseObject;

    @GetMapping
    public ResponseEntity<HashMap<String,Object>> initiateRefund(@RequestParam("param0") int userId,
                                                 @RequestParam("param1") int userId2){
        responseObject = new HashMap<>();
        responseObject.put("result","your refund is inititated for userId= "+userId);
        responseObject.put("message","success");
        responseObject.put("error","false");
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}
