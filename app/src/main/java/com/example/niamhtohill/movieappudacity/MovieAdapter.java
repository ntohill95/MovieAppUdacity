package com.example.niamhtohill.movieappudacity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by niamhtohill on 24/05/2018.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {
    private Context context;
    public MovieAdapter(Context context, List<Movie> movie){
        super(context,0,movie);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View gridItem = convertView;
        if(gridItem == null){
            gridItem = LayoutInflater.from(getContext()).inflate(R.layout.grid_item,parent,false);
        }
        Movie currentMovie = getItem(position);
        ImageView movieImage = gridItem.findViewById(R.id.movie_grid_image);
        String imageUrl = currentMovie.getMoviePosterUrl();
        //w185 recommended for most phones
        String link = "http://image.tmdb.org/t/p/w185";
        link = link + imageUrl;
        System.out.println(link);
        Picasso.with(context).load(link).into(movieImage);
        return gridItem;
    }
}
