package com.vmware.ensemble.rules.i18n.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vmware.ensemble.rules.i18n.enums.City;
import com.vmware.ensemble.rules.i18n.model.Booking;
import com.vmware.ensemble.rules.i18n.provider.SeatLockProvider;
import com.vmware.ensemble.rules.i18n.provider.impl.InMemorySeatLockProvider;

public class BookingService {
    /*
    * CITY -> THEATREID -> BOOKING DETAILS
    * */
    private final Map<City, Map<String, List<Booking>>> bookingDetails;
    private final SeatLockProvider seatLockProvider = new InMemorySeatLockProvider();

    public BookingService() {
        this.bookingDetails = new HashMap<>();
    }

    public Booking createBooking(String theatreId, String showId, City city, List<String> seatId) {
        //If info is correct, then acquire the lock on seats.
        boolean ticketBookedWithSuccessFullPayment = false;
        if (ValidateInfoIsCorrect(theatreId, showId, city, seatId)) {
            for (String seat : seatId) {
                seatLockProvider.lockSeat(theatreId, showId, seat, null);
            }
            List<Booking> tickets = new ArrayList<>();

        } else {

        }

        if (!ticketBookedWithSuccessFullPayment) {
            for (String seat : seatId) {
                seatLockProvider.unlockSeat(theatreId, showId, seat);
            }
        }
        return null;
    }

    private boolean ValidateInfoIsCorrect(String theatreId, String showId, City city, List<String> seatId) {
        return true;
    }
}
