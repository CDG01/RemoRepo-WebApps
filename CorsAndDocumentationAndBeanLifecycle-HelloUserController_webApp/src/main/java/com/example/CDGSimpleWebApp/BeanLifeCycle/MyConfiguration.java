package com.example.CDGSimpleWebApp.BeanLifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean(name = "MyService",initMethod = "onInit", destroyMethod = "onDestroy")
    public MyService getService(){
        System.out.println("[getService][MyService]");
        return new MyService();
    }
}
