package com.vmware.ensemble.rules.i18n.model;

import java.util.List;
import java.util.UUID;

import com.vmware.ensemble.rules.i18n.enums.BookingStatus;
import com.vmware.ensemble.rules.i18n.model.seat.Seat;

public class Booking {

    private String bookingId;
    private String userId;
    private Show show;
    private List<Seat> bookedSeat;
    private BookingStatus bookingStatus;

    public Booking(String userId, Show show, List<Seat> bookedSeat, BookingStatus bookingStatus) {
        this.bookingId = UUID.randomUUID().toString();
        this.userId = userId;
        this.show = show;
        this.bookedSeat = bookedSeat;
        this.bookingStatus = bookingStatus;
    }


}
