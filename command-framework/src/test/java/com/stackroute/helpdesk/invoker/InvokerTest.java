package com.stackroute.helpdesk.invoker;


import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.helpdesk.commandDesignFramework.command.Information;
import com.stackroute.helpdesk.commandDesignFramework.command.Refund;
import com.stackroute.helpdesk.commandDesignFramework.invoker.Invoker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvokerTest {

    private MockMvc mockMvcInvoker;

//    @Autowired
//    private Invoker invoker;

    @MockBean
    private Invoker invoker;

    @Mock
    private TestRestTemplate restTemplate;


    @Before
    public void setUp() throws Exception{
        mockMvcInvoker = MockMvcBuilders.standaloneSetup(invoker)
                .build();
    }


    @Test
    public void execute() throws Exception {
        HashMap<String,Object> responseObject = new HashMap<>();
        responseObject.put("result","generic helpdesk");
        responseObject.put("message","success");
        responseObject.put("error","false");
        Mockito
                .when(restTemplate.getForObject("http://spring-boot-command-framework:8080/information", Object.class))
                .thenReturn(new ResponseEntity<HashMap<String,Object>>(responseObject, HttpStatus.OK));

        Object result = restTemplate.getForObject("http://spring-boot-command-framework:8080/information", Object.class);
        String expected = result.toString().split(",")[1];
        assertEquals(expected.substring(8),"generic helpdesk");
    }
}
