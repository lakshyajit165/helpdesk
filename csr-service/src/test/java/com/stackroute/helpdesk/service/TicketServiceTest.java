package com.stackroute.helpdesk.service;

import com.stackroute.helpdesk.ticketservice.entity.TicketStructure;
import com.stackroute.helpdesk.ticketservice.exceptions.TicketNotFoundException;
import com.stackroute.helpdesk.ticketservice.repository.TicketRepository;
import com.stackroute.helpdesk.ticketservice.service.TicketInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketServiceTest {
    @MockBean
    private TicketRepository ticketRepository;
    @Autowired
    private TicketInterface ticketInterface;
    @Test
    public void getTickets() throws Exception
    {
        List<TicketStructure> list = new ArrayList<>();
        Mockito.when(ticketRepository.findAll())
                .thenReturn(list);
        List<TicketStructure> list1 = ticketInterface.getTickets();
        assertThat(list1, is(list));
    }
    //Test to check getting a ticket by its id
    @Test
    public void getTicketbyIdTest() throws Exception {
        TicketStructure ticketStructure=new TicketStructure();
        ticketStructure.setId("5d8eddc9ddcbfe19dc41041f");
        Mockito.when(ticketRepository.findById("5d8eddc9ddcbfe19dc41041f"))
                .thenReturn(java.util.Optional.of(ticketStructure));
        TicketStructure ticketStructure1 = ticketInterface.getTicketById("5d8eddc9ddcbfe19dc41041f").get();
        assertThat(ticketStructure1, is(ticketStructure));
    }
//    @Test
//    public void getOpenTickets() throws TicketNotFoundException {
//        List<TicketStructure> list = new ArrayList<>();
//        List<TicketStructure> list1 = ticketInterface.getOpenTickets();
//        Mockito.when(ticketRepository.getOpenTickets())
//                .thenReturn(list);
//
//        System.out.println(list1);
//        System.out.println(list);
//        assertThat(list1, is(list));
//    }
}
