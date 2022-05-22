package com.ironhack.demomidterm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.engine.spi.Status;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Entity
//@PrimaryKeyJoinColumn(name = "id")
public class Savings extends Account{

    @NotEmpty(message = "Secret key field must not be empty")
    private String secretKey;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency",column = @Column(name = "currency_minimumBalance")),
            @AttributeOverride(name = "amount",column = @Column(name = "amount_minimumBalance"))
    })
    private Money minimumBalance;
    private LocalDate creationDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency",column = @Column(name = "currency_interestRate")),
            @AttributeOverride(name = "amount",column = @Column(name = "amount_interestRate"))
    })
    @NotNull
    private Money interestRate;

    public Savings() {
    }

    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, String secretKey, Money minimumBalance, Money interestRate) {
        super( balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = LocalDate.now();
        this.status = Status.SAVING;
        this.interestRate = interestRate;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Money getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Money interestRate) {
        this.interestRate = interestRate;
    }
}
