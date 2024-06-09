package com.Random.Airport_webApp.services;


import com.Random.Airport_webApp.entities.Flight;
import com.Random.Airport_webApp.entities.Status;
import com.Random.Airport_webApp.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    public List<Flight> create50Flights() {
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            Flight newFlight = new Flight(generateRandomString(random),
                    generateRandomString(random),
                    generateRandomString(random),
                    Status.ONTIME);
            flights.add(newFlight);
        }
        return flightRepository.saveAll(flights);
    }

    public List<Flight> createNFlights(int n) {
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            Flight flight = new Flight(
                    generateRandomString(random),
                    generateRandomString(random),
                    generateRandomString(random),
                    generateRandomStatus(random));
            flights.add(flight);
        }

        return flightRepository.saveAllAndFlush(flights);
    }

    public Page<Flight> getFlightPagedAndOrderedByFromAirport_CustomQuery(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return flightRepository.customQuery_getFlightsPagedAndOrderedByFromAirport(pageable);
    }

    public Page<Flight> getFlightPagedAndOrdered(int page, int size) {
        return flightRepository.findAll(PageRequest.of(page, size, Sort.by("fromAirport").ascending()));
    }


    public List<Flight> getFlightByStatus(Status status) {
        return this.flightRepository.findByStatus(status);
    }

    public List<Flight> getOnTimeFlights() {
        return flightRepository.findByStatus(Status.ONTIME);
    }

    public List<Flight> getFlightByTwoStatuses_v1(Status status1, Status status2) {
        return this.flightRepository.findByStatusOrStatus(status1, status2);
    }

    public List<Flight> getFlightByTwoStatuses_v2( Status p1, Status p2) {
        return flightRepository.findAll().stream()
                .filter(flight -> flight.getStatus() == p1 || flight.getStatus() == p2)
                .toList();
    }

    public List<Flight> getFlightByTwoStatuses_CustomQuery( Status status1, Status status2) {
        return flightRepository.customQuery_getFlightsWhereStatus1OrStatus2(status1, status2);
    }

    private String generateRandomString(Random random) {
        return random.ints(15, 97, 123)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private Status generateRandomStatus(Random random) {
        return Status.values()[random.nextInt(Status.values().length)];
    }



}
