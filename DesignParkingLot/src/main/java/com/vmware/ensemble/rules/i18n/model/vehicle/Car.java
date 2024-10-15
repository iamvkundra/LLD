package com.vmware.ensemble.rules.i18n.model.vehicle;

public class Car extends Vehicle {

    public Car(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public double getParkingFactor() {
        return 1.0;
    }

    @Override
    public String getTypeName() {
        return "CAR";
    }
}
