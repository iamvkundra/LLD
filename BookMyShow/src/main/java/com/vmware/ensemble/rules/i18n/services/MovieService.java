package com.vmware.ensemble.rules.i18n.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vmware.ensemble.rules.i18n.enums.City;
import com.vmware.ensemble.rules.i18n.model.Movie;
import com.vmware.ensemble.rules.i18n.utils.Utils;

public class MovieService {

    private static MovieService movieInstance;

    private Map<City, List<Movie>> cityVsMovies;
    private List<Movie> allMovies;

    public static MovieService getMovieInstance() throws Exception {
        if (movieInstance == null) {
            synchronized (MovieService.class) {
                if (movieInstance == null) {
                    movieInstance = new MovieService();
                }
            }
        }
        return movieInstance;
    }

    public MovieService() throws Exception {
        if (movieInstance != null) {
            throw new Exception("Please use getMovieInstance() to get the object of MovieService");
        }
        cityVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public void addMovie(String movieId, String movieName, City city) {
        Movie movie = Utils.getMovie(movieName, movieId);
        allMovies.add(movie);

        List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, movies);
    }

    public Movie getMovieByName(String movieName) {
        for (Movie movie : allMovies) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getAllMovies(City city) {
        return cityVsMovies.get(city);
    }
}
