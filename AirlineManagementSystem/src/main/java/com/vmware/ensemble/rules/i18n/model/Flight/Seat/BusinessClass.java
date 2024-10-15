package com.vmware.ensemble.rules.i18n.model.Flight.Seat;

public class BusinessClass extends Seat {
    public BusinessClass(String seatId, String seatRow, String seatNumber, long price) {
        super(seatId, seatRow, seatNumber, price);
    }

    @Override
    public long getPrice() {
        return this.getPrice() + 1000;
    }
}
