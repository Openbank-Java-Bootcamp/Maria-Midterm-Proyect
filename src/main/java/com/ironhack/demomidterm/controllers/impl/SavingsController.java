package com.ironhack.demomidterm.controllers.impl;

import com.ironhack.demomidterm.DTO.CheckingAccountDTO;
import com.ironhack.demomidterm.DTO.SavingsDTO;
import com.ironhack.demomidterm.controllers.interfaces.SavingsControllerInterface;
import com.ironhack.demomidterm.services.interfaces.CheckingServiceInterface;
import com.ironhack.demomidterm.services.interfaces.SavingsServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SavingsController implements SavingsControllerInterface {
    @Autowired
    private SavingsServiceInterface savingServiceInterface;

    @PostMapping("/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public void storeSavings(@RequestBody @Valid SavingsDTO savingsDTO){
        savingServiceInterface.saveSavings(savingsDTO);
    }
}
