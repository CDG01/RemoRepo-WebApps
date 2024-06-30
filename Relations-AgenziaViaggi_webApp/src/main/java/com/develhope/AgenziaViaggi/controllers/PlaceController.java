package com.develhope.AgenziaViaggi.controllers;

import com.develhope.AgenziaViaggi.entities.PlaceEntity;
import com.develhope.AgenziaViaggi.entities.UserEntity;
import com.develhope.AgenziaViaggi.repositories.BookingRepository;
import com.develhope.AgenziaViaggi.repositories.PlaceRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @PostMapping("/addPlace")
    public ResponseEntity<?> addPlace(@Valid @RequestBody PlaceEntity place, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        } else {
            PlaceEntity userSaved = placeRepository.save(place);
            return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
        }
    }
}
