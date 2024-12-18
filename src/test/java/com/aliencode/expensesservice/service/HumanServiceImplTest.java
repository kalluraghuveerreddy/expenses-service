package com.aliencode.expensesservice.service;

import com.aliencode.expensesservice.dto.HumanDto;
import com.aliencode.expensesservice.dto.HumanRequestDto;
import com.aliencode.expensesservice.entity.Human;
import com.aliencode.expensesservice.repository.HumanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HumanServiceImplTest {

    @Mock
    private HumanRepository repository;

    @InjectMocks
    private HumanServiceImpl humanServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddHuman_whenHumanExists() {
        // Arrange
        HumanRequestDto requestDto = new HumanRequestDto();
        requestDto.setEmail("test@example.com");

        Human existingHuman = new Human();
        existingHuman.setEmail("test@example.com");

        when(repository.findByEmail("test@example.com")).thenReturn(Optional.of(existingHuman));

        // Act
        HumanDto result = humanServiceImpl.addHuman(requestDto);

        // Assert
        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
        verify(repository, never()).save(any(Human.class));
    }

    @Test
    void testAddHuman_whenHumanDoesNotExist() {
        // Arrange
        HumanRequestDto requestDto = new HumanRequestDto();
        requestDto.setEmail("new@example.com");

        Human newHuman = new Human();
        newHuman.setEmail("new@example.com");

        when(repository.findByEmail("new@example.com")).thenReturn(Optional.empty());
        when(repository.save(any(Human.class))).thenReturn(newHuman);

        // Act
        HumanDto result = humanServiceImpl.addHuman(requestDto);

        // Assert
        assertNotNull(result);
        assertEquals("new@example.com", result.getEmail());
        verify(repository).save(any(Human.class));
    }
}
