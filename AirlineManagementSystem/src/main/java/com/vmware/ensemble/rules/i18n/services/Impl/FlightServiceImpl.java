package com.vmware.ensemble.rules.i18n.services.Impl;

import java.time.LocalDate;
import java.util.List;

import com.vmware.ensemble.rules.i18n.model.Address;
import com.vmware.ensemble.rules.i18n.model.Flight.Flight;
import com.vmware.ensemble.rules.i18n.model.Flight.FlightPath;
import com.vmware.ensemble.rules.i18n.repositories.FlightRepository;
import com.vmware.ensemble.rules.i18n.services.FlightService;

public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl() {
        flightRepository = FlightRepository.getFlightRepository();
    }

    @Override
    public void addFlight(Flight flight) {
        flightRepository.addFlight(flight);
    }

    @Override
    public void updateFlight(Flight flight) {

    }

    @Override
    public void removeFlight(Flight flight) {

    }

    @Override
    public List<List<FlightPath>> searchFlight(Address arrival, Address destination, LocalDate date) {
        flightRepository.findPath(arrival, destination, date);
        return null;
    }
}
