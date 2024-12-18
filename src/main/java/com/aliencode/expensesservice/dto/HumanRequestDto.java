package com.aliencode.expensesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HumanRequestDto {
    private String name;
    private int age;
    private String username;
    private String email;
    private String gender;
    private String country;
    private String pinCode;
    private String state;
}
