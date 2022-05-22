package com.ironhack.demomidterm.services.interfaces;

import com.ironhack.demomidterm.DTO.SavingsDTO;
import com.ironhack.demomidterm.model.Savings;
import com.ironhack.demomidterm.model.StudentChecking;

public interface SavingsServiceInterface {
    public Savings saveSavings(SavingsDTO savings);
}
