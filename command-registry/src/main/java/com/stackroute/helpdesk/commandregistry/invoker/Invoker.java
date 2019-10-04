package com.stackroute.helpdesk.commandregistry.invoker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.ribbon.proxy.annotation.Http;
import com.stackroute.helpdesk.commandregistry.Exceptions.CommandNotFoundException;
import com.stackroute.helpdesk.commandregistry.Exceptions.ParameterListNotValid;
import com.stackroute.helpdesk.commandregistry.invoker.model.Context;
import org.json.simple.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("api/v1/commandregistry")
public class Invoker {

    static String paramString = "";
    JSONObject obj = new JSONObject();
    ObjectMapper objectMapper = new ObjectMapper();

    private RestTemplate restTemplate;

    @RequestMapping("/execute/{commandString}")
    public <T> T execute(@PathVariable("commandString") String commandString, @RequestBody Context context) {
        restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<String>(context.toString(),headers);
        String[] command_string = commandString.split(" ");
        String command = command_string[0];
        String parameters = "";
        if(command_string.length > 1) {
            parameters = createParameter(command_string[1]);
            paramString = "";
        }
        String commandexec = "http://localhost:8080/"+command+"?"+parameters;
//        String commandexec = "http://zuul-api-gateway:8765/command-framework/"+command+"?"+parameters;
        try{
            ResponseEntity<Object> responseEntity = restTemplate.getForEntity(commandexec, Object.class);
            HashMap<String,Object> responseEntityBody = (HashMap<String, Object>) responseEntity.getBody();
            responseEntityBody.put("context",context);
            return (T)new ResponseEntity<>(responseEntityBody, HttpStatus.OK);
//            return (T)restTemplate.getForEntity(commandexec, Object.class);
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
