package kev7862.github.weatherforcast;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by matite on 9/27/17.
 */
//This is where we download the webpage data.
public class DownloadTask extends AsyncTask<String, Void, String>{

    String results = "";
    URL url;
    HttpURLConnection urlConnection = null;

    @Override
    protected String doInBackground(String... urls) {
        return null;
    }
}
