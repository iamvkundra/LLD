package com.vmware.ensemble.rules.i18n.controller;

import java.util.HashMap;
import java.util.Map;

import com.vmware.ensemble.rules.i18n.model.Bill;
import com.vmware.ensemble.rules.i18n.model.Ticket;
import com.vmware.ensemble.rules.i18n.model.vehicle.Car;
import com.vmware.ensemble.rules.i18n.model.vehicle.Motorcycle;
import com.vmware.ensemble.rules.i18n.model.vehicle.Truck;
import com.vmware.ensemble.rules.i18n.model.vehicle.Vehicle;
import com.vmware.ensemble.rules.i18n.service.ParkingLot;
import com.vmware.ensemble.rules.i18n.strategy.PaymentStrategy;
import com.vmware.ensemble.rules.i18n.strategy.impl.CashPayment;
import com.vmware.ensemble.rules.i18n.strategy.impl.CreditCardPayment;

public class ParkingLotSystem {

    private ParkingLot parkingLot;
    private Map<Integer, PaymentStrategy> paymentStrategies;

    public ParkingLotSystem(int capacity, int numberOfGates) {
        this.parkingLot = new ParkingLot(capacity, numberOfGates);
        this.paymentStrategies = new HashMap<>();
        initializePaymentStrategies();
    }

    private void initializePaymentStrategies() {
        paymentStrategies.put(1, new CashPayment());
        paymentStrategies.put(2, new CreditCardPayment());
    }

    public Ticket parkVehicle(String licensePlate, int vehicleType, int gateNumber) {
        Vehicle vehicle;
        switch (vehicleType) {
            case 1:
                vehicle = new Car(licensePlate);
                break;
            case 2:
                vehicle = new Motorcycle(licensePlate);
                break;
            case 3:
                vehicle = new Truck(licensePlate);
                break;
            default:
                System.out.println("Invalid vehicle type");
                return null;
        }
        return parkingLot.getGates().get(gateNumber - 1).enter(vehicle);
    }
}
