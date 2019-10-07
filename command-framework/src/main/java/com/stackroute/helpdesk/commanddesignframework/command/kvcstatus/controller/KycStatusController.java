package com.stackroute.helpdesk.commanddesignframework.command.kvcstatus.controller;

import com.stackroute.helpdesk.commanddesignframework.command.kvcstatus.model.KycStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class KycStatusController {

    private RestTemplate restTemplate;

    @GetMapping("/kycstatus")
    public ResponseEntity<String> getKycStatus(@RequestParam("param0") String userId){
        KycStatus kycStatus = restTemplate.getForObject("http://localhost:3000/result", KycStatus.class);
        return new ResponseEntity<>(kycStatus.getDocumentStatus(), HttpStatus.OK);
    }
}
