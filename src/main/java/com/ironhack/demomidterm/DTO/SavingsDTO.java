package com.ironhack.demomidterm.DTO;

import com.ironhack.demomidterm.model.Money;
import lombok.Data;

@Data
public class SavingsDTO {
    private Money balance;
    private Long PrimaryOwner;
    private Long SecondaryOwner;
    private Money penaltyFee;
    private String secretKey;
    private Money minimumBalance;
    private Money interestRate;
}
