package com.vmware.ensemble.rules.i18n.model;

public class ParkingSpot {

    private String spotId;
    private String spotNumber;
    private boolean isParked;

    public ParkingSpot(String spotId, String spotNumber) {
        this.spotId = spotId;
        this.spotNumber = spotNumber;
    }

    public void parkVehicle() {
        this.isParked = true;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(String spotNumber) {
        this.spotNumber = spotNumber;
    }
}
