package com.ironhack.demomidterm.controllers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.demomidterm.DTO.AccountDTO;
import com.ironhack.demomidterm.DTO.CheckingAccountDTO;
import com.ironhack.demomidterm.DTO.SavingsDTO;
import com.ironhack.demomidterm.model.Money;
import com.ironhack.demomidterm.repository.AccountRepository;
import com.ironhack.demomidterm.repository.CheckingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
class CheckingControllerTest {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @InjectMocks
    AccountController accountController;

    @Mock
    AccountDTO accountDTO;


    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @AfterEach
    void tearDown() {
        checkingRepository.deleteAll();
    }

    /*@Test
    void storeCheckingCreated() throws Exception{
        CheckingAccountDTO checkingAccountDTO=new CheckingAccountDTO(new Money(BigDecimal.valueOf(300), Currency.getInstance("USD")),1,2, new Money(BigDecimal.valueOf(50), Currency.getInstance("USD")),"1234", new Money(BigDecimal.valueOf(150), Currency.getInstance("USD")), new Money(BigDecimal.valueOf(50), Currency.getInstance("USD")),"1996-05-14");
        String body =objectMapper.writeValueAsString(checkingAccountDTO);
        MvcResult mvcResult=mockMvc.perform(post("/api/checkings")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound()).andReturn();
    }*/


}