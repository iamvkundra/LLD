package com.vmware.ensemble.rules.i18n.model.seat;

import java.time.Instant;
import java.util.Date;

public class SeatLock {

    private String seatId;
    private String theatreId;
    private String showId;
    private Integer timeoutInSeconds;
    private Instant lockTime;
    private String lockedBy;

    public SeatLock(String theatreId, String showId, String seatId,
                    String lockedBy, Integer timeoutInSeconds) {
        this.theatreId = theatreId;
        this.showId = showId;
        this.seatId = seatId;
        this.lockedBy = lockedBy;
        this.timeoutInSeconds = timeoutInSeconds;
        this.lockTime = new Date().toInstant();

    }

    public boolean isLockExpired() {
        final Instant lockInstant = lockTime.plusSeconds(timeoutInSeconds);
        final Instant currentInstant = new Date().toInstant();
        return lockInstant.isBefore(currentInstant);
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(String lockedBy) {
        this.lockedBy = lockedBy;
    }

    public Instant getLockTime() {
        return lockTime;
    }

    public void setLockTime(Instant lockTime) {
        this.lockTime = lockTime;
    }

    public Integer getTimeoutInSeconds() {
        return timeoutInSeconds;
    }

    public void setTimeoutInSeconds(Integer timeoutInSeconds) {
        this.timeoutInSeconds = timeoutInSeconds;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }
}
