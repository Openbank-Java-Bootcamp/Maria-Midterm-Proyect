package com.ironhack.demomidterm.services.interfaces;

import com.ironhack.demomidterm.model.Role;
import com.ironhack.demomidterm.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
    UserDetails loadUserByUsername(String username);

}
