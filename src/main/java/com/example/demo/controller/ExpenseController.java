package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    public ExpenseRepository repo;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return repo.findAll();
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return repo.save(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        repo.deleteById(id);
    }

    // Add this method:
    @DeleteMapping
    public void deleteAllExpenses() {
        repo.deleteAll();
    }
}
