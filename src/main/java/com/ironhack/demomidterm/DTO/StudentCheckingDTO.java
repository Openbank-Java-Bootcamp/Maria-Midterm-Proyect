package com.ironhack.demomidterm.DTO;

import com.ironhack.demomidterm.model.Money;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentCheckingDTO {
    private Money balance;
    private Long PrimaryOwner;
    private Long SecondaryOwner;
    private Money penaltyFee;
    private String secretKey;
    private LocalDate birthday;

}