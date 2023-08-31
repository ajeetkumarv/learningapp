package com.example.learningapp.carexample.controller;

import com.example.learningapp.carexample.model.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // we require the spring context when we run each test
@AutoConfigureMockMvc // enable auto-configuration of mock mvc
class CarControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllFilteredByPrice() {
    }

    @Test
    @DisplayName("Get Car by id")
    void getById() throws Exception {
        var expResult = objectMapper.readValue("""
                {
                    "id" : 1,
                    "model": "Astra",
                    "brand": "Opel",
                    "horse": 100,
                    "price": 18000
                }
                """, Car.class);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/cars/1"))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        Car car = objectMapper.readValue(contentAsString, Car.class);

        Assertions.assertEquals(expResult, car); // it uses equals method in Car class
    }
}