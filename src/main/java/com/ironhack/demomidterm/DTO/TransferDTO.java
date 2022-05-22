package com.ironhack.demomidterm.DTO;

import com.ironhack.demomidterm.model.Money;
import lombok.Data;

@Data
public class TransferDTO {
    private int id;
    private int id2;
    private Long primaryOwner;
    private String nameTransfer;
    private Money transferAmount;
}
