package com.sourabh.personal_finance_tracker.service;

import com.sourabh.personal_finance_tracker.dao.Finance;
import com.sourabh.personal_finance_tracker.repo.FinanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceService {
    @Autowired
    private FinanceRepo financeRepo;

    public List<Finance> getAllData(){
        return financeRepo.findAll();
    }

    public Integer getSummary(){
        return financeRepo.findAll().stream().mapToInt(Finance::getAmount).sum();
    }

    public Finance getData(Integer id){
        return financeRepo.findById(id).orElseThrow(()-> new RuntimeException("Not found!!"));
    }

    public Finance createRecord(Finance data){
        return financeRepo.save(data);
    }

    public Finance updateRecord(Integer id,Finance updatedData){
        return financeRepo.findById(id).map(data -> {
            data.setAmount(updatedData.getAmount());
            data.setCategory(updatedData.getCategory());
            data.setDate(updatedData.getDate());
            data.setDescription(updatedData.getDescription());
            return financeRepo.save(data);
        }).orElseThrow(() -> new RuntimeException("Data not found!"));
    }

    public void deleteRecord(Integer id) {
        financeRepo.deleteById(id);
    }
}
