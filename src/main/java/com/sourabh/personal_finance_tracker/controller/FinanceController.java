package com.sourabh.personal_finance_tracker.controller;

import com.sourabh.personal_finance_tracker.dao.Finance;
import com.sourabh.personal_finance_tracker.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @GetMapping("/entries")
    public ResponseEntity<List<Finance>> getData(){
        List<Finance> data = financeService.getAllData();
        return new ResponseEntity<>(data, HttpStatus.CONFLICT);
    }

    @GetMapping("/entries/{id}")
    public ResponseEntity<Finance> getContact(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(financeService.getData(id), HttpStatus.OK);
    }

    @PostMapping("/entries")
    public ResponseEntity<Finance> createRecord(@RequestBody Finance data) {
        return new ResponseEntity<>(financeService.createRecord(data), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Finance> updateTransaction(@PathVariable Integer id, @RequestBody Finance data) {
        return ResponseEntity.ok(financeService.updateRecord(id, data));
    }

    @DeleteMapping("/entries/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Integer id) {
        financeService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}
