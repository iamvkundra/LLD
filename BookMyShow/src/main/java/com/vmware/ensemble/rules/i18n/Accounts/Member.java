package com.vmware.ensemble.rules.i18n.Accounts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.vmware.ensemble.rules.i18n.enums.City;
import com.vmware.ensemble.rules.i18n.model.Movie;
import com.vmware.ensemble.rules.i18n.model.Show;
import com.vmware.ensemble.rules.i18n.model.Theatre;
import com.vmware.ensemble.rules.i18n.services.MovieService;
import com.vmware.ensemble.rules.i18n.services.TheatreService;

public class Member extends Account {

    private final MovieService movieService = MovieService.getMovieInstance();
    private final TheatreService theatreService = TheatreService.getTheatreServiceInstance();

    public Member(String username, String password, User user) throws Exception {
        super(username, password, user);
    }

    public void getMovieByCity(City city) {
        if (this.isLoggedIn()) {
            List<Movie> movieList = movieService.getAllMovies(city);
            System.out.println("-------------------SHOWING MOVIES IN "+city+"----------------------");
            for (Movie movie : movieList) {
                System.out.println(movie);
            }
            System.out.println("--------------------END---------------------------------------------");
        }
    }

    public void getAllShow(String movieId, City city) {
        if (this.isLoggedIn()) {
            System.out.println("----------------------SHOWS LIST HAPPNENING AT " + city+"------------------");
            Map<Theatre, List<Show>> list =  theatreService.getAllShow(movieId, city);
            for (Map.Entry<Theatre, List<Show>> el : list.entrySet()) {
                System.out.println("THEATRE ID: "+el.getKey().getTheatreId());
                for (Show show : el.getValue()) {
                    System.out.println("SHOW: " + show);
                }
            }
        }
    }
}
