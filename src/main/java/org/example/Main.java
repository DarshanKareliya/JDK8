package org.example;

import java.util.*;
import java.util.stream.Collectors;

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

        Top5Movies.getTop5Movies().stream()
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
                    return movie.getCategory().equals("Thriller");
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


        System.out.println("unsorted map of production house as key and total collection as value");
        System.out.println(mp.entrySet()
                .stream()
                .map((Map.Entry<String, List<Movie>> stringListEntry) -> {
                    Double gross = stringListEntry.getValue()
                            .stream()
                            .map(movie -> movie.getCollection())
                            .reduce(0.0, (c1, d1) -> c1 + d1);
                    String key = stringListEntry.getKey();
                    Map.Entry<String, Double> entry = new AbstractMap.SimpleEntry<>(key, gross);
                    return entry;
                })
                .sorted((Map.Entry<String, Double> o1, Map.Entry<String, Double> o2)-> {
                    if (o1.getValue() < o2.getValue()) {
                        return 1;
                    }
                    return -1;
                })          //   if we are putting the values in the map then it does not matter if we have sorted value or not because map DOES NOT GIVE VALUES IN ORDER.
                            //    MAP DOES NOT CARE ABOUT ORDER EXCEPT LinkedHashMap
                .collect(Collectors.toMap((Map.Entry<String, Double> stringDoubleEntry)-> {
                    return stringDoubleEntry.getKey();

                }, (Map.Entry<String, Double> stringDoubleEntry)-> {
                    return stringDoubleEntry.getValue();

                })));


        System.out.println();
        System.out.println("sorted map of production house as key and total collection as value");
        LinkedHashMap<String, Double> result = new LinkedHashMap<>();
        mp.entrySet().stream()
                .map((Map.Entry<String, List<Movie>> stringListEntry) -> {
                    Double gross = stringListEntry.getValue()
                            .stream()
                            .map(movie -> movie.getCollection())
                            .reduce(0.0, (c1, d1) -> c1 + d1);
                    String key = stringListEntry.getKey();
                    Map.Entry<String, Double> entry = new AbstractMap.SimpleEntry<>(key, gross);
                    return entry;
                })
                .sorted((Map.Entry<String, Double> o1, Map.Entry<String, Double> o2)-> {
                    if (o1.getValue() < o2.getValue()) {
                        return 1;
                    }
                    return -1;
                })
                .collect(Collectors.toList())
                .stream()
                .forEach(m ->
                {
                    result.put(m.getKey(), m.getValue());
                });

        System.out.println(result);


        System.out.println();
        System.out.println("another way of creating the top production house by total collection of that production ");
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

        List<Movie> l1 = MoviesByStar.getMoviesByStar("Steve Martin");
        System.out.println(l1);


        System.out.println();
        System.out.println("MOVIES BY PRODUCTION HOUSE------");

        Map<String, List<Movie>> mp1 = MoviesByProductionHouse.getMoviesByProduction();
        System.out.println(mp1);


    }
}