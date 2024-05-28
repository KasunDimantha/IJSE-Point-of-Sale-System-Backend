package com.example.POS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.POS.entity.User;

@Repository
public interface UserReposittory extends JpaRepository<User, Long>{
    
    Optional<User> findByUsername(String username);
}
