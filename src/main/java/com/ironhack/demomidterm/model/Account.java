package com.ironhack.demomidterm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

@Entity
//@DiscriminatorColumn(name = "CHILD_TYPE", discriminatorType = DiscriminatorType.INTEGER)
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    private Integer accountId;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency",column = @Column(name = "currency_balance")),
            @AttributeOverride(name = "amount",column = @Column(name = "amount_balance"))
    })
    private Money balance;
    @ManyToOne
    @JoinColumn(name = "primary_owner")
    @NotNull(message = "Primary Owner field must not be empty")
    private AccountHolder PrimaryOwner;
    @ManyToOne
    @JoinColumn(name = "secondary_owner")
    private AccountHolder SecondaryOwner;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency",column = @Column(name = "currency_penaltyFee")),
            @AttributeOverride(name = "amount",column = @Column(name = "amount_penaltyFee"))
    })
    private Money penaltyFee;

    /*@OneToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name= "user_id", referencedColumnName = "id")
    private User user;*/

    /*@ManyToOne
    @JoinColumn(name = "id")
    private AccountHolder accountHolders;*/

    /*@ManyToOne
    @JoinColumn(name = "third_party_id")
    private ThirdParty thirdParty;*/


    public Account() {
    }

    public Account(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee) {
        //this.id=id;
        this.balance = balance;
        this.PrimaryOwner = primaryOwner;
        this.SecondaryOwner = secondaryOwner;
        this.penaltyFee = penaltyFee;
    }


    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return PrimaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        PrimaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return SecondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        SecondaryOwner = secondaryOwner;
    }

    public Money getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(Money penaltyFee) {
        this.penaltyFee = penaltyFee;
    }
}
