package com.ironhack.demomidterm.controllers.impl;

import com.ironhack.demomidterm.DTO.CheckingAccountDTO;
import com.ironhack.demomidterm.DTO.StudentCheckingDTO;
import com.ironhack.demomidterm.controllers.interfaces.StudentCheckingControllerInterface;
import com.ironhack.demomidterm.model.Checking;
import com.ironhack.demomidterm.model.StudentChecking;
import com.ironhack.demomidterm.services.interfaces.CheckingServiceInterface;
import com.ironhack.demomidterm.services.interfaces.StudentCheckingServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentCheckingController implements StudentCheckingControllerInterface {
    @Autowired
    private StudentCheckingServiceInterface studentCheckingServiceInterface;

    @PostMapping("/studentCheckings")
    @ResponseStatus(HttpStatus.CREATED)
    public void storeStudentChecking(@RequestBody @Valid CheckingAccountDTO studentCheckingDTO){
        studentCheckingServiceInterface.saveStudentChecking(studentCheckingDTO);
    }
}
