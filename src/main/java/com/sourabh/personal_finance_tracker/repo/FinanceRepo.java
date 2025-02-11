package com.sourabh.personal_finance_tracker.repo;

import com.sourabh.personal_finance_tracker.dao.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FinanceRepo extends JpaRepository<Finance, Integer> {
}
