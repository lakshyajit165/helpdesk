package com.stackroute.helpdesk.commanddesignframework.command.invoice.controller;


import com.stackroute.helpdesk.commanddesignframework.command.refund.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceControllerTest {


    private MockMvc mockMvcInvoiceController;

    @InjectMocks
    private InvoiceController invoiceController;


    @Before
    public void setUp() throws Exception{
        mockMvcInvoiceController = MockMvcBuilders.standaloneSetup(invoiceController)
                .build();
    }

    @Test
    public void getPreviousInvoices() throws Exception {
        HashMap<String,Object> responseObject = new HashMap<>();
        responseObject.put("message","success");
        responseObject.put("error","false");
        responseObject.put("result", new ArrayList<Invoice>() {
        });
        TestRestTemplate restTemplate = new TestRestTemplate();
        Mockito
                .when(restTemplate.getForObject("http://zuul-api-gateway:8765/commandframework/previousinvoices", Object.class))
                .thenReturn(new ResponseEntity<HashMap<String,Object>>(responseObject, HttpStatus.OK));
        mockMvcInvoiceController.perform(
                MockMvcRequestBuilders.get("/previousinvoices")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getLastInvoice() throws Exception {
        HashMap<String,Object> responseObject = new HashMap<>();
        responseObject.put("message","success");
        responseObject.put("error","false");
        responseObject.put("result", new Invoice());
        TestRestTemplate restTemplate = new TestRestTemplate();
        Mockito
                .when(restTemplate.getForObject("http://zuul-api-gateway:8765/commandframework/previousinvoices", Object.class))
                .thenReturn(new ResponseEntity<HashMap<String,Object>>(responseObject, HttpStatus.OK));
        mockMvcInvoiceController.perform(
                MockMvcRequestBuilders.get("/previousinvoices")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
