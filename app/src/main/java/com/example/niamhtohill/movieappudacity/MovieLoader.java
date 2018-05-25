package com.example.niamhtohill.movieappudacity;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by niamhtohill on 24/05/2018.
 */

public class MovieLoader extends AsyncTaskLoader<List<Movie>> {
    String url;
    public MovieLoader(Context context, String url){
        super(context);
        this.url=url;
    }
    @Override
    public List<Movie> loadInBackground() {
        if(url==null){
            return null;
        }
        List<Movie> movies = QueryUtils.retrieveJsonData(url);
        return movies;
    }
}
