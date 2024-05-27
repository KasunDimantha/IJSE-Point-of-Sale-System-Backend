package com.example.POS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.POS.entity.User;

public interface UserReposittory extends JpaRepository<User, Long>{
    
}
