package com.ironhack.demomidterm.services.impl;

import com.ironhack.demomidterm.DTO.CheckingAccountDTO;
import com.ironhack.demomidterm.DTO.StudentCheckingDTO;
import com.ironhack.demomidterm.model.Checking;
import com.ironhack.demomidterm.model.StudentChecking;
import com.ironhack.demomidterm.repository.AccountHolderRepository;
import com.ironhack.demomidterm.repository.CheckingRepository;
import com.ironhack.demomidterm.repository.StudentCheckingRepository;
import com.ironhack.demomidterm.services.interfaces.StudentCheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class StudentCheckingService implements StudentCheckingServiceInterface {

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;


    public StudentChecking saveStudentChecking(CheckingAccountDTO checkingDTO) {
        try {
            return studentCheckingRepository.save(new StudentChecking(checkingDTO.getBalance(), accountHolderRepository.findById(checkingDTO.getPrimaryOwner()).get(), accountHolderRepository.findById(checkingDTO.getSecondaryOwner()).get(),
                    checkingDTO.getPenaltyFee(), checkingDTO.getSecretKey(), checkingDTO.getBirthday()));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Malformed StudentChecking");
        }
    }
}
