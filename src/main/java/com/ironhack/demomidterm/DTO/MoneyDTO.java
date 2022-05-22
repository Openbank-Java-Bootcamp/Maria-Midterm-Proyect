package com.ironhack.demomidterm.DTO;

import com.ironhack.demomidterm.model.Money;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class MoneyDTO {
    @NotNull
    private String currency;

    @NotNull
    private BigDecimal amount;

    public MoneyDTO() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }



    public Money toMoney(){
        return new Money(getAmount(), Currency.getInstance(getCurrency()));
    }


}
