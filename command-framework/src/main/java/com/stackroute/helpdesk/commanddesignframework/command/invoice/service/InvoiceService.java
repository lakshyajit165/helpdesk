package com.stackroute.helpdesk.commanddesignframework.command.invoice.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import com.stackroute.helpdesk.commanddesignframework.command.refund.model.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

 public List<Invoice> getPreviousInvoices(JSONObject jsonObject){
  List<Invoice> invoices = (List<Invoice>)jsonObject.get("data");
        List<Invoice> previousInvoices = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(invoices.size());
        previousInvoices = invoices.stream().limit(10).collect(Collectors.toList());
        return previousInvoices;
 }

}
