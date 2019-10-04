package com.stackroute.helpdesk.commanddesignframework.command;

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
public class InformationTest {

    private MockMvc mockMvcInformation;

    @InjectMocks
    private Information information;


    @Before
    public void setUp() throws Exception{
        mockMvcInformation = MockMvcBuilders.standaloneSetup(information)
                .build();
    }

    @Test
    public void getInformation() throws Exception {
        mockMvcInformation.perform(
                MockMvcRequestBuilders.get("/information")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("result").value("generic helpdesk"));
    }
}
