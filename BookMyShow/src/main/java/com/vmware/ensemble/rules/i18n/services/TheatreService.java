package com.vmware.ensemble.rules.i18n.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vmware.ensemble.rules.i18n.enums.City;
import com.vmware.ensemble.rules.i18n.model.Movie;
import com.vmware.ensemble.rules.i18n.model.Show;
import com.vmware.ensemble.rules.i18n.model.Theatre;

public class TheatreService {

    private static TheatreService theatreServiceInstance;
    private final Map<City, List<Theatre>> cityVsTheatreMap;
    private final List<Theatre> allTheatre;

    public TheatreService() {
        this.cityVsTheatreMap = new HashMap<>();
        this.allTheatre = new ArrayList<>();
    }

    public static TheatreService getTheatreServiceInstance() {
        if (theatreServiceInstance == null) {
            synchronized (MovieService.class) {
                if (theatreServiceInstance == null) {
                    theatreServiceInstance = new TheatreService();
                }
            }
        }
        return theatreServiceInstance;
    }

    public void addTheatre(Theatre theatre) {
        if (!cityVsTheatreMap.containsKey(theatre.getAddress())) {
            cityVsTheatreMap.put(theatre.getAddress(), new ArrayList<>());
        }
        cityVsTheatreMap.get(theatre.getAddress()).add(theatre);
        allTheatre.add(theatre);
    }

    public void addShowInTheTheatre(String theatreId, City city, Show show) {
        for (Theatre theatre : allTheatre) {
            if (theatre.getTheatreId().equals(theatreId)) {
                theatre.addShow(show);
            }
            List<Theatre> theatres = cityVsTheatreMap.get(city);
            for (Theatre theatre1 : theatres) {
                if (theatre.getTheatreId().equals(theatreId)) {
                    theatre1.addShow(show);
                }
            }
            cityVsTheatreMap.put(city, theatres);
        }
    }

    public Theatre getTheatre(String theatreId) {
        for (Theatre theatre : allTheatre) {
            if (theatre.getTheatreId().equals(theatreId)) {
                return theatre;
            }
        }
        return null;
    }

    public Map<Theatre, List<Show>> getAllShow(String movieId, City city) {
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
        List<Theatre> theatres = cityVsTheatreMap.get(city);

        for (Theatre theatre : theatres) {
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();
            for (Show show : shows) {
                if (show.getShowId().equals(movieId)) {
                    givenMovieShows.add(show);
                }
            }

            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }
        return theatreVsShows;
    }
}
