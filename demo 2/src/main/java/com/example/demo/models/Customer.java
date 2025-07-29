package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costumerId;

    private String customerName;
    private Integer totalCustomerMileage;

    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;
}
