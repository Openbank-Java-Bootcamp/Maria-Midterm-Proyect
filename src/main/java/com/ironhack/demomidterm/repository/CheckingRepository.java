package com.ironhack.demomidterm.repository;

import com.ironhack.demomidterm.model.Account;
import com.ironhack.demomidterm.model.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Integer> {
}
