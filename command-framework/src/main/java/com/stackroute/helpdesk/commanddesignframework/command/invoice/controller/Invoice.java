package com.stackroute.helpdesk.commanddesignframework.command.invoice.controller;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
public class Invoice {

    HashMap<String,Object> responseObject;

    @GetMapping("/lastinvoice")
    public ResponseEntity<HashMap<String,Object>> getLastInvoice(){
        responseObject = new HashMap<>();
        responseObject.put("message","success");
        responseObject.put("error","false");
        RestTemplate restTemplate = new RestTemplate();
        JSONObject jsonObject = restTemplate.getForObject("http://localhost:3000/result",JSONObject.class);
        List<Invoice> invoices = (List<Invoice>)jsonObject.get("data");
        responseObject.put("result",invoices.get(0));
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @GetMapping("/previousinvoice")
    public ResponseEntity<HashMap<String,Object>> getPreviousInvoices(){
        responseObject = new HashMap<>();
        responseObject.put("message","success");
        responseObject.put("error","false");
        RestTemplate restTemplate = new RestTemplate();
        JSONObject jsonObject = restTemplate.getForObject("http://localhost:3000/result",JSONObject.class);
        List<Invoice> invoices = (List<Invoice>)jsonObject.get("data");
        List<Invoice> previousInvoices = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(invoices.size());
        previousInvoices = invoices.stream().limit(10).collect(Collectors.toList());
        System.out.println(previousInvoices);
        responseObject.put("result",previousInvoices);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}
