package com.vmware.ensemble.rules.i18n.model.Booking;

import java.util.List;

import com.vmware.ensemble.rules.i18n.model.Account.Account;
import com.vmware.ensemble.rules.i18n.model.Flight.Flight;
import com.vmware.ensemble.rules.i18n.model.Account.Passenger;
import com.vmware.ensemble.rules.i18n.model.Flight.Seat.Seat;

public class Booking {

    private final String bookingId;
    private final Account account;
    private Flight flight;
    private Seat seat;
    private List<Passenger> PassengerList;

    public Booking(String bookingId, Account account, Flight flight, Seat seat, List<Passenger> passengerList) {
        this.bookingId = bookingId;
        this.account = account;
        this.flight = flight;
        this.seat = seat;
        PassengerList = passengerList;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Account getAccount() {
        return account;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public List<Passenger> getPassengerList() {
        return PassengerList;
    }
}
