package com.ironhack.demomidterm.services.impl;

import com.ironhack.demomidterm.DTO.BalanceDTO;
import com.ironhack.demomidterm.DTO.TransferDTO;
import com.ironhack.demomidterm.model.*;
import com.ironhack.demomidterm.repository.*;
import com.ironhack.demomidterm.services.interfaces.AccountServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService implements AccountServiceInterface {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private StudentCheckingRepository studentCheckingRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private CheckingService checkingService;
    @Autowired
    private TransferFundsRepository transferFundsRepository;
    @Autowired
    private UserRepository userRepository;


    public Account getAccountById(Integer id) {
        Optional<Account> foundAuthor = accountRepository.findById(id);
        if (foundAuthor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Account found with that ID");
        } else {
            return foundAuthor.get();
        }
    }


    public void update(int id, BalanceDTO balanceDTO) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            try {
                account.get().setBalance(balanceDTO.getBalance());
                accountRepository.save(account.get());
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Balance not valid.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The accountId doesn't exist.");
        }
    }

    public void transferFunds(TransferDTO transferDTO) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username= null;
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            username=authentication.getName();
        }
        User user=userRepository.findByUsername(username);
        Long accountHolderId = user.getId();
        Account account1=accountRepository.findById(transferDTO.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No Account Id found"));
        if(!account1.getPrimaryOwner().getId().equals(accountHolderId) && (account1.getSecondaryOwner() == null)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The account has another owner");
        }
        Account account2=accountRepository.findById(transferDTO.getId2()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No Account Id found"));
        if(!account2.getPrimaryOwner().getName().equals(transferDTO.getNameTransfer()) && (account2.getSecondaryOwner() == null)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The owner does not exit");
        }
        else{
            BigDecimal newBalance=account1.getBalance().getAmount();
            BigDecimal amountTransfer=transferDTO.getTransferAmount().getAmount();
            if(!(account1 instanceof CreditCard) && newBalance.compareTo(amountTransfer) == -1){
                throw new ResponseStatusException(HttpStatus.FORBIDDEN,"You have reached your credit limit");
            }
            else{
                account1.setBalance(new Money(newBalance.subtract(transferDTO.getTransferAmount().getAmount())));
                account2.setBalance(new Money(account2.getBalance().getAmount().add(transferDTO.getTransferAmount().getAmount())));
            }
        }

    }

    public void delete(int id) {
        Optional<Account> accountFromDB = accountRepository.findById(id);
        if(accountFromDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account not found");
        } else {
            accountRepository.delete(accountFromDB.get());
        }
    }
}
