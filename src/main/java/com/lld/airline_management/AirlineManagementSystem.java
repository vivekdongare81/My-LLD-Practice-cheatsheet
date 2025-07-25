package com.lld.airline_management;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lld.airline_management.booking.Booking;
import com.lld.airline_management.booking.BookingManager;
import com.lld.airline_management.flight.Flight;
import com.lld.airline_management.flight.FlightSearch;
import com.lld.airline_management.payment.Payment;
import com.lld.airline_management.payment.PaymentProcessor;
import com.lld.airline_management.seat.Seat;

public class AirlineManagementSystem {
    private final Map<String, Flight> flights;
    private final Map<String, Aircraft> aircrafts;
    private final Map<String, Passenger> passengers;
    private final FlightSearch flightSearch;
    private final BookingManager bookingManager;
    private final PaymentProcessor paymentProcessor;

    public AirlineManagementSystem() {
        flights = new HashMap<>();
        aircrafts = new HashMap<>();
        passengers = new HashMap<>();
        flightSearch = new FlightSearch();
        bookingManager = BookingManager.getInstance();
        paymentProcessor = PaymentProcessor.getInstance();
    }

    public Passenger addPassenger(String name, String email) {
        Passenger passenger = new Passenger(name, email);
        passengers.put(passenger.getId(), passenger);
        return passenger;
    }

    public Aircraft addAircraft(String tailNumber, String model, int totalSeats) {
        Aircraft aircraft = new Aircraft(tailNumber, model, totalSeats);
        aircrafts.put(tailNumber, aircraft);
        return aircraft;
    }

    public Flight addFlight(String source, String destination, LocalDateTime departure,
                            LocalDateTime arrival, String aircraftNumber) {
        Aircraft aircraft = aircrafts.get(aircraftNumber);
        Flight flight = new Flight(source, destination, departure, arrival, aircraft);
        flights.put(flight.getFlightNumber(), flight);
        flightSearch.addFlight(flight);
        return flight;
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate date) {
        return flightSearch.searchFlights(source, destination, date);
    }

    public Booking bookFlight(String flightNumber, String passengerId, Seat seat, double price) {
        Flight flight = flights.get(flightNumber);
        Passenger passenger = passengers.get(passengerId);
        return bookingManager.createBooking(flight, passenger, seat, price);
    }

    public void cancelBooking(String bookingNumber) {
        bookingManager.cancelBooking(bookingNumber);
    }

    public void processPayment(Payment payment) {
        paymentProcessor.processPayment(payment);
    }
}
