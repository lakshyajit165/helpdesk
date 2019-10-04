package com.stackroute.helpdesk.mailservice.mailstructure;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor

public class MailStructure {
    private String email;
    private String message;
    private String ticketId;
    private String subject;
    public MailStructure(String email, String message, String ticketId, String subject) {
        this.email = email;
        this.message = message;
        this.ticketId = ticketId;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return  ticketId + ':'+ email + ':' + subject + ':' + message;
    }
}