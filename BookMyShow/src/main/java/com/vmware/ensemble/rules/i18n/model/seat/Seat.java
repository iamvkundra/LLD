package com.vmware.ensemble.rules.i18n.model.seat;

import java.util.UUID;

import com.vmware.ensemble.rules.i18n.enums.SeatType;

public class Seat {

    private String seatId;
    private String seatNumber;
    private SeatType seatType;

    public int getPrice() {
        return price;
    }

    private final int price = 100;

    public Seat(String seatNumber, SeatType seatType) {
        this.seatId = UUID.randomUUID().toString();
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
