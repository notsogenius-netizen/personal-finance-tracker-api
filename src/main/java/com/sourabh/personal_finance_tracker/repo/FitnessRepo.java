package com.sourabh.personal_finance_tracker.repo;

import com.sourabh.personal_finance_tracker.dao.FinanceData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FitnessRepo extends JpaRepository<FinanceData, Integer> {
    Optional<FinanceData> findById(Integer id);
}
