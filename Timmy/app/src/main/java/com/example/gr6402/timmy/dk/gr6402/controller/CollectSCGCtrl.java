package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;

public class CollectSCGCtrl extends AppCompatActivity {

    private Button btnViewGuide;
    private Button btnMeasure;
    private Button btnBack;
    private Patient loginPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collectscg);
        btnViewGuide = (Button) findViewById(R.id.btnViewGuide);
        btnMeasure = (Button) findViewById(R.id.btnMeasure);
        btnBack = (Button) findViewById(R.id.btnBack);

        //get intent, henter pakkerne der sendes fra menuen
        loginPatient = (Patient) getIntent().getParcelableExtra("PatientTag");

    }


    public void handleGuide(View view) {
        Intent i = new Intent(this, GuideCtrl.class);
        i.putExtra("PatientTag", (Parcelable) loginPatient);
        Bundle bundle = new Bundle();
        bundle.putInt("VAL", 0); // fra patient scg-målingsmenuen til guide val=0
        i.putExtras(bundle);
        startActivity(i);
        }


    public void handleMeasure(View view){
        Intent i = new Intent(this, MeasureCtrl.class);
        i.putExtra("PatientTag", (Parcelable) loginPatient);
        startActivity(i);
    }


    public void handleBack(View view){
        Intent i = new Intent(this, MainMenuCtrl.class);
        i.putExtra("PatientTag", (Parcelable) loginPatient);
        startActivity(i);
    }
}
