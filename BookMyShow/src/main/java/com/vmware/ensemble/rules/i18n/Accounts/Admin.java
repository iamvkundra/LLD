package com.vmware.ensemble.rules.i18n.Accounts;

import com.vmware.ensemble.rules.i18n.enums.City;
import com.vmware.ensemble.rules.i18n.model.Show;
import com.vmware.ensemble.rules.i18n.model.Theatre;
import com.vmware.ensemble.rules.i18n.services.MovieService;
import com.vmware.ensemble.rules.i18n.services.TheatreService;

public class Admin extends Account {

    private final MovieService movieService = MovieService.getMovieInstance();
    private final TheatreService theatreService = TheatreService.getTheatreServiceInstance();

    public Admin(String username, String password, User user) throws Exception {
        super(username, password, user);
    }

    public void addMovies(String movieId, String movieName, City city) {
        if (this.isLoggedIn()) {
            movieService.addMovie(movieId, movieName, city);
        }
    }

    public void addTheatre(Theatre theatre) {
        if (this.isLoggedIn()) {
            theatreService.addTheatre(theatre);
        }
    }

    public void addShowInTheTheatre(String theatreId, Show show) {
        if (this.isLoggedIn()) {
            Theatre theatre = theatreService.getTheatre(theatreId);
            theatreService.addShowInTheTheatre(theatreId, theatre.getAddress(), show);
        }
    }
}
