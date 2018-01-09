package edu.pwste.simsim.Helper;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Admin on 06.01.2018.
 */

public class HttpDataHelper {
    static String stream=null;

    public HttpDataHelper() {
    }
    public String getHttpData(String urlString){
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if(urlConnection.getResponseCode()== HttpURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb= new StringBuilder();
                String line = new String();
                while ((line= reader.readLine())!=null)
                    sb.append(line);
                    stream=sb.toString();
                    urlConnection.disconnect();

            }
        }
        catch (Exception ex){

        }
        return stream;

    }
}
