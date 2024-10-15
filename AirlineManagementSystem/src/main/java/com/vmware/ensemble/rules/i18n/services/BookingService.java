package com.vmware.ensemble.rules.i18n.services;

import java.awt.print.Book;
import java.util.List;

import com.vmware.ensemble.rules.i18n.model.Account.Passenger;
import com.vmware.ensemble.rules.i18n.model.Booking.Booking;
import com.vmware.ensemble.rules.i18n.model.Flight.Flight;

public interface BookingService {
    Booking createBooking(Flight flight, List<Passenger> passengerList);
    void cancelBooking(String bookingId, String reason);
    void updateBooking(Booking booking);
}
