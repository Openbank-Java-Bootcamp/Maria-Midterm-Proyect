package com.ironhack.demomidterm.model;

import jakarta.persistence.*;
import org.hibernate.engine.spi.Status;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Entity
//@PrimaryKeyJoinColumn(name = "id")
public class StudentChecking extends Account{
    private String secretKey;
    private LocalDate creationDate;
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate birthday;

    public StudentChecking() {
    }

    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, String secretKey, LocalDate birthday) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.creationDate = LocalDate.now();
        this.status = Status.SAVING;
        this.birthday=birthday;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
