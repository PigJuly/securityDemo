package com.security.demo.controller;

import com.security.demo.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserImpl userImpl;

    @PostMapping("/auth/login")
    public ResponseEntity auth() {
        String token=userImpl.login("17748789039","123");
       return ResponseEntity.ok(token);
    }
}
