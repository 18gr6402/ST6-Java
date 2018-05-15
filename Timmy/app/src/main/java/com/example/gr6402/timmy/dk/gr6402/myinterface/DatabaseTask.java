package com.example.gr6402.timmy.dk.gr6402.myinterface;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;



public class DatabaseTask extends AsyncTask<String,Void,String> {

    private final DatabaseOperations databaseOperations;
    private String clinicID;

    public DatabaseTask(Activity activity){
        databaseOperations = (DatabaseOperations) activity;
    }

    @Override
    protected String doInBackground(String... params) {   //DatabaseOperations listener
        String type = params[0];
        if(type.equals("login")) {
            try {
                String id = params[1];
                String password = params[2];
                if(params.length == 4){
                    clinicID = params[3];
                }
                URL url = new URL("http://7da6074e.ngrok.io/login.php");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data;
                if(params.length == 3) {
                    post_data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&"
                            + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                } else {
                    post_data = URLEncoder.encode("clinicID", "UTF-8") + "=" + URLEncoder.encode(clinicID, "UTF-8") + "&"
                            + URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&"
                            + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                }
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result ="";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
     //   alertDialog = new AlertDialog.Builder(context).create();
    //    alertDialog.setTitle("Login status");
    }

    @Override
    protected void onPostExecute(String result) {
        databaseOperations.onTaskCompleted(result);
        super.onPostExecute(result);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}