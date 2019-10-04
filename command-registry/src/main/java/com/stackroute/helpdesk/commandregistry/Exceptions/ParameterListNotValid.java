package com.stackroute.helpdesk.commandregistry.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParameterListNotValid extends RuntimeException {

    public ParameterListNotValid(String commandName){super(commandName);}
}
