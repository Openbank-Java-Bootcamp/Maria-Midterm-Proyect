package com.ironhack.demomidterm.controllers.impl;

import com.ironhack.demomidterm.DTO.AccountDTO;
import com.ironhack.demomidterm.DTO.BalanceDTO;
import com.ironhack.demomidterm.DTO.TransferDTO;
import com.ironhack.demomidterm.controllers.interfaces.AccountControllerInterface;
import com.ironhack.demomidterm.model.Account;
import com.ironhack.demomidterm.model.User;
import com.ironhack.demomidterm.repository.AccountRepository;
import com.ironhack.demomidterm.services.interfaces.AccountServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController implements AccountControllerInterface {

    @Autowired
    private AccountServiceInterface accountServiceInterface;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccount(@PathVariable Integer id){
        return accountServiceInterface.getAccountById(id);
    }


    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccount(@PathVariable int id, @RequestBody @Valid BalanceDTO balanceDTO) {
        accountServiceInterface.update(id, balanceDTO);
    }

    @PostMapping("/transactions")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void makeTransaction(@RequestBody @Valid TransferDTO transferDTO){
        accountServiceInterface.transferFunds(transferDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable int id){
        accountServiceInterface.delete(id);
    }

}
