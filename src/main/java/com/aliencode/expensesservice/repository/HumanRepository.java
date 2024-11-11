package com.aliencode.expensesservice.repository;

import com.aliencode.expensesservice.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HumanRepository extends JpaRepository<Human, Long> {
    Optional<Human> findByEmail(String email);
}
