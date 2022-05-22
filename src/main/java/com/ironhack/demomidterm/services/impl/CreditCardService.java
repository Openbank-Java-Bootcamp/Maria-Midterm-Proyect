package com.ironhack.demomidterm.services.impl;

import com.ironhack.demomidterm.DTO.CreditCardDTO;
import com.ironhack.demomidterm.DTO.SavingsDTO;
import com.ironhack.demomidterm.model.CreditCard;
import com.ironhack.demomidterm.model.Savings;
import com.ironhack.demomidterm.repository.AccountHolderRepository;
import com.ironhack.demomidterm.repository.CheckingRepository;
import com.ironhack.demomidterm.repository.CreditCardRepository;
import com.ironhack.demomidterm.services.interfaces.CreditCardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class CreditCardService implements CreditCardServiceInterface {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    public CreditCard saveCreditCard(CreditCardDTO creditCardDTO) {
        if(creditCardDTO.getInterestRate().getAmount().compareTo(new BigDecimal("0.2")) > 0
                || creditCardDTO.getInterestRate().getAmount().compareTo(new BigDecimal("0.1")) < 0) {
            throw (new ResponseStatusException(HttpStatus.BAD_REQUEST, "Interest rate must be between 0.1 " + "and 0.2" ));
        }
        if(creditCardDTO.getCreditLimit().getAmount().compareTo(new BigDecimal("100000")) > 0 ||
                creditCardDTO.getCreditLimit().getAmount().compareTo(new BigDecimal("100")) < 0){
            throw (new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credit card limit must be between 100 and 100000"));
        }

        try {
            return creditCardRepository.save(new CreditCard(
                    creditCardDTO.getBalance(),
                    accountHolderRepository.findById(creditCardDTO.getPrimaryOwner()).get(),
                    accountHolderRepository.findById(creditCardDTO.getSecondaryOwner()).get(),
                    creditCardDTO.getPenaltyFee(),
                    creditCardDTO.getCreditLimit(),
                    creditCardDTO.getInterestRate()

            ));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Malformed CreditCard");
        }
    }
}
