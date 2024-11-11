package com.aliencode.expensesservice.mapper;

import com.aliencode.expensesservice.dto.HumanDto;
import com.aliencode.expensesservice.dto.HumanRequestDto;
import com.aliencode.expensesservice.entity.Human;

public class HumanMapper {

    public static Human mapToHuman(HumanRequestDto humanRequestDto) {
        Human human = new Human();
        human.setName(humanRequestDto.getName());
        human.setAge(humanRequestDto.getAge());
        human.setGender(humanRequestDto.getGender());
        human.setEmail(humanRequestDto.getEmail());
        human.setUsername(humanRequestDto.getUsername());
        human.setCountry(humanRequestDto.getCountry());
        return human;
    }

    public static HumanDto mapToHumanDto(Human human) {
        HumanDto humanDto = new HumanDto();
        humanDto.setId(human.getId());
        humanDto.setName(human.getName());
        humanDto.setGender(human.getGender());
        humanDto.setEmail(human.getEmail());
        humanDto.setCountry(human.getCountry());
        humanDto.setUsername(human.getUsername());
        humanDto.setAge(human.getAge());
        return humanDto;
    }
}
