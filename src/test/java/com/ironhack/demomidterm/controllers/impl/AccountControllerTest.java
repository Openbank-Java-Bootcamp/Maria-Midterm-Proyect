package com.ironhack.demomidterm.controllers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.demomidterm.DTO.AccountDTO;
import com.ironhack.demomidterm.model.Account;
import com.ironhack.demomidterm.model.AccountHolder;
import com.ironhack.demomidterm.model.Address;
import com.ironhack.demomidterm.model.Money;
import com.ironhack.demomidterm.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class AccountControllerTest {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @InjectMocks
    AccountController accountController;

    @Mock
    AccountDTO accountDTO;


    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
       // Address add1 = new Address("¨Teststreet","¨testCity","¨TestCountry",123);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        /*List<Account> accounts = accountRepository.saveAll(
                List.of(
                        new Account(300.10, new AccountHolder( "John Doe", "john", "1234", new ArrayList<>(), LocalDate.now(),add1,add1),null,50.65);
                        new Account(150, new AccountHolder( "Maria Jerez", "maria", "1233", new ArrayList<>(), LocalDate.now(),add1,add1),null,60)
                )
        );*/
    }

    @AfterEach
    void tearDown() {
        accountRepository.deleteAll();
    }

    @Test
    void getAccounts() {
    }

    /*@Test
    void getAccount() throws Exception{
        /*MvcResult result = mockMvc.perform(get("/api/accounts/1"))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("John Doe"));
        // given
        AccountDTO accountDTO1 = new AccountDTO(1, new Money(new BigDecimal.valueOf(43.63), Currency.getInstance("USD")), 1);
        AccountDTO accountDTO2 = new AccountDTO(2, new Money(new BigDecimal.valueOf(542.67)), 2);
        AccountDTO accountsDTO = new AccountDTO();
        accountsDTO.setEmployeeList(Arrays.asList(employee1, employee2));

        when(employeeDAO.getAllEmployees()).thenReturn(employees);

        // when
        Employees result = employeeController.getEmployees();

        // then
        assertThat(result.getEmployeeList().size()).isEqualTo(2);

        assertThat(result.getEmployeeList().get(1).getFirstName())
                .isEqualTo(employee2.getFirstName());
    }*/

    @Test
    void updateAccount() {
    }

    @Test
    void deleteAccount() {
    }
}