// demo%202/src/test/AirlinedemoApplicationTests.java
import com.example.demo.AirlinedemoApplication;
import com.example.demo.models.*;
import com.example.demo.Repositories.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(classes = AirlinedemoApplication.class)

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AirlinedemoApplicationTests {

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
        Flight flight = new Flight(null, "Boeing 777", 300, 800, "IB123");
        Flight saved = flightRepository.save(flight);
        assertThat(saved.getFlightId()).isNotNull();
        assertThat(saved.getFlightNumber()).isEqualTo("IB123");
    }

    @Test
    void canFindCustomersByName() {
        customerRepository.save(new Customer(null, "Ana Lopez", 500, CustomerStatus.Gold));
        List<Customer> found = customerRepository.findByCustomerName("Ana Lopez");
        assertThat(found).isNotEmpty();
        assertThat(found.get(0).getCustomerName()).isEqualTo("Ana Lopez");
    }

    @Test
    void canFindCustomersByStatus() {
        customerRepository.save(new Customer(null, "Carlos Ruiz", 200, CustomerStatus.Gold));
        List<Customer> found = customerRepository.findByCustomerStatus(CustomerStatus.Gold);
        assertThat(found).isNotEmpty();
        assertThat(found.get(0).getCustomerStatus()).isEqualTo(CustomerStatus.Gold);
    }

    @Test
    void canFindFlightsByFlightNumber() {
        flightRepository.save(new Flight(null, "Airbus 350", 250, 1200, "UX456"));
        List<Flight> found = flightRepository.findByFlightNumber("UX456");
        assertThat(found).isNotEmpty();
        assertThat(found.get(0).getFlightNumber()).isEqualTo("UX456");
    }

    @Test
    void canFindAircraftWithNameContainingBoeing() {
        flightRepository.save(new Flight(null, "Boeing 737", 180, 900, "IB200"));
        flightRepository.save(new Flight(null, "Airbus 320", 160, 800, "IB201"));
        List<Flight> found = flightRepository.findByAircraftContains("Boeing");
        assertThat(found).isNotEmpty();
        assertThat(found.get(0).getAircraft()).contains("Boeing");
    }

	@Test
	void canFindFlightsWithMileageGreaterThan500() {
		flightRepository.save(new Flight(null, "Boeing 777", 300, 700, "IB300"));
		flightRepository.save(new Flight(null, "Airbus 350", 250, 400, "IB301"));
		List<Flight> found = flightRepository.findByFlightMileageGreaterThan(500);
		assertThat(found).isNotEmpty();
		assertThat(found.get(0).getFlightMileage()).isGreaterThan(500);
	}
}