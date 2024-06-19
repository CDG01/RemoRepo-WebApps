package co.develhope.jwtExample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestProtectedController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, this is a protected endpoint!";
    }
}
