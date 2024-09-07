package com.vmware.ensemble.rules.i18n.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vmware.ensemble.rules.i18n.enums.SeatType;
import com.vmware.ensemble.rules.i18n.model.seat.Seat;

public class Screen {

    private String screenId;
    private String screenNumber;
    private HashMap<SeatType, List<Seat>> seats;

    public Screen(String screenId, String screenNumber, int lower, int middle, int upper) {
        this.seats = new HashMap<>();
        this.screenId = screenId;
        this.screenNumber = screenNumber;

        seats.put(SeatType.LOWER, new ArrayList<>());
        seats.put(SeatType.MIDDLE, new ArrayList<>());
        seats.put(SeatType.RECLINER, new ArrayList<>());

        char c = 'a';
        for (int i=0; i<lower; i++) {
            seats.get(SeatType.LOWER).add(new Seat(c +"1", SeatType.LOWER));
            c++;
        }

        c = 'a';
        for (int i=0; i<middle; i++) {
            seats.get(SeatType.LOWER).add(new Seat(c +"2", SeatType.MIDDLE));
            c++;
        }

        c = 'a';
        for (int i=0; i<upper; i++) {
            seats.get(SeatType.LOWER).add(new Seat(c +"3", SeatType.RECLINER));
            c++;
        }

    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(String screenNumber) {
        this.screenNumber = screenNumber;
    }

}
