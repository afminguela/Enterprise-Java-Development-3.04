package com.example.demo.Repositories;

import com.example.demo.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByDistanceGreaterThan(int i);

    List<Flight> findByFlightNumber(String ux456);
}
