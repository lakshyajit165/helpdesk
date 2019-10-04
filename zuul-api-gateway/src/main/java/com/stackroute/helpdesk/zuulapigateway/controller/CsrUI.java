package com.stackroute.helpdesk.zuulapigateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CsrUI {

    @GetMapping("/")
    public String redirectToCsrUI(){
        return "forward:csr-angular";
    }
}
