package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Top5Movies {


    public static List<Movie> getTop5Movies(){
        MovieRepository movieRepository
                = new MovieRepository();

        return movieRepository.getMovieList().stream()
                .sorted((o1, o2) -> {
                    if (o1.getImdb() < o2.getImdb()) {
                        return 1;
                    }
                    return -1;
                })
                .limit(5).collect(Collectors.toList());
    }

}
