package com.example.ExpenseAPI.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ExpenseAPI.DTO.ExpenseDTO;
import com.example.ExpenseAPI.Entity.Expense;
import com.example.ExpenseAPI.Repository.ExpenseRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceIMPL implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    public Expense postExpense(ExpenseDTO expenseDTO) {
    
        Expense expense = new Expense();
        expense.setTitle(expenseDTO.getTitle());
        expense.setDescription(expenseDTO.getDescription());
        expense.setCategory(expenseDTO.getCategory());
        expense.setAmount(expenseDTO.getAmount());

        return expenseRepository.save(expense);
    }



    private Expense saveOrUpdate(Expense expense , ExpenseDTO expenseDTO) {
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());

        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll().stream().sorted(Comparator.comparing(Expense::getDate).reversed()).collect(Collectors.toList());
    }

    public Expense updateExpense(Long id , ExpenseDTO expenseDTO) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return saveOrUpdate(optionalExpense.get(), expenseDTO);
        } else {
            throw new EntityNotFoundException("Expense with id " + id + " not found");
        }
    }

    public Expense getExpenseById(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            throw new EntityNotFoundException("Expense with id " + id + " not found");
        }
    }

    public void deleteExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            expenseRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Expense with id " + id + " not found");
        }
    }
}
