package com.example.demo.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    Logger logger = LoggerFactory.getLogger(MyService.class);

    @Value("${custom.num1}")
    private int num1;

    @Value("${custom.num2}")
    private int num2;

    public int calcoloEsponente() {
        logger.info("Inizio calcolo dell' esponente: ");
        int risultato = (int) Math.pow(num1, num2);
        logger.info("Risultato fine calcolo dell' esponente: " , risultato);
        return risultato;
    }
}