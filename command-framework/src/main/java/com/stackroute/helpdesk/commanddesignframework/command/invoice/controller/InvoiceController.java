package com.stackroute.helpdesk.commanddesignframework.command.invoice.controller;

import com.stackroute.helpdesk.commanddesignframework.command.invoice.service.InvoiceService;
import com.stackroute.helpdesk.commanddesignframework.command.refund.model.Invoice;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/lastinvoice")
    public ResponseEntity<Invoice> getLastInvoice(@RequestParam("param0") String userId, @RequestParam("param1") String bookingStatus){
        Invoice invoice = restTemplate.getForObject("http://localhost:3000/result", Invoice.class);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @GetMapping("/previousinvoices")
    public ResponseEntity<List<Invoice>> getPreviousInvoices(@RequestParam("param0") String userId){
        JSONObject jsonObject = restTemplate.getForObject("http://localhost:3000/result",JSONObject.class);
        return new ResponseEntity<>(invoiceService.getPreviousInvoices(jsonObject), HttpStatus.OK);
    }
}
