package com.vmware.ensemble.rules.i18n.model.Flight.Seat;

public abstract class Seat {
    private String seatId;
    private String seatRow;
    private String seatNumber;
    private long seatPrice;

    public Seat(String seatId, String seatRow, String seatNumber, long price) {
        this.seatId = seatId;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.seatPrice = price;
    }

    public abstract long getPrice();
}
