package com.stackroute.helpdesk.commandregistry.controller;

import com.stackroute.helpdesk.commandregistry.entity.Commands;
import com.stackroute.helpdesk.commandregistry.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/commandregistry/commands")
public class CommandRegistryController {

    @Autowired
    private CommandRepository commandRepository;

    CommandRegistryController(CommandRepository commandRepository)
    {
        this.commandRepository=commandRepository;
    }
    HashMap<String, Object> responseObject;

    /**
     *
     * get all commands
     *
     *
     */

    @GetMapping
    public ResponseEntity<HashMap<String, Object>> getCommands() {

        List<Commands> commands = commandRepository.findAll();

        if(commands.size()>0) {
            responseObject = new HashMap<>();
            responseObject.put("result", commands);
            responseObject.put("message", "Success!");
            responseObject.put("error", "false");
        }
//        else{
//            Res
//        }
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
    /**
     *
     * add commands
     *
     *
     */
    @PostMapping
    public ResponseEntity<HashMap<String,Object>>addCommands(@RequestBody Commands commands){
        //Commands commands = new Commands("name",str,"desc",new Date(),new Date(), "by","usage", Status.ACTIVE.toString());
     //   List<Commands> commandsList = Arrays.asList(commands);
        commandRepository.save(commands);
        responseObject = new HashMap<>();
        responseObject.put("result", commands);
        responseObject.put("message", "Success!");
        responseObject.put("error", "false");
        System.out.println(responseObject);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);

    }
    /**
     *
     * update commands
     *
     *
     */
//    @PatchMapping(consumes={"application/json"})
//    public ResponseEntity<HashMap<String, Object>> patchCommand(@RequestBody Commands commands) {
////        //commands.setName("awdawdawd");
////        //commands.setId(null);
//        //Commands c=commandRepository.findById(commands.getId()).get();
//
//        Commands command1 = commandRepository.findById(commands.getId()).get();
//        command1 = commands;
//        commandRepository.save(command1);
//        responseObject = new HashMap<>();
//        responseObject.put("result", command1);
//        responseObject.put("message", "Success!");
//        responseObject.put("error", "false");
//        return  new ResponseEntity<>(responseObject, HttpStatus.OK);
//    }


//    String[] str;
//    Commands commands = new Commands("name",str,"desc",new Date(),new Date(), "by","usage", Status.ACTIVE.toString());
}
