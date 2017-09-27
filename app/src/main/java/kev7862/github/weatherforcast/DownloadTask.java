package kev7862.github.weatherforcast;

import android.os.AsyncTask;

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

            String weatherInfo = jsonObject.getString("weather");
            JSONObject weatherdatas = new JSONObject(jsonObject.getString("main"));

            double tempInt = Double.parseDouble(weatherdatas.getString("temp"));

            int tempIn = (int) (tempInt*1.8-459.67);




            






        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
