package com.vmware.ensemble.rules.i18n.model.vehicle;

import lombok.Getter;
import lombok.Setter;

import com.vmware.ensemble.rules.i18n.enums.common.VehicleStatus;
import com.vmware.ensemble.rules.i18n.enums.common.VehicleType;
import com.vmware.ensemble.rules.i18n.model.common.Coordinates;

@Setter
@Getter
public class Vehicle {
    private String id;
    private String licensePlateNumber;
    private Coordinates currentLocation;
    private VehicleStatus vehicleStatus;
    private VehicleType vehicleType;
}
