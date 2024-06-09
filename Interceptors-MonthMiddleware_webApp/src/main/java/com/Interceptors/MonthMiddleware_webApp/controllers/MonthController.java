package com.Interceptors.MonthMiddleware_webApp.controllers;



import com.Interceptors.MonthMiddleware_webApp.entities.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping
    public Month getMonth(@RequestAttribute("monthAttribute") Month month) {
        return month;
    }

}