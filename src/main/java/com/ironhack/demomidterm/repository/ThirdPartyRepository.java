package com.ironhack.demomidterm.repository;

import com.ironhack.demomidterm.model.ThirdParty;
import com.ironhack.demomidterm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Long> {
}
