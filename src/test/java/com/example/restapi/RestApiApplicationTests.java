package com.example.restapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class RestApiApplicationTests {

    @SpyBean
    private ControllerAPI controllerAPI;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldReturnErrorMessage() throws Exception{
        mockMvc.perform(post("/count").content(""))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Empty string in request body.")));
    }

    @Test
    public void shouldReturnOKMessage() throws Exception{
        String result = mockMvc.perform(post("/count").content("allalala"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        List<Map.Entry<Character, Integer>> list = mapper.readValue(result,List.class);
    }
}
