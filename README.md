## Specifications
For this homework assignment, you will be using the data from the airline database from lab 3.02 and the Spring JPA Documentation.

You will be creating three main classes and an enum class: FlightBooking, Customer and Flight. The enum class will be called CustomerStatus.

### CustomerStatus enum
Create an enum class called CustomerStatus with the following values:

Gold
Silver
None

### Customer class
Create a class called Customer with the following variables:

customerId (integer): an auto-generated unique identifier, private member
customerName (string): private member
customerStatus (string): representing an enum, private member
totalCustomerMileage (integer): private member
Add an empty constructor to the Customer class for Hibernate to create new instances of the class.
Add a parameterized constructor to the Customer class that takes customerName, customerStatus and totalCustomerMileage as parameters.
Add public getter and setter methods for each variable in the Customer class.
### Flight class
Create a class called Flight with the following variables:

flightId (integer): an auto-generated unique identifier, private member
flightNumber (string): a unique identifier, private member
aircraft (string): private member
totalAircraftSeats (integer): private member
flightMileage (integer): private member
Add an empty constructor to the Flight class for Hibernate to create new instances of the class.
Add a parameterized constructor to the Flight class that takes flightNumber, aircraft, totalAircraftSeats and flightMileage as parameters.
Add public getter and setter methods for each variable in the Flight class.
### FlightBooking class
Create a class called FlightBooking with the following variables:

bookingId (integer): an auto-generated unique identifier, private member
customerId (integer): private member
flightId (integer): private member
Add an empty constructor to the FlightBooking class for Hibernate to create new instances of the class.
Add a parameterized constructor to the FlightBooking class that takes customerId and flightId as parameters.
Add public getter and setter methods for each variable in the FlightBooking class.
Add foreign key constraints in the FlightBooking class to reference the customerId and flightId in the customers and flights tables respectively.
