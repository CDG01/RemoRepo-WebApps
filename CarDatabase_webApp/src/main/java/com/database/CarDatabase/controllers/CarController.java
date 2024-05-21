package com.database.CarDatabase.controllers;


import com.database.CarDatabase.entities.Car;
import com.database.CarDatabase.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @PostMapping
    public Car create (@RequestBody Car car){
        Car newCar = carRepository.saveAndFlush(car);
        return newCar;
    }
    @GetMapping
    public List<Car> getAll(){
        List<Car> cars = carRepository.findAll();
        return cars;
    }
    @GetMapping("/{id}")
    public Car findById(@PathVariable long id){
        Car car = new Car();
        if(carRepository.existsById(id)){
            car = carRepository.getById(id);
            return car;
        }else{
            return car;
        }
        /* ALTERNATIVA:
            @GetMapping("/{id}")
            public Car getCarById(@PathVariable Long id) {
            Optional<Car> optionalCar = carRepository.findById(id);
            return optionalCar.orElse(new Car());
            }
        */
    }
    @PatchMapping("/{id}")
    public Car updateType(@PathVariable long id, @RequestParam String type){
        if(carRepository.existsById(id)) {
            Car car = new Car();
            car = carRepository.getById(id);
            car.setType(type);
            Car updatedCar = carRepository.saveAndFlush(car);
            return updatedCar;
        }else{
            Car nullCar = new Car();
            return nullCar;
        }

        /* ALTERNATIVA:
            @PatchMapping("/{id}")
            public Car updateCarType(@PathVariable Long id, @RequestParam String type) {
            Optional<Car> optionalCar = carRepository.findById(id);
            if (optionalCar.isPresent()) {
                Car car = optionalCar.get();
                car.setType(type);
                return carRepository.save(car);
            } else {
                return new Car();
                }
            }
        */
    }

    @PutMapping("/{id}")
    public Car updateType(@PathVariable long id, @RequestBody Car car) {
        if (carRepository.existsById(id)) {
            car.setId(id);
            Car updatedCar = carRepository.saveAndFlush(car);
            return updatedCar;
        } else {
            Car nullCar = new Car();
            return nullCar;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id){
        if(carRepository.existsById(id)) {
            carRepository.deleteById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        carRepository.deleteAll();
    }
}
