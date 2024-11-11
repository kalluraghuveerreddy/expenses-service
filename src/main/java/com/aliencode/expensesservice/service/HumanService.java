package com.aliencode.expensesservice.service;

import com.aliencode.expensesservice.dto.HumanDto;
import com.aliencode.expensesservice.dto.HumanRequestDto;

import java.util.List;

public interface HumanService {

    HumanDto addHuman(HumanRequestDto humanRequestDto);

    HumanDto getHuman(Long id);

    HumanDto updateHuman(HumanDto humanDto, Long id);

    void deleteHuman(Long id);

    List<HumanDto> getHumans();
}
