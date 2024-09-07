package com.vmware.ensemble.rules.i18n.model;

import java.time.LocalDateTime;
import java.util.List;

public class Show {

    private String showId;
    private String screenId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Override
    public String toString() {
        return "Show{" +
                "showId='" + showId + '\'' +
                ", screen=" + screenId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", bookedSeatIds=" + bookedSeatIds +
                ", movieId='" + movieId + '\'' +
                '}';
    }

    private List<String> bookedSeatIds;
    private String movieId;

    public Show(String showId, String screenId, LocalDateTime startTime, LocalDateTime endTime, String movieId) {
        this.showId = showId;
        this.screenId =screenId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.movieId = movieId;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<String> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(List<String> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }

    public String getMovie() {
        return movieId;
    }

    public void setMovie(String movieId) {
        this.movieId = movieId;
    }
}
