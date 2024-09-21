package com.example.ExpenseAPI.Service;

import java.util.List;

import com.example.ExpenseAPI.DTO.ExpenseDTO;
import com.example.ExpenseAPI.Entity.Expense;

public interface ExpenseService {
    Expense postExpense(ExpenseDTO expenseDto);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense updateExpense(Long id , ExpenseDTO expenseDto);
    void deleteExpense(Long id);
}
