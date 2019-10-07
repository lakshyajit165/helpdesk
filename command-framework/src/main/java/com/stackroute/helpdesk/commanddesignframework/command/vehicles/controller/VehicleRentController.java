package com.stackroute.helpdesk.commanddesignframework.command.vehicles.controller;

import com.stackroute.helpdesk.commanddesignframework.command.vehicles.services.VehicleRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class VehicleRentController {

    @Autowired
    private VehicleRentService vehicleRentService;

    @Autowired
    private RestTemplate restTemplate;

//    @GetMapping
//    public ResponseEntity<HashMap<String,Object>> getallVehicleRent(){
//
//    }

}
