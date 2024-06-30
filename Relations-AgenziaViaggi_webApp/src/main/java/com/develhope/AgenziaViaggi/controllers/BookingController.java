package com.develhope.AgenziaViaggi.controllers;

import com.develhope.AgenziaViaggi.DTO.BookingPlacesDTO;
import com.develhope.AgenziaViaggi.entities.BookingEntity;
import com.develhope.AgenziaViaggi.entities.PlaceEntity;
import com.develhope.AgenziaViaggi.entities.UserEntity;
import com.develhope.AgenziaViaggi.repositories.BookingRepository;
import com.develhope.AgenziaViaggi.repositories.PlaceRepository;
import com.develhope.AgenziaViaggi.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addBooking(@Valid @RequestBody BookingPlacesDTO bookingPlacesDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        } else {
            Optional<UserEntity> user = userRepository.findById(bookingPlacesDTO.getUserID());
            if (user.isPresent())
            {
                List<PlaceEntity> bookingPlaces = placeRepository.findAllById(bookingPlacesDTO.getPlacesID());
                if (!bookingPlaces.isEmpty()) {
                    BookingEntity booking = bookingRepository.save(
                            new BookingEntity(user.get(), bookingPlaces));
                    return ResponseEntity.status(HttpStatus.CREATED).body(booking);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tutti gli ids places che mi hai dato sono sbagliati!" +
                            " Coglione");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lo user ID che mi hai dato non è stato trovato");
            }
        }
    }
}
