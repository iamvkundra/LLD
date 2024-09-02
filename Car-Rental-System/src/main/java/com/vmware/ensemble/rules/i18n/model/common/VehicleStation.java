package com.vmware.ensemble.rules.i18n.model.common;

import java.util.ArrayList;
import java.util.List;

import com.vmware.ensemble.rules.i18n.model.vehicle.Vehicle;

public class VehicleStation {
    private String stationId;
    private String location;
    List<Vehicle> vehicleList;

    public VehicleStation(String stationId, String location) {
        this.stationId = stationId;
        this.location = location;
        this.vehicleList = new ArrayList<>();
    }

    public void addVehicleInTheStation(Vehicle vehicle) {
        this.vehicleList.add(vehicle);
    }

}
