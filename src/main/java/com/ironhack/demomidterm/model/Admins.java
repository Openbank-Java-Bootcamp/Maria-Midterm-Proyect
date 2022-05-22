package com.ironhack.demomidterm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.Collection;

@Entity
//@PrimaryKeyJoinColumn(name = "id")
public class Admins extends User{

    public Admins() {
    }

    public Admins(String name, String username, String password, Collection<Role> roles) {
        super(name, username, password, roles);
    }
}
