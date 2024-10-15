package com.vmware.ensemble.rules.i18n.model.vehicle;

public abstract class Vehicle {
    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    /*Abstract method to get parking factor */
    public abstract double getParkingFactor();

    /* Abstract method to get vehicle type name */
    public abstract String getTypeName();
}
