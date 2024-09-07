package com.vmware.ensemble.rules.i18n.utils;

import java.util.UUID;

import com.vmware.ensemble.rules.i18n.model.Movie;

public class Utils {

    public static Movie getMovie(String movieName, String movieId) {
        return new Movie(movieId, movieName);
    }
}
