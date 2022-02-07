package com.immunization.portal.controller;

import com.immunization.common.service.MarshallerService;
import com.immunization.portal.dto.UserRegistrationDTO;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MarshallerService marshallerService;

    private MockMvc mockMvc;

    private final UserRegistrationDTO dto = new UserRegistrationDTO("username", "password", "email@email.com");

    @BeforeEach
    void setup() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    @Order(1)
    void registerUser_successfully() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/user/register")
                .contentType(MediaType.APPLICATION_XML)
                .content(marshallerService.marshal(dto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // @Test
    // @Order(2)
    // void registerUser_unsuccessfully() throws Exception {
    // mockMvc.perform(MockMvcRequestBuilders.put("/api/user/register", dto))
    // .andExpect(MockMvcResultMatchers.status().isConflict());
    // }
}
