package com.Interceptors.LogAndLegacyMiddleware_webApp.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/time")
public class BasicController {
    @GetMapping
    public LocalDateTime getlocalDateTime (){
        return LocalDateTime.now();
    }
}
