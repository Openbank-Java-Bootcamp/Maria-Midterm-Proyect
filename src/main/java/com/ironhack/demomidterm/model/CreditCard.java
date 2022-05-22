package com.ironhack.demomidterm.model;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
//@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Account{

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency",column = @Column(name = "currency_creditLimit")),
            @AttributeOverride(name = "amount",column = @Column(name = "amount_creditLimit"))
    })
    private Money creditLimit;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency",column = @Column(name = "currency_interestRate")),
            @AttributeOverride(name = "amount",column = @Column(name = "amount_interestRate"))
    })
    private Money interestRate;

    public CreditCard() {
    }

    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, Money creditLimit, Money interestRate) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public Money getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Money getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Money interestRate) {
        this.interestRate = interestRate;
    }
}
