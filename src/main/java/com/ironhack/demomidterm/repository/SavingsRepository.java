package com.ironhack.demomidterm.repository;

import com.ironhack.demomidterm.model.Savings;
import com.ironhack.demomidterm.model.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Integer> {
}
