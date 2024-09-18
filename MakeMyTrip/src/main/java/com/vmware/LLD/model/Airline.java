package com.vmware.LLD.model;

public class Airline {

    private final String airlineId;
    private final String airlineName;
    private final String airlineCode;

    public String getCountry() {
        return country;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getAirlineId() {
        return airlineId;
    }

    private final String country;

    public Airline(String airlineId, String airlineName, String airlineCode, String country) {
        this.airlineId  = airlineId;
        this.airlineName = airlineName;
        this.airlineCode = airlineCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "airlineId='" + airlineId + '\'' +
                ", airlineName='" + airlineName + '\'' +
                ", airlineCode='" + airlineCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
