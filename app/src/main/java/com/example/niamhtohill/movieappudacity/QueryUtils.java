package com.example.niamhtohill.movieappudacity;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by niamhtohill on 24/05/2018.
 */

public final class QueryUtils {
    private QueryUtils(){
    }
    private static URL buildUrl(String apiUrl){
        URL url = null;
        try{
            url = new URL(apiUrl);
        }catch(MalformedURLException e){
            Log.e("ERROR MESSAGE = ",e.getMessage());
        }
        return url;
    }
    public static List<Movie> retrieveJsonData(String apiUrl){
        URL url = buildUrl(apiUrl);
        String jsonData = null;
        try{
            jsonData = makeHttpRequest(url);
        }catch (IOException e){
            Log.e("ERROR = ", e.getMessage());
        }
        List<Movie> movies = createMovieObjects(jsonData);
        return movies;
    }
    private static String makeHttpRequest(URL url)throws IOException{
        HttpURLConnection urlConnection = null;
        InputStream in = null;
        String movieJsonStr = null;
        try{
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            System.out.println("********* In Make HTTP Request");
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            if(responseCode==200){
                in = urlConnection.getInputStream();
                movieJsonStr = readFromStream(in);
            }else{
                Log.e("ERROR RESPONSE CODE = ", "Response Code: " +responseCode);
            }
        }catch (IOException e){
            Log.e("ERROR : ",e.getMessage());
        }finally {
            if(urlConnection!=null){
                urlConnection.disconnect();
            }
            if(in !=null){
                in.close();
            }
        }
        return movieJsonStr;
    }

    private static String readFromStream(InputStream in) throws IOException{
        StringBuilder jsonOutput = new StringBuilder();
        if(in !=null){
            InputStreamReader inputStreamReader = new InputStreamReader(in, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line!=null){
                jsonOutput.append(line);
                line=reader.readLine();
            }
        }
        return jsonOutput.toString();
    }
    private static List<Movie> createMovieObjects(String jsonData){
        if(TextUtils.isEmpty(jsonData)){
            return null;
        }
        List<Movie> movies = new ArrayList<Movie>();
        try{
            JSONObject jsonObject = new JSONObject(jsonData);
            if(jsonObject.has("results")){
                JSONArray movieArray = jsonObject.getJSONArray("results");


                for(int i =0; i< movieArray.length(); i++){
                    JSONObject movieObject = movieArray.getJSONObject(i);
                    String movieImageUrl = movieObject.getString("poster_path");
                    String movieTitle = movieObject.getString("original_title");
                    String movieSynopsis = movieObject.getString("overview");
                    String movieRelease = movieObject.getString("release_date");
                    Double movieAverage = movieObject.getDouble("vote_average");
                    movies.add(new Movie(movieTitle,movieRelease,movieSynopsis,movieAverage,movieImageUrl));
                }
            }

        }catch (JSONException e){
            Log.e("JSON ERROR: ", e.getMessage());
        }
        return movies;
    }
}
