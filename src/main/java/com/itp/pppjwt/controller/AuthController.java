package com.itp.pppjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itp.pppjwt.model.AuthenticationRequest;
import com.itp.pppjwt.model.AuthenticationResponse;
import com.itp.pppjwt.security.JwtUtil;
import com.itp.pppjwt.security.MyUserDetailsServiceNew;

@RestController
public class AuthController {

	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsServiceNew userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    
	@PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword())
        );

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(request.getUsername());

        String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
