package com.Interceptors.MonthMiddleware_webApp.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping
    public String greetings() {
        return "Welcome to the Month Service!";
    }

}