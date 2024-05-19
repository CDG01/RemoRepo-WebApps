package com.example.CDGSimpleWebApp.basicControllers;

import org.jetbrains.annotations.NotNull;

public class User {

    public User(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @NotNull
    public long id;

    @NotNull public String name;

    @NotNull public String surname;
}