package com.aliencode.expensesservice.controller;

import com.aliencode.expensesservice.dto.HumanDto;
import com.aliencode.expensesservice.dto.HumanRequestDto;
import com.aliencode.expensesservice.service.HumanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/humans")
@AllArgsConstructor
public class HumanController {

    private HumanService humanService;

    @PostMapping("/add")
    public ResponseEntity<HumanDto> addHuman(@RequestBody HumanRequestDto humanRequestDto) {
        HumanDto humanDto = humanService.addHuman(humanRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(humanDto);
    }
}
