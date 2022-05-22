package com.ironhack.demomidterm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class TransferFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id2;
    @OneToOne
    @JoinColumn(name = "primary_owner_id")
    private AccountHolder primaryOwner;

    private String nameTransfer;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency",column = @Column(name = "currency_transferAmount")),
            @AttributeOverride(name = "amount",column = @Column(name = "amount_transferAmount"))
    })
    @NotNull
    private Money transferAmount;

    public TransferFund() {
    }

    public TransferFund(int id2, AccountHolder primaryOwner, String nameTransfer, Money transferAmount) {
        this.id2 = id2;
        this.primaryOwner = primaryOwner;
        this.nameTransfer = nameTransfer;
        this.transferAmount = transferAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public String getNameTransfer() {
        return nameTransfer;
    }

    public void setNameTransfer(String nameTransfer) {
        this.nameTransfer = nameTransfer;
    }

    public Money getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Money transferAmount) {
        this.transferAmount = transferAmount;
    }
}
