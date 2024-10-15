package com.vmware.ensemble.rules.i18n.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.vmware.ensemble.rules.i18n.model.Address;
import com.vmware.ensemble.rules.i18n.model.Flight.Flight;
import com.vmware.ensemble.rules.i18n.model.Flight.FlightPath;

public class FlightRepository {

    public static volatile FlightRepository flightRepository;

    private List<Flight> flights;
    private HashMap<Address, Set<Flight>> flightsCityMapping;

    private FlightRepository() {
        this.flights = new ArrayList<>();
        this.flightsCityMapping = new HashMap<>();
    }

    public static FlightRepository getFlightRepository() {
        if (flightRepository == null) {
            synchronized (FlightRepository.class) {
                if (flightRepository == null) {
                    flightRepository = new FlightRepository();
                }
            }
        }
        return flightRepository;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        flightsCityMapping.putIfAbsent(flight.getArrival(), new HashSet<>());
        flightsCityMapping.get(flight.getArrival()).add(flight);
    }

    public FlightPath findPath(Address source, Address destination, LocalDate date) {
        try {

            Map<Address, Integer> distance = new HashMap<>();
            Map<Address, Flight> previousFlight = new HashMap<>();

            PriorityQueue<Address> pq = new PriorityQueue<>((a, b) -> {
                int aTemp = distance.getOrDefault(a, Integer.MAX_VALUE);
                int bTemp = distance.getOrDefault(b, Integer.MAX_VALUE);
                return Integer.compare(aTemp, bTemp);
            });

            for (Address address : flightsCityMapping.keySet()) {
                distance.put(address, Integer.MAX_VALUE);
            }
            distance.put(source, 0);
            pq.offer(source);

            while (!pq.isEmpty()) {
                Address current = pq.poll();

                if (current.equals(destination)) {
                    //return makeFlightPath(sourceCity, destCity, previousFlight);
                }

                if (!flightsCityMapping.containsKey(current)) continue;

                for (Flight flight : flightsCityMapping.get(current)) {
                    Address next = flight.getDeparture();
                    int newDist = distance.get(current) +  1;

                    if (newDist < distance.getOrDefault(next, Integer.MAX_VALUE)) {
                        distance.put(next, newDist);
                        previousFlight.put(next, flight);
                        pq.offer(next);
                    }
                }
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void removeFlight(Flight flight) {

    }

    public void updateFlight(Flight flight) {

    }
}
