package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id //declara que es una PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autogenera un id
    private Long flightId;

    private String aircraft;
    private Integer totalAircraftSeats;
    private Integer flightMileage;

    @Column(nullable = false, unique = true)
    private String flightNumber;
}
