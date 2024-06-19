package com.Random.Airport_webApp.controllers;


import com.Random.Airport_webApp.entities.Flight;
import com.Random.Airport_webApp.entities.Status;
import com.Random.Airport_webApp.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flightsFound = flightService.getAll();
        return ResponseEntity.ok().body(flightsFound);
    }

    @PostMapping("/50Flight")
    public ResponseEntity<List<Flight>> creates50Flights() {
        List<Flight> flights = flightService.create50Flights();
        return ResponseEntity.ok().body(flights);
    }

    @PostMapping()
    public ResponseEntity<List<Flight>> createNFlights(@RequestParam(name = "flightsNumber", defaultValue = "100") int n) {
        List<Flight> flights = this.flightService.createNFlights(n);
        return ResponseEntity.ok().body(flights);
    }

    @GetMapping("/pagedAndOrderedByFromAirport_CustomQuery")
    public ResponseEntity<Page<Flight>> getFlightPagedAndOrderedByFromAirport_CustomQuery(@RequestParam(name = "page", defaultValue = "1") int page,
                                                       @RequestParam(name = "size", defaultValue = "5") int size) {
        Page<Flight> flightPaged = this.flightService.getFlightPagedAndOrderedByFromAirport_CustomQuery(page, size);
        return ResponseEntity.ok().body(flightPaged);
    }

    @GetMapping("/pagedAndOrdered")
    public ResponseEntity<Page<Flight>> getFlights(@RequestParam int page, @RequestParam int size) {
        Page<Flight> flightPagedAndOrdered = this.flightService.getFlightPagedAndOrdered(page, size);
        return ResponseEntity.ok().body(flightPagedAndOrdered);
    }


    @GetMapping("/byStatus")
    public ResponseEntity<List<Flight>> getFlightByStatus(@RequestParam(name = "status") Status status) {
        List<Flight> flightsFound = this.flightService.getFlightByStatus(status);
        return ResponseEntity.ok().body(flightsFound);
    }

    @GetMapping("/ontime")
    public List<Flight> getOnTimeFlights() {
        return flightService.getOnTimeFlights();
    }

    @GetMapping("/byTwoStatus_v1")
    public ResponseEntity<List<Flight>> getFlightByTwoStatuses_v1(@RequestParam(name = "p1") Status status1,
                                                               @RequestParam(name = "p2") Status status2) {
        List<Flight> flightsFound = this.flightService.getFlightByTwoStatuses_v1(status1, status2);
        return ResponseEntity.ok().body(flightsFound);
    }

    @GetMapping("/byTwoStatus_v2")
    public ResponseEntity<List<Flight>> getFlightByTwoStatuses_v2(@RequestParam Status p1, @RequestParam Status p2) {
        List<Flight> flightsFound = this.flightService.getFlightByTwoStatuses_v2(p1, p2);
        return ResponseEntity.ok().body(flightsFound);
    }

    @GetMapping("/byTwoStatus_generic")
    public ResponseEntity<List<Flight>> getFlightByTwoStatuses_generic(@RequestParam(value="status") List<Status> statuses) {
        List<Flight> flightsFound = flightService.getFlightByTwoStatuses_generic(statuses);
        return ResponseEntity.ok().body(flightsFound);
    }

    @GetMapping("/byTwoStatus_CustomQuery")
    public ResponseEntity<List<Flight>> getFlightByTwoStatuses_CustomQuery(@RequestParam Status p1, @RequestParam Status p2) {
        List<Flight> flightsFound = this.flightService.getFlightByTwoStatuses_CustomQuery(p1, p2);
        return ResponseEntity.ok().body(flightsFound);
    }

}
