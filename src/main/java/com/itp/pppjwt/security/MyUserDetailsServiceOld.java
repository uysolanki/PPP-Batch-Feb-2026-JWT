package com.itp.pppjwt.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServiceOld implements UserDetailsService {

    private final Map<String, UserDetails> users = new HashMap<>();

    public MyUserDetailsServiceOld() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        users.put("alice@gmail.com",
                User.builder()
                        .username("alice@gmail.com")
                        .password(encoder.encode("alice123"))
                        .authorities("ADMIN")
                        .build());

        users.put("ben@gmail.com",
                User.builder()
                        .username("ben@gmail.com")
                        .password(encoder.encode("ben123"))
                        .authorities("USER")
                        .build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        UserDetails user = users.get(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}