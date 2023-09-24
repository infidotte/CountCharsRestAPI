package com.example.restapi;

import com.example.restapi.Controller.ControllerAPI;
import com.example.restapi.Entity.Node;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class RestApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldReturnErrorMessage() throws Exception {
        //if body is empty, then we are expecting a defined error message
        mockMvc.perform(post("/count").content(""))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Empty string in request body.")));
    }

    @Test
    public void shouldReturnOKMessage() throws Exception {
        //if body is not empty, then we are expecting an ok result
        String result = mockMvc.perform(post("/count").content("allalalaa"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        JsonMapper mapper = new JsonMapper();
        List<Node> list = List.of(mapper.readValue(result, Node[].class));
        List<Node> asserted = new ArrayList<>();
        asserted.add(new Node('a', 5));
        asserted.add(new Node('l', 4));
        //then we are expecting, that request result is sorted correctly
        assertEquals(list, asserted);
    }
}
