package com.aliencode.expensesservice.service;

import com.aliencode.expensesservice.dto.HumanDto;
import com.aliencode.expensesservice.dto.HumanRequestDto;
import com.aliencode.expensesservice.entity.Human;
import com.aliencode.expensesservice.mapper.HumanMapper;
import com.aliencode.expensesservice.repository.HumanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HumanServiceImpl implements HumanService {
    private HumanRepository repository;

    @Override
    public HumanDto addHuman(HumanRequestDto humanRequestDto) {
       Optional<Human> optionalHumnaObj=repository.findById(humanRequestDto.getId());
        if(optionalHumnaObj.isPresent()){
        Human human = repository.save(HumanMapper.mapToHuman(humanRequestDto));
        return HumanMapper.mapToHumanDto(human);
        }else{
            return null;
        }
    }

    @Override
    public HumanDto getHuman(Long id) {
        return null;
    }

    @Override
    public HumanDto updateHuman(HumanDto humanDto, Long id) {
        return null;
    }

    @Override
    public void deleteHuman(Long id) {

    }

    @Override
    public List<HumanDto> getHumans() {
        return List.of();
    }
}
