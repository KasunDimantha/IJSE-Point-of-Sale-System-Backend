package com.example.POS.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.POS.entity.User;
import com.example.POS.repository.UserReposittory;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private UserReposittory userReposittory;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userReposittory.findByUsername(username).orElse(null);

        if( user == null ) {
            throw new UsernameNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
