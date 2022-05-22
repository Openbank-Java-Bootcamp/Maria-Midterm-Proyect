package com.ironhack.demomidterm.controllers.interfaces;

import com.ironhack.demomidterm.DTO.CheckingAccountDTO;
import com.ironhack.demomidterm.model.Checking;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

public interface CheckingControllerInterface {
    void storeChecking(CheckingAccountDTO checking);
}
