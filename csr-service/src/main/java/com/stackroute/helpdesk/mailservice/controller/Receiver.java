package com.stackroute.helpdesk.mailservice.controller;

import com.stackroute.helpdesk.mailservice.mailstructure.MailStructure;
import com.stackroute.helpdesk.ticketservice.entity.TicketStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class Receiver {

    String ticketId, email, subject, msg;


    @Autowired
    private JavaMailSender javaMailSender;
    public void receiveMessage(String emailString) {

        ticketId = emailString.split(":")[0];
        email = emailString.split(":")[1];
        subject = emailString.split(":")[2];
        msg = emailString.split(":")[3];


        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText("Your ticket id is "+ticketId+"  "+ msg);
        javaMailSender.send(simpleMailMessage);
        System.out.println("success");
    }
//
//    public void receiveMessage(TicketStructure ticketStructure) {
//
//        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
//       // simpleMailMessage.setTo(ticketStructure.getUsermail());
//        simpleMailMessage.setTo("anshugari07@gmail.com");
//        simpleMailMessage.setSubject("HelpDesk optimus TicketStructure Resolved");
//        simpleMailMessage.setText("Your ticketStructure with id "+ ticketStructure.getId()+" has been resolved!");
//        javaMailSender.send(simpleMailMessage);
//
//        System.out.println("success");
//
//    }
}

