package com.vmware.ensemble.rules.i18n.model;

import com.vmware.ensemble.rules.i18n.model.vehicle.Vehicle;

public class ParkingSpot {

    private String parkingSpotId;
    private boolean isOccupied;
    private Class<? extends Vehicle> vehicleType;

    public ParkingSpot(String parkingSpotId, Class<? extends Vehicle> vehicleType) {
        this.parkingSpotId = parkingSpotId;
        this.isOccupied = false;
        this.vehicleType = vehicleType;
    }

    public String getParkingSpotId() {
        return this.parkingSpotId;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    public Class<? extends Vehicle> getVehicleType() {
        return vehicleType;
    }
}
