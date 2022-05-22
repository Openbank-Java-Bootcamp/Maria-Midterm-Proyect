package com.ironhack.demomidterm.services.interfaces;

import com.ironhack.demomidterm.DTO.CheckingAccountDTO;
import com.ironhack.demomidterm.DTO.CreditCardDTO;
import com.ironhack.demomidterm.model.Checking;
import com.ironhack.demomidterm.model.CreditCard;

public interface CreditCardServiceInterface {
    public CreditCard saveCreditCard(CreditCardDTO creditCardDTO);
}
