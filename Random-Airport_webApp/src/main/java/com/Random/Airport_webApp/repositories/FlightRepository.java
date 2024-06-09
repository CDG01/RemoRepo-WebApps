package com.Random.Airport_webApp.repositories;


import com.Random.Airport_webApp.entities.Flight;
import com.Random.Airport_webApp.entities.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByStatus(Status status);

    // Version without Custom Query
    List<Flight> findByStatusOrStatus(@Param("status1") Status status1, @Param("status2") Status status2);

    // Version Custom Query
    @Query("SELECT f FROM Flight f WHERE f.status = ?1 OR f.status = ?2")
    List<Flight> customQuery_getFlightsWhereStatus1OrStatus2(Status status1, Status status2);

    @Query(value = "SELECT * FROM flights ORDER BY from_airport", nativeQuery = true)
    Page<Flight> customQuery_getFlightsPagedAndOrderedByFromAirport(Pageable pageable);
    // Page<Flight> getFlightPaged(Pageable pageable);






}
