package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRepository {

    List<Movie> movieList=new ArrayList<>();

    public MovieRepository() {
        Movie m1 = new Movie(1, "Jane Eyre", 7.8, "Universal", 30.15, 2011, "Drama", 7.6, new ArrayList<String>(Arrays.asList("Tom Hanks", "Tim Allen", "Don Rickles")));
        Movie m2 = new Movie(2, "It's Complicated", 6.8, "Universal", 224.60, 2009, "Thriller", 5.7, new ArrayList<String>(Arrays.asList("Robin Williams", "Jonathan Hyde", "Kirsten Dunst")));
        Movie m3 = new Movie(3, "Phillip Morris", 9.4, "Independent", 20.10, 2010, "Romance", 8.5, new ArrayList<String>(Arrays.asList("Walter Matthau", "Jack Lemmon,Ann-Margret")));
        Movie m4 = new Movie(4, "Senior Year", 7.2, "Disney", 252.04, 2008, "Comedy", 7.4, new ArrayList<String>(Arrays.asList("Whitney Houston", "Angela Bassett", "Loretta Devine")));
        Movie m5 = new Movie(5, "Gamer", 9.8, "Warner Bros.", 178.84, 2009, "Thriller", 9.8, new ArrayList<String>(Arrays.asList("Steve Martin", "Diane Keaton", "Martin Short")));
        Movie m6 = new Movie(6, "Good Luck Chuck", 8.7, "Lionsgate", 59.19, 2007, "Comedy", 7.6, new ArrayList<String>(Arrays.asList("Jonathan Taylor Thomas", "Brad Renfro", "Rachael Leigh Cook")));
        Movie m7 = new Movie(7, "Going the Distance", 6.8, "Warner Bros.", 42.05, 2010, "Romance", 6.4, new ArrayList<String>(Arrays.asList("Jean-Claude Van Damme", "Powers Boothe", "Dorian Harewood")));
        Movie m8 = new Movie(8, "Gnomeo and Juliet", 4.6, "Disney", 193.97, 2011, "Comedy", 7.1, new ArrayList<String>(Arrays.asList("Pierce Brosnan", "Sean Bean", "Izabella Scorupco")));
        Movie m9 = new Movie(9, "Ghosts of Past", 3.7, "Warner Bros.", 102.22, 2009, "Thriller", 6.9, new ArrayList<String>(Arrays.asList("Michael Douglas", "Annette Bening", "Michael J. Fox")));
        Movie m10 = new Movie(10, "Four Christmases", 5.4, "Warner Bros.", 161.83, 2008, "Drama", 8.8, new ArrayList<String>(Arrays.asList("Leslie Nielsen", "Mel Brooks", "Amy Yasbeck")));

        movieList.add(m1);
        movieList.add(m2);
        movieList.add(m3);
        movieList.add(m4);
        movieList.add(m5);
        movieList.add(m6);
        movieList.add(m7);
        movieList.add(m8);
        movieList.add(m9);
        movieList.add(m10);
    }

    public void addMovie(Movie movie){
        movieList.add(movie);

    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
