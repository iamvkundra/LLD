package com.vmware.ensemble.rules.i18n.provider;



import com.vmware.ensemble.rules.i18n.enums.SeatStatus;

public interface SeatLockProvider {

    void lockSeat(String theatreId, String showId,
                  String seatId, String lockedBy);

    void unlockSeat(String theatreId, String showId, String seatId);

    SeatStatus seatStatus(String theatreId, String showId, String seatId);
}
