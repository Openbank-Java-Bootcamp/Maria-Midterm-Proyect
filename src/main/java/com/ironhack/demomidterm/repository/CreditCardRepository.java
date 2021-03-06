package com.ironhack.demomidterm.repository;

import com.ironhack.demomidterm.model.Checking;
import com.ironhack.demomidterm.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
}
