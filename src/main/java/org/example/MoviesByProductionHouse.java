package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoviesByProductionHouse {

    public static Map<String, List<Movie>> getMoviesByProduction() {
        MovieRepository movieRepository
                = new MovieRepository();

        return movieRepository.getMovieList().stream().collect(Collectors.groupingBy(Movie::getProduction));

    }
}
