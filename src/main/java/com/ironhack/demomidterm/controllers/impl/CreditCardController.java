package com.ironhack.demomidterm.controllers.impl;

import com.ironhack.demomidterm.DTO.CreditCardDTO;
import com.ironhack.demomidterm.DTO.SavingsDTO;
import com.ironhack.demomidterm.controllers.interfaces.CreditCardControllerInterface;
import com.ironhack.demomidterm.services.interfaces.CreditCardServiceInterface;
import com.ironhack.demomidterm.services.interfaces.SavingsServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CreditCardController implements CreditCardControllerInterface {
    @Autowired
    private CreditCardServiceInterface creditCardServiceInterface;

    @PostMapping("/creditCard")
    @ResponseStatus(HttpStatus.CREATED)
    public void storeCreditCard(@RequestBody @Valid CreditCardDTO creditCardDTO){
        creditCardServiceInterface.saveCreditCard(creditCardDTO);
    }
}
