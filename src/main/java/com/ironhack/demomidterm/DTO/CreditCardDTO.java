package com.ironhack.demomidterm.DTO;

import com.ironhack.demomidterm.model.Money;
import lombok.Data;

@Data
public class CreditCardDTO {
    private Money balance;
    private Long PrimaryOwner;
    private Long SecondaryOwner;
    private Money penaltyFee;
    private Money creditLimit;
    private Money interestRate;
}
