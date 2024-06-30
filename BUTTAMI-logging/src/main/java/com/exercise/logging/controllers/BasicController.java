package com.exercise.logging.controllers;

import com.exercise.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logging")
public class BasicController {

    private final BasicService basicService;

    @Autowired
    public BasicController(BasicService basicService) {
        this.basicService = basicService;
    }

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/")
    public String getGreeting() {
        String welcomeMessage = "Welcome!";
        logger.info(welcomeMessage);
        return welcomeMessage;
    }

    @GetMapping("/exp")
    public double calculatePower() {
        return basicService.doPowerOfTwoInt();
    }

    @GetMapping("/get-errors")
    public void getErrors() throws Exception {
        Error error = new Error("My custom error");
        logger.error(error.getMessage(), error);
        throw error;
    }

}
