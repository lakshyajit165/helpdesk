package com.stackroute.helpdesk.commandDesignFramework.command;

import com.stackroute.helpdesk.commandDesignFramework.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TicketCommand {

    private HashMap<String,Object> responseObject;

    @RequestMapping("ticket")
    public ResponseEntity<HashMap<String,Object>> getTicket(@RequestParam("param0") int id){
        responseObject = new HashMap<>();
        responseObject.put("result",new Ticket(1,"userId"));
        responseObject.put("message","success");
        responseObject.put("error","false");
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @RequestMapping("ticket-status")
    public ResponseEntity<HashMap<String,Object>> getTicketStatus(@RequestParam("param0") int id){
        responseObject = new HashMap<>();
        responseObject.put("result","CLOSED");
        responseObject.put("message","success");
        responseObject.put("error","false");
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}
