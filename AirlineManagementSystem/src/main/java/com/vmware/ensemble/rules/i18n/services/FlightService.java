package com.vmware.ensemble.rules.i18n.services;

import java.time.LocalDate;
import java.util.List;

import com.vmware.ensemble.rules.i18n.enums.City;
import com.vmware.ensemble.rules.i18n.model.Address;
import com.vmware.ensemble.rules.i18n.model.Flight.Flight;
import com.vmware.ensemble.rules.i18n.model.Flight.FlightPath;

public interface FlightService {
    void addFlight(Flight flight);
    void updateFlight(Flight flight);
    void removeFlight(Flight flight);
    List<List<FlightPath>> searchFlight(Address arrival, Address destination, LocalDate date);

}
