package com.ironhack.demomidterm.services.impl;

import com.ironhack.demomidterm.DTO.CheckingAccountDTO;
import com.ironhack.demomidterm.DTO.StudentCheckingDTO;
import com.ironhack.demomidterm.model.*;
import com.ironhack.demomidterm.repository.AccountHolderRepository;
import com.ironhack.demomidterm.repository.AccountRepository;
import com.ironhack.demomidterm.repository.CheckingRepository;
import com.ironhack.demomidterm.repository.StudentCheckingRepository;
import com.ironhack.demomidterm.services.interfaces.CheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class CheckingService implements CheckingServiceInterface {
    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private StudentCheckingRepository studentCheckingRepository;
    @Autowired
    private StudentCheckingService studentCheckingService;

    public void saveChecking(CheckingAccountDTO checkingAccountDTO) {
        //Admins can create new accounts:
        /*AccountHolder primaryOwner = accountHolderRepository.findById(checkingAccountDTO.getPrimaryOwner())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ("User with id " + checkingAccountDTO.getPrimaryOwner() + " does not exist")));
        AccountHolder secondaryOwner = accountHolderRepository.findById(checkingAccountDTO.getSecondaryOwner()).orElse(null);*/

        if (checkingAccountDTO.getBalance().getAmount().compareTo(new BigDecimal("250")) < 0 || checkingAccountDTO.getMinimumBalance().getAmount().compareTo(new BigDecimal("250")) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The minimum balance and the balance must be greater than 250");
        }
        if (checkingAccountDTO.getMonthlyMaintenanceFee().getAmount().compareTo(new BigDecimal("12")) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Monthly Maintenance Fee must be greater than 12");
        }
        try {

            int age = Period.between(checkingAccountDTO.getBirthday(), LocalDate.now()).getYears();
            if (age < 24) { //call studentChecking
                 studentCheckingService.saveStudentChecking(checkingAccountDTO);
            } else {

                 checkingRepository.save(new Checking(
                        checkingAccountDTO.getBalance(),
                        accountHolderRepository.findById(checkingAccountDTO.getPrimaryOwner()).get(),
                        accountHolderRepository.findById(checkingAccountDTO.getSecondaryOwner()).get(),
                        checkingAccountDTO.getPenaltyFee(),
                        checkingAccountDTO.getSecretKey(),
                        checkingAccountDTO.getMinimumBalance(),
                        checkingAccountDTO.getMonthlyMaintenanceFee(),
                        checkingAccountDTO.getBirthday()
                ));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Malformed Checking");
        }
    }
}
