package com.stackroute.helpdesk.commandregistry.invoker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.helpdesk.commandregistry.exceptions.CommandNotFoundException;
import com.stackroute.helpdesk.commandregistry.exceptions.ParameterListNotValid;
import com.stackroute.helpdesk.commandregistry.invoker.model.Context;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/v1/commandregistry")
public class Invoker {

    static String paramString = "";
    private HashMap<String,Object> responseEntityBody;
    private RestTemplate restTemplate;

    @Value("${host_port: localhost:8080}")
    private String hostPort;


    @PostMapping("/execute/{commandString}")
    public <T> T execute(@PathVariable("commandString") String commandString, @RequestBody Context context) {
        System.out.println("called invoker");
        restTemplate = new RestTemplate();
        String[] command_string = commandString.split(" ");
        String command = command_string[0];
        String parameters = "";
        if(command_string.length > 1) {
            parameters = createParameter(command_string[1]);
            paramString = "";
        }
        String commandexec = "http://"+hostPort+"/"+command+"?"+parameters;
        System.out.println(commandexec);
        try{
            ResponseEntity<Object> responseEntity = restTemplate.getForEntity(commandexec, Object.class);
            Object result = (Object) responseEntity.getBody();
            responseEntityBody = new HashMap<>();
            responseEntityBody.put("result",result);
            responseEntityBody.put("message","success");
            responseEntityBody.put("error","false");
            responseEntityBody.put("context",context);
            return (T)new ResponseEntity<>(responseEntityBody, HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound notFoundException){
            throw new CommandNotFoundException("command not found");
        }catch (HttpClientErrorException.BadRequest badRequestException){
            throw new ParameterListNotValid("not enough parameters");
        }
    }

    public String createParameter(String parameterList){
       String[] listOfParameters = parameterList.split(",");
        AtomicInteger index = new AtomicInteger(0);
        Arrays.asList(listOfParameters).stream().forEach((parameter) -> {
//            int counter = index.getAndIncrement();
            paramString += "param"+ index.get() +"="+listOfParameters[index.getAndIncrement()]+"&";
        });
        return paramString;
    }
}
