package com.stackroute.helpdesk.controller;

import com.stackroute.helpdesk.ticketservice.entity.TicketStructure;
import com.stackroute.helpdesk.ticketservice.exceptions.TicketNotFoundException;
import com.stackroute.helpdesk.ticketservice.repository.TicketRepository;
import com.stackroute.helpdesk.ticketservice.service.TicketInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
//@CrossOrigin(origins="http://localhost:4200")
public class TicketController {


    TicketInterface ticketInterface;
    //TicketRepository ticketRepository;

    @Autowired
    public TicketController(TicketInterface ticketInterface){
        this.ticketInterface = ticketInterface;
    }

    HashMap<String, Object> responseObject;


    @GetMapping(path="/tickets")
    public ResponseEntity<HashMap<String, Object>> getAllTickets(){

        List<TicketStructure> ticketStructures = ticketInterface.getTickets();

        responseObject = new HashMap<>();

        responseObject.put("result", ticketStructures);
        responseObject.put("errors", false);

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @GetMapping(path="/tickets/open")
    public ResponseEntity<HashMap<String, Object>> getOpenTickets() {

        responseObject = new HashMap<>();

        try{
            List<TicketStructure> ticketStructures = ticketInterface.getOpenTickets();
            responseObject.put("result", ticketStructures);
            responseObject.put("errors", false);
            responseObject.put("message", "Open tickets found!");
        }catch(Exception e){
            responseObject.put("result", null);
            responseObject.put("errors", false);
            responseObject.put("message", "No Open tickets found!");
        }

        return new ResponseEntity<>(responseObject, HttpStatus.OK);


    }

    @GetMapping(path="/tickets/closed")
    public ResponseEntity<HashMap<String, Object>> getClosedTickets() {

        responseObject = new HashMap<>();

        try{
            List<TicketStructure> ticketStructures = ticketInterface.getClosedTickets();
            responseObject.put("result", ticketStructures);
            responseObject.put("errors", false);
            responseObject.put("message", "Close tickets found!");
        }catch(Exception e){
            responseObject.put("result", null);
            responseObject.put("errors", false);
            responseObject.put("message", "No Closed tickets found!");
        }

        return new ResponseEntity<>(responseObject, HttpStatus.OK);


    }


    @GetMapping(path="/tickets/engaged")
    public ResponseEntity<HashMap<String, Object>> getEngagedTickets() {

        responseObject = new HashMap<>();

        try{
            List<TicketStructure> ticketStructures = ticketInterface.getEngagedTickets();
            responseObject.put("result", ticketStructures);
            responseObject.put("errors", false);
            responseObject.put("message", "Engage tickets found!");
        }catch(Exception e){
            responseObject.put("result", null);
            responseObject.put("errors", false);
            responseObject.put("message", "No Engage tickets found!");
        }

        return new ResponseEntity<>(responseObject, HttpStatus.OK);


    }

    @PatchMapping(path="/tickets/status/engaged",  consumes={"application/json"})
    public ResponseEntity<HashMap<String, Object>> changeStatusToEngaged(@RequestBody TicketStructure ticketStructure){
       // System.out.println("Ticket: " + ticketStructure);

        TicketStructure oldTicket = ticketInterface.getTicketById(ticketStructure.getId()).get();

        // System.out.println("Old Ticket : " + oldTicket);
        //oldTicket.setStatus(ticket.getStatus());

        oldTicket.setStatus("engaged");


        ticketInterface.saveTicketStatus(oldTicket);


//        System.out.println("old ticket after update: " + oldTicket);

        responseObject = new HashMap<>();
        responseObject.put("result", oldTicket);
        responseObject.put("errors", false);
        responseObject.put("message", "Ticket goes to csr or bot for further handling");
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }






}
