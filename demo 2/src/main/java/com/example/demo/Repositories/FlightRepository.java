package com.example.demo.Repositories;

import com.example.demo.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByFlightMileageGreaterThan(int i);

    List<Flight> findByFlightNumber(String ux456);
    List<Flight> findByAircraftContains(String aircraft);


}
