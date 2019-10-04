package com.stackroute.helpdesk.commandregistry.getbasiccommands;

import com.stackroute.helpdesk.commandregistry.exceptions.CommandNotFoundException;
import com.stackroute.helpdesk.commandregistry.entity.Commands;
import com.stackroute.helpdesk.commandregistry.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class BasicCommands {

    @Autowired
    private CommandRepository commandRepository;

    private HashMap<String,Object> responseObject;

    public <T> T checkForBasicCommands(){
        return (T)new ResponseEntity<>("",HttpStatus.OK);
    }


    @GetMapping("/docs")
    public<T> T getBasicCommands(){
        try{
        RestTemplate restTemplate =new RestTemplate();
//        return (T)restTemplate.getForObject("http://zuul-api-gateway:8765/command-framework/basic-commands",Object.class);
            HashMap<String, Object> commandListRecieved = (HashMap<String, Object>) restTemplate.getForObject("http://zuul-api-gateway:8765/commandframework/basic-commands",Object.class);
            commandListRecieved.forEach((keyOfCommandList,valueOfCommandList) -> {
                if(keyOfCommandList=="result"){
                    HashMap<String,Object> basicCommandList = (HashMap<String,Object>)valueOfCommandList;
                    List<Commands> listOfCommand = new ArrayList<>();
                    basicCommandList.forEach((commandName,commandDetails) -> {
                        if(commandName.charAt(1) != ' '){
                            Commands command = new Commands();
                            command.setName(commandName.split("/")[1].substring(0,commandName.split("/")[1].length()-1));
                            command.setStatus("active");
                            listOfCommand.add(command);
                            //System.out.println(commandName);
                        }
                    });
                    commandRepository.saveAll(listOfCommand);
                }
            });
            return (T)commandListRecieved;
        //        return (T)restTemplate.getForObject("http://localhost:8080/basic-commands",Object.class);
        }catch (HttpClientErrorException.NotFound exception){
            throw new CommandNotFoundException("command does not exists");
        }
    }

}
