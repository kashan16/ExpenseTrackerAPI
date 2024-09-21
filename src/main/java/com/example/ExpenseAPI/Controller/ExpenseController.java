package com.example.ExpenseAPI.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpenseAPI.DTO.ExpenseDTO;
import com.example.ExpenseAPI.Entity.Expense;
import com.example.ExpenseAPI.Service.ExpenseService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<?> postExpense(@RequestBody ExpenseDTO dto) {
        Expense createdExpense = expenseService.postExpense(dto);
        if(createdExpense != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllExpense() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExpenseById(@PathVariable Long id)  {
        try {
            return ResponseEntity.ok(expenseService.getExpenseById(id));
        } catch(EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable Long id , @RequestBody ExpenseDTO expenseDTO) {
        try {
            return ResponseEntity.ok(expenseService.updateExpense(id, expenseDTO));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        try{
            expenseService.deleteExpense(id);
            return ResponseEntity.ok("Expense deleted");
        } catch (EntityNotFoundException e) { 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
