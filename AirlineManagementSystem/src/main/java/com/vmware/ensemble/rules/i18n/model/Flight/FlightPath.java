package com.vmware.ensemble.rules.i18n.model.Flight;

import java.util.ArrayList;
import java.util.List;

import com.vmware.ensemble.rules.i18n.model.Address;

public class FlightPath {

    private Address arrival;
    private Address departure;

    private List<Flight> flights;
    private long totalAmount;

    public FlightPath(Address arrival, Address departure) {
        this.arrival = arrival;
        this.departure = departure;

        this.flights = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        totalAmount += flight.getBasePrice();
    }

    public List<Flight> getFlights() {
        return this.flights;
    }

    public long getTotalAmount() {
        return this.totalAmount;
    }
}
