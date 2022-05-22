package com.ironhack.demomidterm.services.interfaces;

import com.ironhack.demomidterm.DTO.CheckingAccountDTO;
import com.ironhack.demomidterm.DTO.StudentCheckingDTO;
import com.ironhack.demomidterm.model.Checking;
import com.ironhack.demomidterm.model.StudentChecking;

public interface StudentCheckingServiceInterface {
    public StudentChecking saveStudentChecking(CheckingAccountDTO studentChecking);
}
