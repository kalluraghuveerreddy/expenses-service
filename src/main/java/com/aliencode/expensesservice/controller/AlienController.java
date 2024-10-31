package com.aliencode.expensesservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/humans")
public class AlienController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello Alien! Welcome to the Beautiful Land in the Universe ");
    }
}

