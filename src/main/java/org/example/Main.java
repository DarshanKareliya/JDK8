package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        MovieRepository movieRepository = new MovieRepository();

        List<Movie> set = movieRepository.getMovieList();
        System.out.println();
        System.out.println("TOP 5 MOVIES BY COLLECTION------");

        set.stream()
                .sorted((o1, o2) -> {
                    if (o1.getCollection() < o2.getCollection()) {
                        return 1;
                    }
                    return -1;
                })
                .limit(5)
                .forEach(m -> System.out.println("NAME: " + m.getTitle() + "  " + ",COLLECTION: " + m.getCollection()));

        System.out.println();
        System.out.println("TOP 5 MOVIES------");

        set.stream()
                .sorted((o1, o2) -> {
                    if (o1.getImdb() < o2.getImdb()) {
                        return 1;
                    }
                    return -1;
                })
                .limit(5)
                .forEach(m -> System.out.println("NAME: " + m.getTitle() + "  " + ",IMDB: " + m.getImdb()));

        System.out.println();
        System.out.println("TOP RATED MOVIES------");

        set.stream().sorted((o1, o2) -> {
            if (o1.getPublicRating() < o2.getPublicRating()) {
                return 1;
            }
            return -1;
        }).forEach(m -> System.out.println("NAME: " + m.getTitle() + "  " + ",RATING: " + m.getPublicRating()));

        System.out.println();
        System.out.println("TOP RATED THRILLER MOVIES------");
        //  top 10 movies by collection


        set.stream()
                .filter((movie) -> {
                    if (movie.getCategory() == "Thriller") {
                        return true;
                    }
                    return false;
                })
                .sorted((o1, o2) -> {
                    if (o1.getPublicRating() < o2.getPublicRating()) {
                        return 1;
                    }
                    return -1;
                })
                .forEach(m -> System.out.println("NAME: " + m.getTitle() + "  " + ",RATING: " + m.getPublicRating()));

        System.out.println();
        System.out.println("TOP STAR CAST------");

        set.stream().sorted((o1, o2) -> {
            if (o1.getPublicRating() < o2.getPublicRating()) {
                return 1;
            }
            return -1;
        }).forEach(m -> {
            System.out.println(m.getCast().get(0));
        });

        System.out.println();
        System.out.println("TOP 10 PRODUCTION HOUSE------");

        Map<String, Double> col = new HashMap<>();

        Map<String, List<Movie>> mp = MoviesByProductionHouse.getMoviesByProduction();
        //mp.values();



        set.stream()
                .map((Movie movie) -> {
                    return movie.getProduction();
                })
                .forEach((String s) -> {
                    col.put(s, 0.0);
                });



        set.stream()
                .forEach(movie -> {
                    String key = movie.getProduction();
                    Double collection = movie.getCollection();
                    Double old = col.get(key);
                    Double newCol = old + collection;
                    col.replace(key, newCol);
                });

        // System.out.println(col);


        List<Double> vals = col.values().stream()
                .sorted((o1, o2) -> {
                    if (o1 < o2) {
                        return 1;
                    }
                    return -1;
                }).toList();
        vals.stream()
                .forEach(m -> {
                    col.keySet().stream()
                            .forEach(n -> {
                                if (col.get(n).equals(m)) {
                                    System.out.println(n + " , TOTAL COLLECTION: " + col.get(n));
                                }
                            });

                });

        System.out.println();
        System.out.println("MOVIES BY STAR CAST------");

        List<Movie> l1=MoviesByStar.getMoviesByStar("Steve Martin");
        System.out.println(l1);


        System.out.println();
        System.out.println("MOVIES BY PRODUCTION HOUSE------");

        Map<String, List<Movie>> mp1 = MoviesByProductionHouse.getMoviesByProduction();
        System.out.println(mp1);


    }
}