package com.vmware.ensemble.rules.i18n.model;

import java.time.LocalDate;

public class Aircraft {
    private String airlineId;
    private String airlineName;
    private LocalDate manufacturedDate;

    public Aircraft(String airlineId, String airlineName, LocalDate manufacturedDate) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.manufacturedDate = manufacturedDate;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public LocalDate getManufacturedDate() {
        return manufacturedDate;
    }
}
