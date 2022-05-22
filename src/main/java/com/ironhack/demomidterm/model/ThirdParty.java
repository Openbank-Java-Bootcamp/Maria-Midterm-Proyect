package com.ironhack.demomidterm.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

@Entity
//@PrimaryKeyJoinColumn(name = "id")
@Table(name = "third_party")
public class ThirdParty {
    /*@OneToMany(mappedBy = "third_party")
    private HashSet<Account> key;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hashKey;

    public ThirdParty() {
    }

    /*public ThirdParty(Long id, String name, HashSet<Account> key) {
        super(id, name);
        //this.key = key;
    }*/

    public ThirdParty( String key) {

        this.hashKey = key;
    }

    public String getKey() {
        return hashKey;
    }

    public void setKey(String key) {
        this.hashKey = key;
    }

}
