package com.example.demo;


import com.example.demo.models.*;
import com.example.demo.Repositories.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RepositoryIntegrationTests {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	FlightBookingRepository flightBookingRepository;

	@Test
	void canCreateNewCustomer() {
		Customer customer = new Customer(null, "Juan Perez", 1000, CustomerStatus.Silver);
		Customer saved = customerRepository.save(customer);
		assertThat(saved.getCostumerId()).isNotNull();
		assertThat(saved.getCustomerName()).isEqualTo("Juan Perez");
	}

	@Test
	void canCreateNewFlight() {
		Flight flight = new Flight(null, "777 Boeing", 800, null,"IB123" );
		Flight saved = flightRepository.save(flight);
		assertThat(saved.getFlightId()).isNotNull();
		assertThat(saved.getFlightNumber()).isEqualTo("IB123");
	}

	@Test
	void canFindCustomersByName() {
		customerRepository.save(new Customer(null, "Ana Lopez", 500, CustomerStatus.Silver));
		List<Customer> found = customerRepository.findByCustomerName("Ana Lopez");
		assertThat(found).isNotEmpty();
		assertThat(found.get(0).getCustomerName()).isEqualTo("Ana Lopez");
	}

	@Test
	void canFindCustomersByStatus() {
		Customer c = new Customer(null, "Carlos Ruiz", 200, CustomerStatus.Gold);
		customerRepository.save(c);
		List<Customer> found = customerRepository.findByCustomerStatus(CustomerStatus.Gold );
		assertThat(found).isNotEmpty();
		assertThat(found.get(0).getCustomerStatus()).isEqualTo(CustomerStatus.Gold);
	}

	@Test
	void canFindFlightsByFlightNumber() {
		Flight flight = new Flight(null, "777 Boeing", 800, null,"IB123" );
		List<Flight> found = flightRepository.findByFlightNumber("UX456");
		assertThat(found).isNotEmpty();
		assertThat(found.get(0).getFlightNumber()).isEqualTo("UX456");
	}

	@Test
	void canFindAircraftWithNameContainingBoeing() {
		flightBookingRepository.save( new Flight(null, "777 Boeing", 800, null,"IB123" ));
		flightBookingRepository.save(new Flight(null, "350 airbus", 804, null,"IB123" ));
		List<Flight> found = flightBookingRepository.findByAircraftContains("Boeing");
		assertThat(found).isNotEmpty();
		assertThat(found.get(0).getAircraft()).contains("Boeing");
	}

	@Test
	void canFindFlightsWithDistanceGreaterThan500() {
		flightBookingRepository.save( new Flight(null, "777 Boeing", 800, 699,"IB123" ));
		flightBookingRepository.save(new Flight(null, "350 airbus", 804, 400,"IB123" ));
		List<Flight> found = flightRepository.findByDistanceGreaterThan(500);
		assertThat(found).isNotEmpty();
		assertThat(found.get(0).getFlightMileage()).isGreaterThan(500);
	}
}
