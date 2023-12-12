package org.example;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        /*

1,"Jane Eyre",7.8,"Universal",30.15 ,2011
2,"It's Complicated",6.8,"Universal",224.60 ,2009
3,"Phillip Morris",9.4,"Independent",20.10 ,2010
4,"Senior Year",7.2,"Disney",252.04 ,2008
5,"Gamer",9.8,"Warner Bros.",178.84 ,2009
6,"Good Luck Chuck",8.7,"Lionsgate",59.19 ,2007
7,"Going the Distance",6.8,"Warner Bros.",42.05 ,2010
8,"Gnomeo and Juliet",4.6,"Disney",193.97 ,2011
9,"Ghosts of Past",3.7,"Warner Bros.",102.22 ,2009
10,"Four Christmases",5.4,"Warner Bros.",161.83 ,2008


Romance
Comedy
Drama
Thriller

 */


//        Movie m1 = new Movie(1, "Jane Eyre", 7.8, "Universal", 30.15, 2011, "Drama", 7.6, new ArrayList<String>(Arrays.asList("Tom Hanks", "Tim Allen", "Don Rickles")));
//        Movie m2 = new Movie(2, "It's Complicated", 6.8, "Universal", 224.60, 2009, "Thriller", 5.7, new ArrayList<String>(Arrays.asList("Robin Williams", "Jonathan Hyde", "Kirsten Dunst")));
//        Movie m3 = new Movie(3, "Phillip Morris", 9.4, "Independent", 20.10, 2010, "Romance", 8.5, new ArrayList<String>(Arrays.asList("Walter Matthau", "Jack Lemmon,Ann-Margret")));
//        Movie m4 = new Movie(4, "Senior Year", 7.2, "Disney", 252.04, 2008, "Comedy", 7.4, new ArrayList<String>(Arrays.asList("Whitney Houston", "Angela Bassett", "Loretta Devine")));
//        Movie m5 = new Movie(5, "Gamer", 9.8, "Warner Bros.", 178.84, 2009, "Thriller", 9.8, new ArrayList<String>(Arrays.asList("Steve Martin", "Diane Keaton", "Martin Short")));
//        Movie m6 = new Movie(6, "Good Luck Chuck", 8.7, "Lionsgate", 59.19, 2007, "Comedy", 7.6, new ArrayList<String>(Arrays.asList("Jonathan Taylor Thomas", "Brad Renfro", "Rachael Leigh Cook")));
//        Movie m7 = new Movie(7, "Going the Distance", 6.8, "Warner Bros.", 42.05, 2010, "Romance", 6.4, new ArrayList<String>(Arrays.asList("Jean-Claude Van Damme", "Powers Boothe", "Dorian Harewood")));
//        Movie m8 = new Movie(8, "Gnomeo and Juliet", 4.6, "Disney", 193.97, 2011, "Comedy", 7.1, new ArrayList<String>(Arrays.asList("Pierce Brosnan", "Sean Bean", "Izabella Scorupco")));
//        Movie m9 = new Movie(9, "Ghosts of Past", 3.7, "Warner Bros.", 102.22, 2009, "Thriller", 6.9, new ArrayList<String>(Arrays.asList("Michael Douglas", "Annette Bening", "Michael J. Fox")));
//        Movie m10 = new Movie(10, "Four Christmases", 5.4, "Warner Bros.", 161.83, 2008, "Drama", 8.8, new ArrayList<String>(Arrays.asList("Leslie Nielsen", "Mel Brooks", "Amy Yasbeck")));
//
//
//        Set<Movie> set = new HashSet<>();
//
//        set.add(m1);
//        set.add(m2);
//        set.add(m3);
//        set.add(m4);
//        set.add(m5);
//        set.add(m6);
//        set.add(m7);
//        set.add(m8);
//        set.add(m9);
//        set.add(m10);
//
//        System.out.println(set);

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