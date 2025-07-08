package io.github.jinseoplee.demos.ss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    // anyone can access
    @GetMapping("/")
    public String hello() {
        return "Hello!";
    }

    // user, manager, admin
    @GetMapping("/user")
    public String user(Principal principal) {
        return "Hello User, " + principal.getName();
    }

    // manager, admin
    @GetMapping("/manager")
    public String manager(Principal principal) {
        return "Hello Manager, " + principal.getName();
    }

    // admin
    @GetMapping("/admin")
    public String admin(Principal principal) {
        return "Hello Admin, " + principal.getName();
    }
}
