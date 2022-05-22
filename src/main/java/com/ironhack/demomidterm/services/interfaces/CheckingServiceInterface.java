package com.ironhack.demomidterm.services.interfaces;

import com.ironhack.demomidterm.DTO.CheckingAccountDTO;
import com.ironhack.demomidterm.model.Account;
import com.ironhack.demomidterm.model.Checking;

public interface CheckingServiceInterface {
    public void saveChecking(CheckingAccountDTO checking);
}
