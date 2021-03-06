package com.example.policeapp;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
//import java.util.Random;

public class Reportbw extends AsyncTask<String,Void,Void> {
    Context context;
    AlertDialog alertDialog;
    JSONObject jsonObject;
    Reportbw (Context ctx)
    {
        context=ctx;
    }
    @Override


    protected Void doInBackground(String... params) {

        String type=params[0];
        String str_poi=params[1];
        String str_des=params[2];
        String str_rr=params[3];
        //Random rand = new Random();

        // Generate random integers in range 0 to 999
        //int rand_int = rand.nextInt(1000);

        try {
            URL url = new
                    URL("http://172.16.192.162:8080/helloworld/rest/beat_management/update?mobile="+type+"&location="+str_poi+"&timeshift="+str_des+"&assigned="+str_rr);
            HttpURLConnection httpURLConnection = (HttpURLConnection)
                    url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new
                    InputStreamReader(inputStream));
            String line="";
            String data="";
            while(line!=null){
                line=bufferedReader.readLine();
                data+=line;
            }
            jsonObject = new JSONObject(data);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}