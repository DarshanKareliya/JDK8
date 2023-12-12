package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class MoviesByStar {

    public static List<Movie> getMoviesByStar(String name) {
        MovieRepository movieRepository = new MovieRepository();
        List<Movie> movieList = movieRepository.getMovieList();

        return movieList
                .stream()
                .filter(movie -> movie.getCast().contains(name))
                .collect(Collectors.toList());
    }


}
