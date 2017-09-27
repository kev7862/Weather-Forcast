package kev7862.github.weatherforcast;

import android.os.AsyncTask;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
// Throwing an Exception incase we run into an error during connection.
        try {
            url = new URL(urls[0]);

            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
