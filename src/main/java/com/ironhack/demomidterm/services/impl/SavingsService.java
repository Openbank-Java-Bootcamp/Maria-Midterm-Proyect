package com.ironhack.demomidterm.services.impl;

import com.ironhack.demomidterm.DTO.SavingsDTO;
import com.ironhack.demomidterm.model.Money;
import com.ironhack.demomidterm.model.Savings;
import com.ironhack.demomidterm.model.StudentChecking;
import com.ironhack.demomidterm.repository.AccountHolderRepository;
import com.ironhack.demomidterm.repository.SavingsRepository;
import com.ironhack.demomidterm.services.interfaces.SavingsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class SavingsService implements SavingsServiceInterface {
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;




    public Savings saveSavings(SavingsDTO savingsDTO) {

        if(savingsDTO.getInterestRate().getAmount().compareTo(new BigDecimal("0.5")) > 0){
            throw (new ResponseStatusException(HttpStatus.BAD_REQUEST, "Interest rate must be lower than 0.5"));
        }
        if(savingsDTO.getMinimumBalance().getAmount().compareTo(new BigDecimal("100")) < 0
                || savingsDTO.getMinimumBalance().getAmount().compareTo(new BigDecimal("1000")) > 0){
            throw (new ResponseStatusException(HttpStatus.BAD_REQUEST, "Savings account minimum balance must be between 100-1000"));
        }

       try {
            return savingsRepository.save(new Savings(
                    savingsDTO.getBalance(),
                    accountHolderRepository.findById(savingsDTO.getPrimaryOwner()).get(),
                    accountHolderRepository.findById(savingsDTO.getSecondaryOwner()).get(),
                    savingsDTO.getPenaltyFee(),
                    savingsDTO.getSecretKey(),
                    savingsDTO.getMinimumBalance(),
                    savingsDTO.getInterestRate()

            ));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Malformed Savings");
        }
    }


}
