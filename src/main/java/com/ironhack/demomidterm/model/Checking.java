package com.ironhack.demomidterm.model;

import com.ironhack.demomidterm.enums.Status;
import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;
import java.util.Optional;

@Entity
//@PrimaryKeyJoinColumn(name = "id")
public class Checking extends Account{
    private String secretKey;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency",column = @Column(name = "currency_minimumBalance")),
            @AttributeOverride(name = "amount",column = @Column(name = "amount_minimumBalance")),
    })
    //@DefaultValue("250")
    private Money minimumBalance;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency",column = @Column(name = "currency_monthlyMaintenanceFee")),
            @AttributeOverride(name = "amount",column = @Column(name = "amount_monthlyMaintenanceFee")),
    })
    private Money monthlyMaintenanceFee;
    private LocalDate creationDate;
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate birthday;

    public Checking() {
    }

    public Checking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, String secretKey, Money minimumBalance, Money monthlyMaintenanceFee, LocalDate birthday) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creationDate = LocalDate.now();
        this.status = Status.ACTIVE;
        this.birthday=birthday;
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
        if(minimumBalance.getAmount().compareTo(new BigDecimal(100)) == -1){
            this.minimumBalance = new Money(new BigDecimal(1000), Currency.getInstance("USD"));
        }
        else{
            this.minimumBalance = minimumBalance;
        }

    }

    public Money getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(Money monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
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

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
