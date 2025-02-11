package com.sourabh.personal_finance_tracker.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinanceData {
    @Id
    private int id;
    private int amount;
    private String category;
    private String date;
    private String description;
}
