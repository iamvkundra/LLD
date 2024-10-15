package com.vmware.ensemble.rules.i18n.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

import com.vmware.ensemble.rules.i18n.model.Address;
import com.vmware.ensemble.rules.i18n.model.Aircraft;
import com.vmware.ensemble.rules.i18n.model.Flight.Seat.Seat;

public class Flight {

    private final String flightId;
    private final Aircraft aircraft;
    private final Address arrival;
    private final Address departure;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private long basePrice;
    private final List<Seat> seats;

    public Flight(String flightId, Aircraft aircraft, Address arrival, Address departure, LocalDateTime arrivalTime,
                  LocalDateTime departureTime, List<Seat> seats, long basePrice) {
        this.flightId = flightId;
        this.aircraft = aircraft;
        this.arrival = arrival;
        this.departure = departure;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.seats = seats;
        this.basePrice = basePrice;
    }

    public long getBasePrice() {
        return this.basePrice;
    }

    public String getFlightId() {
        return flightId;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public Address getArrival() {
        return arrival;
    }

    public Address getDeparture() {
        return departure;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
