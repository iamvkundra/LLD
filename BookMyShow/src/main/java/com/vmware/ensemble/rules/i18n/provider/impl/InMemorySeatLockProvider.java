package com.vmware.ensemble.rules.i18n.provider.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vmware.ensemble.rules.i18n.enums.SeatStatus;
import com.vmware.ensemble.rules.i18n.model.seat.SeatLock;
import com.vmware.ensemble.rules.i18n.provider.SeatLockProvider;

public class InMemorySeatLockProvider implements SeatLockProvider {

    /*
        TheatreId -> ShowId -> List<SeatLock>
    */
    private HashMap<String, Map<String, List<SeatLock>>> locks;
    private final Integer defaultLockTimeout = 100;

    public InMemorySeatLockProvider() {
        this.locks = new HashMap<>();
    }

    @Override
    synchronized public void lockSeat(String theatreId, String showId, String seatId, String lockedBy) {
        SeatLock seatLock  = new SeatLock(theatreId, showId, seatId, lockedBy, defaultLockTimeout);
        if (!locks.containsKey(theatreId)) {
            locks.put(theatreId, new HashMap<>());
        }
        if (!locks.get(theatreId).containsKey(showId)) {
            locks.get(theatreId).put(showId, new ArrayList<>());
        }
        locks.get(theatreId).get(showId).add(seatLock);
    }

    @Override
    public void unlockSeat(String theatreId, String showId, String seatId) {
        SeatLock unlockSeat = null;
        if (locks.containsKey(theatreId) && locks.get(theatreId).containsKey(showId)) {
            List<SeatLock> seatLocks = locks.get(theatreId).get(showId);
            for (SeatLock seatLock : seatLocks) {
                if (seatLock.getSeatId().equals(seatId)) {
                    unlockSeat = seatLock;
                    break;
                }
            }
        }
        if (unlockSeat != null) {
            locks.get(theatreId).get(showId).remove(unlockSeat);
            System.out.println("Seat successfully unlocked");
        }
    }

    @Override
    public SeatStatus seatStatus(String theatreId, String showId, String seatId) {
        if (locks.containsKey(theatreId) && locks.get(theatreId).containsKey(showId)) {
            for (SeatLock seatLock : locks.get(theatreId).get(showId)) {
                if (seatLock.getSeatId().equals(seatId)) {
                    return SeatStatus.LOCKED;
                }
            }
        }
        return SeatStatus.UNLOCKED;
    }

}
