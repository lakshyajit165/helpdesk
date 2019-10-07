package com.stackroute.helpdesk.zuulapigateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CsrUI {

    @GetMapping("/")
    public String redirectToCsrUi(){
        return "forward:csr-angular";
    }

    @GetMapping("/commandregistryui")
    public String redirectToCommandRegistryUi(){
        return "forward:command-registry-angular";
    }
}
