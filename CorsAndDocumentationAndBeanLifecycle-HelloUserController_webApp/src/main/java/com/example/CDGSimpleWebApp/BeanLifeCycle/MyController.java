package com.example.CDGSimpleWebApp.BeanLifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController implements DisposableBean, InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[afterPropertiesSet]");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[Destroy]");
    }

    @PostConstruct
    public void PostConstruct() {
        System.out.println("[PostConstruct]");
    }

    @PreDestroy
    public void PreDestroy() {
        System.out.println("[PreDestroy]");
    }

    @GetMapping
    public void get() {

    }
}
