package com.ironhack.demomidterm.DTO;

import com.ironhack.demomidterm.model.AccountHolder;
import com.ironhack.demomidterm.model.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class AccountDTO {

    private Integer id;
    private Money balance;
    private Long PrimaryOwner;
    //private Long SecondaryOwner;
    //private Money penaltyFee;
    //private String accountType;
}