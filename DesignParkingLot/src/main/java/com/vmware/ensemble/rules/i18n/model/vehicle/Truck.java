package com.vmware.ensemble.rules.i18n.model.vehicle;

public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public double getParkingFactor() {
        return 2.0;
    }

    @Override
    public String getTypeName() {
        return "TRUCK";
    }
}
