package com.vmware.ensemble.rules.i18n.model.vehicle;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public double getParkingFactor() {
        return 0.5;
    }

    @Override
    public String getTypeName() {
        return "MOTORCYCLE";
    }
}
