package com.vmware.ensemble.rules.i18n.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.vmware.ensemble.rules.i18n.model.Bill;
import com.vmware.ensemble.rules.i18n.model.ParkingSpot;
import com.vmware.ensemble.rules.i18n.model.Ticket;
import com.vmware.ensemble.rules.i18n.model.vehicle.Vehicle;
import com.vmware.ensemble.rules.i18n.service.Gate;
import com.vmware.ensemble.rules.i18n.service.ParkingLot;

public class ParkingGate implements Gate {

    private final ParkingLot parkingLot;
    private final int gateId;

    public ParkingGate(ParkingLot parkingLot, int gateId) {
        this.parkingLot = parkingLot;
        this.gateId = gateId;
    }

    @Override
    public Ticket enter(Vehicle vehicle) {
        synchronized (parkingLot) {
            ParkingSpot spot = parkingLot.findAvailableSpot(vehicle.getClass());
            if (spot != null) {
                spot.setOccupied(true);
                Ticket ticket = new Ticket(parkingLot.getNextTicketId(), vehicle, spot);
                parkingLot.addActiveTicket(ticket);
                System.out.printf("%s %s entered through gate %d and parked in spot %s%n",
                        vehicle.getTypeName(), vehicle.getLicensePlate(), gateId, spot.getParkingSpotId());
                return ticket;
            }
            System.out.printf("No available spot for %s %s at gate %d%n",
                    vehicle.getTypeName(), vehicle.getLicensePlate(), gateId);
            return null;
        }
    }

    @Override
    public Bill exit(Ticket ticket) {
        synchronized (parkingLot) {
            LocalDateTime exitTime = LocalDateTime.now();
            long parkingDuration = ChronoUnit.MINUTES.between(ticket.getEntryTime(), exitTime);
            double amount = parkingLot.calculateFee(ticket.getVehicle(), parkingDuration);

            ticket.getParkingSpot().setOccupied(false);
            parkingLot.removeActiveTicket(ticket);

            Bill bill = new Bill(ticket, exitTime, amount);
            System.out.printf("%s %s exited through gate %d. Parking duration: %d minutes%n",
                    ticket.getVehicle().getTypeName(), ticket.getVehicle().getLicensePlate(), gateId, parkingDuration);
            return bill;
        }
    }
}
