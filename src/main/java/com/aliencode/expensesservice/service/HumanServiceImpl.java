package com.aliencode.expensesservice.service;

import com.aliencode.expensesservice.dto.HumanDto;
import com.aliencode.expensesservice.dto.HumanRequestDto;
import com.aliencode.expensesservice.entity.Human;
import com.aliencode.expensesservice.mapper.HumanMapper;
import com.aliencode.expensesservice.repository.HumanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HumanServiceImpl implements HumanService {
    private HumanRepository repository;

    @Override
    public HumanDto addHuman(HumanRequestDto humanRequestDto) {
        Optional<Human> optionalHumanObj = repository.findByEmail(humanRequestDto.getEmail());
        if (optionalHumanObj.isPresent()) {
            return HumanMapper.mapToHumanDto(optionalHumanObj.get());
        } else {
            Human human = repository.save(HumanMapper.mapToHuman(humanRequestDto));
            return HumanMapper.mapToHumanDto(human);
        }
    }

    @Override
    public HumanDto getHuman(Long id) {
        Human human = repository.findById(id).orElseThrow(() -> new RuntimeException("Human not found"));
        return HumanMapper.mapToHumanDto(human);
    }

    @Override
    public HumanDto updateHuman(HumanDto humanDto, Long id) {
        return null;
    }

    @Override
    public void deleteHuman(Long id) {
        Human existedHuman = repository.findById(id).orElseThrow(() -> new RuntimeException("Human Not Found"));
        repository.delete(existedHuman);

    }

    @Override
    public List<HumanDto> getHumans() {

        return repository.findAll()
                .stream()
                .map(human -> HumanMapper.mapToHumanDto(human))
                .collect(Collectors.toList());
    }
}
