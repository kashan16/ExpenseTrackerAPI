package com.example.ExpenseAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExpenseAPI.Entity.User;

public interface UserRepository extends JpaRepository<User , Long>{
}
