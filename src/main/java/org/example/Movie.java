package org.example;

import java.util.List;
import java.util.Objects;

public class Movie {

    private int id;
    private String title;
    private double imdb;
    private List<String> cast;
    private String production;
    private double collection;
    private int year;
    private double publicRating;
    private String category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Double.compare(movie.imdb, imdb) == 0 && Double.compare(movie.collection, collection) == 0 && year == movie.year && Double.compare(movie.publicRating, publicRating) == 0 && Objects.equals(title, movie.title) && Objects.equals(cast, movie.cast) && Objects.equals(production, movie.production) && Objects.equals(category, movie.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, imdb, cast, production, collection, year, publicRating, category);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imdb=" + imdb +
                ", cast=" + cast +
                ", production='" + production + '\'' +
                ", collection=" + collection +
                ", year=" + year +
                ", publicRating=" + publicRating +
                ", category='" + category + '\'' +
                '}';
    }

    public Movie(int id, String title, double imdb, String production ,double collection, int year, String category, double publicRating, List<String> cast ) {
        this.id = id;
        this.title = title;
        this.imdb = imdb;
        this.cast = cast;
        this.production = production;
        this.collection = collection;
        this.year = year;
        this.publicRating = publicRating;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public double getCollection() {
        return collection;
    }

    public void setCollection(double collection) {
        this.collection = collection;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPublicRating() {
        return publicRating;
    }

    public void setPublicRating(double publicRating) {
        this.publicRating = publicRating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
