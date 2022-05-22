package com.ironhack.demomidterm.services.interfaces;

import com.ironhack.demomidterm.DTO.AccountDTO;
import com.ironhack.demomidterm.DTO.BalanceDTO;
import com.ironhack.demomidterm.DTO.TransferDTO;
import com.ironhack.demomidterm.model.Account;

public interface AccountServiceInterface {
    public Account getAccountById(Integer id);
    //public Account saveAccount(Account account);
    //public Account create(AccountDTO accountDTO);
    public void update(int id, BalanceDTO balanceDTO);
    public void transferFunds(TransferDTO transferDTO);
    public void delete(int id);
}
