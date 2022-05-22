package com.ironhack.demomidterm.controllers.impl;

import com.ironhack.demomidterm.controllers.interfaces.UserControllerInterface;
import com.ironhack.demomidterm.model.User;
import com.ironhack.demomidterm.services.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController implements UserControllerInterface {
    @Autowired
    private UserServiceInterface userService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
