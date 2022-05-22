package com.ironhack.demomidterm.repository;

import com.ironhack.demomidterm.model.Account;
import com.ironhack.demomidterm.model.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
}
