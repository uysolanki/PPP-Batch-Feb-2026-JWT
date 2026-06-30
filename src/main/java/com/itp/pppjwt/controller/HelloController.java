package com.itp.pppjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/read")
    public String welcome() {
        return "Access to both ADMIN & USER";
    }

    @GetMapping("/remove")
    public String greet() {
        return "Access only for Admin";
    }

}
