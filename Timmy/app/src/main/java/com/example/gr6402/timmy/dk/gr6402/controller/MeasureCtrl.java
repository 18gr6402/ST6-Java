package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.gigamole.library.PulseView;

import java.util.ArrayList;

public class MeasureCtrl extends AppCompatActivity {

    private Patient loginPatient;
    private SoundPool soundPool;
    private int sound1, sound2;
    private TextView mStart;
    private TextView countDown;
    PulseView pulseView;
    private CountDownTimer countDownTimer;
    private ArrayList<Float> zData = new ArrayList<Float>();
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private String results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.measure);

        //get intent, henter pakkerne der sendes fra menuen
        loginPatient = (Patient) getIntent().getParcelableExtra("PatientTag");

        mStart = (TextView) findViewById(R.id.mStart);
        countDown = (TextView) findViewById(R.id.countDown);
        pulseView = (PulseView) findViewById(R.id.pv);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        //Lyd

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }

        sound1 = soundPool.load(this, R.raw.beep, 1);
        sound2 = soundPool.load(this,R.raw.beepfinish,1);

        //Starter countDownTimer
        countDown.setText("Nedtælling 5");
        countDownTimer = new CountDownTimer(26000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDown.setText("Nedtælling"+ " " + (millisUntilFinished-20000)/1000);

                if(millisUntilFinished >=1000 && millisUntilFinished <=21000 ){
                    mStart.setVisibility(View.INVISIBLE);
                    countDown.setVisibility(View.INVISIBLE);
                    sensorManager.registerListener(listener,accelerometer,SensorManager.SENSOR_DELAY_FASTEST);
                    pulseView.setVisibility(View.VISIBLE);
                    pulseView.startPulse();

                } else if(millisUntilFinished<=24000 && millisUntilFinished>=21000) {
                    soundPool.play(sound1,1,1,0,0,1);
                }
                else if (millisUntilFinished>=0 && millisUntilFinished<=1000) {
                    countDown.setVisibility(View.INVISIBLE);
                }



            }

            @Override
            public void onFinish() {

                soundPool.play(sound2,1,1,0,0,1);
                mStart.setText("Måling afsluttet");
                mStart.setVisibility(View.VISIBLE);
                pulseView.finishPulse();
                pulseView.setVisibility(View.INVISIBLE);
                stopDetecting();
                countDownTimer.cancel();

                String results = TextUtils.join(",",zData); //Konverterer Arraylist til String
                System.out.println("STRING TIL DATABASEN" + " " + results );
                confirmMeasure();


            }
        };
        countDownTimer.start();


    }



    private SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            zData.add(sensorEvent.values[2]); //Her sættes z-værdien ind i zData, som er en Arraylist

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private void stopDetecting() {
        sensorManager.unregisterListener(listener,accelerometer);
    }

    private void confirmMeasure() {
        Intent i = new Intent(this, ConfirmMeasureCtrl.class);
        i.putExtra("PatientTag", (Parcelable) loginPatient);
        Bundle bundle = new Bundle();
        bundle.putString("SCG", results);
        i.putExtras(bundle);
        startActivity(i);
    }


}



