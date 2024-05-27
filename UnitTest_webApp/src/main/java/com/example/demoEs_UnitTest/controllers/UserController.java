package com.example.demoEs_UnitTest.controllers;

import com.example.demoEs_UnitTest.entities.User;
import com.example.demoEs_UnitTest.models.DTO.UserDTO;
import com.example.demoEs_UnitTest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User user=  userService.findById(id);
        if(user != null){
            return user;
        }else{
            return null;
        }
    }
    @GetMapping("/list")
    public List<User> findAll(){
        return userService.findALl();
    }
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDTO user){
        if(user != null){
            return userService.updateUser(id,user);
        }else{
            return null;
        }
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "Utente " + id + " cancellato";
    }
}
