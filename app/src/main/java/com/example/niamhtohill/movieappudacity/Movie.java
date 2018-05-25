package com.example.niamhtohill.movieappudacity;

import java.net.MalformedURLException;

/**
 * Created by niamhtohill on 24/05/2018.
 */

public class Movie {
    private String movieTitle;
    private String movieReleaseDate;
    private String movieSynopsis;
    private Double movieVoteAverage;
    private String moviePosterUrl;

    public Movie(String movieTitle, String movieReleaseDate, String movieSynopsis, Double movieVoteAverage, String moviePosterUrl){
        this.movieTitle=movieTitle;
        this.movieReleaseDate=movieReleaseDate;
        this.movieSynopsis=movieSynopsis;
        this.movieVoteAverage=movieVoteAverage;
        this.moviePosterUrl=moviePosterUrl;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    public Double getMovieVoteAverage() {
        return movieVoteAverage;
    }

    public void setMovieVoteAverage(Double movieVoteAverage) {
        this.movieVoteAverage = movieVoteAverage;
    }

    public String getMoviePosterUrl() {
        return moviePosterUrl;
    }

    public void setMoviePosterUrl(String moviePosterUrl) {
        this.moviePosterUrl = moviePosterUrl;
    }
}
