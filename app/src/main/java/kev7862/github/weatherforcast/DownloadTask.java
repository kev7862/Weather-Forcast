package kev7862.github.weatherforcast;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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


    @Override
    protected String doInBackground(String... urls) {

        String results = "";
        URL url;
        HttpURLConnection urlConnection = null;

// Throwing an Exception incase we run into an error during connection.
        try {
            url = new URL(urls[0]);

            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();

           while (data != -1) {
               char current = (char) data;
               results += current;
               data = reader.read();
           }
           return results;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String results) {
        super.onPostExecute(results);

        //Creating a new JsonObject from results

        try {
            JSONObject jsonObject = new JSONObject(results);

            JSONObject weatherdata = new JSONObject(jsonObject.getString("main"));

            Double temperature = Double.parseDouble(weatherdata.getString("temp"));
            //converting degrees from Kelvin to Farenheit.
            int temperatureInteger = (int) (temperature * 1.8-459.67);


            // Indicating the users location

            String placeName = jsonObject.getString("name");


            MainActivity.temperatureTextView.setText(String.valueOf(temperatureInteger));
            MainActivity.placeTextView.setText(String.valueOf(placeName));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
