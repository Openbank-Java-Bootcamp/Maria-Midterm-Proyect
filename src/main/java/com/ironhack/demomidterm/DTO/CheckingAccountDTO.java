package com.ironhack.demomidterm.DTO;

import com.ironhack.demomidterm.model.Money;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.engine.spi.Status;

import java.time.LocalDate;

@Data
public class CheckingAccountDTO {
    private Money balance;
    private Long PrimaryOwner;
    private Long SecondaryOwner;
    private Money penaltyFee;
    private String secretKey;
    private Money minimumBalance;
    private Money monthlyMaintenanceFee;
    private LocalDate birthday;

}
