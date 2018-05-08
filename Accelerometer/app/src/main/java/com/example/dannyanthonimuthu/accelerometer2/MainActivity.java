package com.example.dannyanthonimuthu.accelerometer2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private ArrayList<Float> xData = new ArrayList<Float>();  //Laves en ArrayList, hvor data kan gemmes.

    //private static final String TAG = "MainActivity";




    private SensorManager sensorManager; //Definerer Sensormanager
    Sensor accelerometer;                //Definerer sensor

    TextView xValue, yValue, zValue;     // Definerer TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Her forbindes der til activity_main.xml filen


        xValue = (TextView) findViewById(R.id.xValue); //I xml filen har vi 3 textview (xValue, yValue og zValue), som vi så forbinder med de tidligere definerede Textview, således vi kan anvende det i koden (i java filen)
        yValue = (TextView) findViewById(R.id.yValue);
        zValue = (TextView) findViewById(R.id.zValue);



        //Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Log.d(TAG, "onCreate: Registered accelerometer listener");

    }

    // Der laves metoder nu


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) { // Når noget skrives i onSensorChanged metoden, så opdateres det, så snart der sker en ændring i sensorevent.


        xValue.setText("xValue: " + sensorEvent.values[0]); //sensorEvent.values[0] er x-værdi
        yValue.setText("yValue: " + sensorEvent.values[1]); //sensorEvent.values[1] er y-værdi
        zValue.setText("zValue: " + sensorEvent.values[2]); //sensorEvent.values[2] er z-værdi

        xData.add(sensorEvent.values[0]); //Her sættes x-værdien ind i xData, som er en Arraylist
        System.out.println(xData); // Her printer vi xData for at se, om x-værdien overhovedet er gemt i Arraylisten


    }

    public void onStartClick(View view){ //onStartClick metoden igangsættes, når der trykkes på start i appen.


        sensorManager.registerListener(MainActivity.this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onStopClick(View view){ //onStopClick metoden igangsættes, når der trykkes på stop i appen.


        sensorManager.unregisterListener(this);
    }

    public void onSaveClick(View v) throws IOException { //onSaveClick metoden igangsættes, når der trykkes på save i appen.
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("/main/Eksempel.csv"));
            Toast.makeText(this, "Saved to " + "/" + "Eksempel.txt", Toast.LENGTH_LONG).show(); // getFilesDir lokationen på filen
            for (int i = 0; i < 50; i++) {
                writer.write(String.valueOf(xData.get(i)));
                writer.newLine();
                writer.flush();

            }
        }
        catch(IOException e) {
                e.printStackTrace();
            }
            finally {
            if(writer !=null) {
                writer.close();
            }
        }

        Intent in = new Intent(this, Subactivity.class);
        startActivity(in);
        // De to sidste linjer giver anledning til, at når der trykkes på save knappen, så popper der et nyt vindue frem.


    }


}
