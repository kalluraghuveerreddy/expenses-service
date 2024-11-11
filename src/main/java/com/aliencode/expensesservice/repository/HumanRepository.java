package com.aliencode.expensesservice.repository;

import com.aliencode.expensesservice.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<Human, Long> {
}
