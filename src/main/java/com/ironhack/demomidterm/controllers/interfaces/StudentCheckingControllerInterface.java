package com.ironhack.demomidterm.controllers.interfaces;

import com.ironhack.demomidterm.DTO.CheckingAccountDTO;
import com.ironhack.demomidterm.DTO.StudentCheckingDTO;
import com.ironhack.demomidterm.model.Checking;
import com.ironhack.demomidterm.model.StudentChecking;

public interface StudentCheckingControllerInterface {
    void storeStudentChecking(CheckingAccountDTO studentChecking);
}
