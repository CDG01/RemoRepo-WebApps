package com.example.CDGSimpleWebApp.BeanLifeCycle;

public class MyService {

    public void onInit(){
        System.out.println("onInit");
    }

    public void onDestroy(){
        System.out.println("onDestroy");
    }
}