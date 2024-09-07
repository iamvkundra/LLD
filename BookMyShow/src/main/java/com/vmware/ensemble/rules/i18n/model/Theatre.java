package com.vmware.ensemble.rules.i18n.model;

import java.util.ArrayList;
import java.util.List;

import com.vmware.ensemble.rules.i18n.enums.City;

public class Theatre {

    private String theatreId;
    private City address;
    private List<Screen> screen;
    private List<Show> shows;

    public Theatre(String theatreId, City address) {
        this.address = address;
        this.theatreId = theatreId;
        this.screen = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        this.screen.add(screen);
    }

    public void addShow(Show show) {
        this.shows.add(show);
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public City getAddress() {
        return address;
    }

    public void setAddress(City address) {
        this.address = address;
    }

    public List<Screen> getScreen() {
        return screen;
    }

    public void setScreen(List<Screen> screen) {
        this.screen = screen;
    }

    public List<Show> getShows() {
        return shows;
    }
}
