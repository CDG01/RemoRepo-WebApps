package com.example.demo.controllers;

import com.example.demo.services.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private MyService myService;
    Logger logger = LoggerFactory.getLogger(MyController.class);
    @GetMapping("/")
    public String welcome() {
        String mess = "Welcome guys";
        logger.info(mess);
        return mess;
    }
    @GetMapping("/exp")
    public int getExponent() {
        return myService.calcoloEsponente();
    }
    @GetMapping("/get-errors")
    public String getError() {
        String mess = "Error!";
        Error error = new Error("This is a error");
        logger.error("Error: " + error);
        return mess;
    }
}