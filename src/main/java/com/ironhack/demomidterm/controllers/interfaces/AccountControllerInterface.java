package com.ironhack.demomidterm.controllers.interfaces;

import com.ironhack.demomidterm.DTO.AccountDTO;
import com.ironhack.demomidterm.DTO.BalanceDTO;
import com.ironhack.demomidterm.DTO.TransferDTO;
import com.ironhack.demomidterm.model.Account;
import com.ironhack.demomidterm.model.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AccountControllerInterface {
    public List<Account> getAccounts();
    public Account getAccount(Integer id);
    //public void storeAccount(AccountDTO accountDTO);
    public void updateAccount(int id, BalanceDTO balanceDTO);
    public void makeTransaction(TransferDTO transferDTO);
    public void deleteAccount(int id);
}
