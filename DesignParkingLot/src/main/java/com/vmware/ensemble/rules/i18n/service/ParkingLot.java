package com.vmware.ensemble.rules.i18n.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.vmware.ensemble.rules.i18n.model.ParkingSpot;
import com.vmware.ensemble.rules.i18n.model.Ticket;
import com.vmware.ensemble.rules.i18n.model.vehicle.Car;
import com.vmware.ensemble.rules.i18n.model.vehicle.Motorcycle;
import com.vmware.ensemble.rules.i18n.model.vehicle.Truck;
import com.vmware.ensemble.rules.i18n.model.vehicle.Vehicle;
import com.vmware.ensemble.rules.i18n.service.impl.ParkingGate;

public class ParkingLot {
    
    private List<ParkingSpot> spots;
    private List<Gate> gates;
    private Set<Ticket> activeTickets;
    private int capacity;
    private int nextTicketId = 1;
    private static final double BASE_RATE = 2.0;
    
    public ParkingLot(int capacity, int numGates) {
        this.capacity = capacity;
        this.spots = new ArrayList<>();
        this.gates = new ArrayList<>();
        this.activeTickets = new HashSet<>();
        
        initializeSpots();
        initializeGates(numGates);
    }

    private void initializeSpots() {
        for (int i = 0; i < capacity; i++) {
            Class<? extends Vehicle> type = i % 3 == 0 ? Truck.class :
                    i % 2 == 0 ? Car.class : Motorcycle.class;
            spots.add(new ParkingSpot(i + 1+"", type));
        }
    }

    private void initializeGates(int numGates) {
        for (int i = 0; i < numGates; i++) {
            gates.add(new ParkingGate(this, i + 1));
        }
    }

    public ParkingSpot findAvailableSpot(Class<? extends Vehicle> vehicleClass) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.getVehicleType().isAssignableFrom(vehicleClass)) {
                return spot;
            }
        }
        return null;
    }

    public String getNextTicketId() {
        return "" + nextTicketId++;
    }

    public void addActiveTicket(Ticket ticket) {
        activeTickets.add(ticket);
    }

    public void removeActiveTicket(Ticket ticket) {
        activeTickets.remove(ticket);
    }

    public double calculateFee(Vehicle vehicle, long parkingDuration) {
        double hourlyRate = BASE_RATE * vehicle.getParkingFactor();
        return (parkingDuration / 60.0) * hourlyRate;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public Set<Ticket> getActiveTickets() {
        return activeTickets;
    }
}
