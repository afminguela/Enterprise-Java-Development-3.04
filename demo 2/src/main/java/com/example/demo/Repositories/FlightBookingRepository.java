package com.example.demo.Repositories;

import com.example.demo.models.Flight;
import com.example.demo.models.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {


}