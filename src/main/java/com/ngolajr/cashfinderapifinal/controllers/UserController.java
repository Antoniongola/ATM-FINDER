package com.ngolajr.cashfinderapifinal.controllers;

import com.ngolajr.cashfinderapifinal.dto.LoginRequest;
import com.ngolajr.cashfinderapifinal.entities.User;
import com.ngolajr.cashfinderapifinal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("**")
@RequestMapping(path = "/api", produces = "application/json")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest login){
        if(service.login(login) != null)
            return ResponseEntity.ok(service.login(login));

        return ResponseEntity.ok(null);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> cadastro(@RequestBody User user){
        if(service.criarConta(user) != null)
            return ResponseEntity.ok(service.criarConta(user));

        return ResponseEntity.ok(null);
    }
}
