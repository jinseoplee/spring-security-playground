package io.github.jinseoplee.demos.ss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/public")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/private")
    public String authenticated() {
        return "Hello, authenticated user!";
    }
}
