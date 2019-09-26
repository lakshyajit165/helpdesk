package com.stackroute.helpdesk.commandDesignFramework.basiccommands;

import com.stackroute.helpdesk.commandDesignFramework.command.Information;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicCommandsTest {

    private MockMvc mockMvcBasicCommands;

    @Autowired
    private BasicCommands basicCommands;


    @Before
    public void setUp() throws Exception{
        mockMvcBasicCommands = MockMvcBuilders.standaloneSetup(basicCommands)
                .build();
    }

    @Test
    public void getBasicCommands() throws Exception {
        mockMvcBasicCommands.perform(
                MockMvcRequestBuilders.get("/basic-commands")
                       )
                        .andExpect(MockMvcResultMatchers.status().isOk());
               }
}
