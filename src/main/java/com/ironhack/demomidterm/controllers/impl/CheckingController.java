package com.ironhack.demomidterm.controllers.impl;

import com.ironhack.demomidterm.DTO.CheckingAccountDTO;
import com.ironhack.demomidterm.controllers.interfaces.CheckingControllerInterface;
import com.ironhack.demomidterm.model.Account;
import com.ironhack.demomidterm.model.Checking;
import com.ironhack.demomidterm.services.interfaces.AccountServiceInterface;
import com.ironhack.demomidterm.services.interfaces.CheckingServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CheckingController implements CheckingControllerInterface {
    @Autowired
    private CheckingServiceInterface checkingServiceInterface;

    @PostMapping("/checkings")
    @ResponseStatus(HttpStatus.CREATED)
    public void storeChecking(@RequestBody @Valid CheckingAccountDTO checkingAccountDTO){
        checkingServiceInterface.saveChecking(checkingAccountDTO);
    }
}
