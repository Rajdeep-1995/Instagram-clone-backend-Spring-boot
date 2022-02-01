package com.instagramclone.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class Hello {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world!";
    }
}
