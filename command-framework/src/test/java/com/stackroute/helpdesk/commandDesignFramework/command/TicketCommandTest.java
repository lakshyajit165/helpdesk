package com.stackroute.helpdesk.commandDesignFramework.command;

import com.stackroute.helpdesk.commandDesignFramework.Ticket;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketCommandTest {

    private MockMvc mockMvcTicketCommand;

    @InjectMocks
    private TicketCommand ticketCommand;

    @Before
    public void setUp() throws Exception{
        mockMvcTicketCommand = MockMvcBuilders.standaloneSetup(ticketCommand)
                .build();
    }

    @Test
    public void getTicket() throws Exception {
        mockMvcTicketCommand.perform(
                MockMvcRequestBuilders.get("/ticket?param0=1")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("result.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("result.userId").value("userId"));
    }

    @Test
    public void getTicketStatus() throws Exception {
        mockMvcTicketCommand.perform(
                MockMvcRequestBuilders.get("/ticket-status?param0=1")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("result").value("CLOSED"));
    }

}
