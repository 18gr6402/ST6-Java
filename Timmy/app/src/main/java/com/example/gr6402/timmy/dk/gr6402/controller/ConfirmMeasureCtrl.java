package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;

public class ConfirmMeasureCtrl extends AppCompatActivity {

    private TextView confirmTxt;
    private Button btnConfirm;
    private Button btnRetake;
    private Patient loginPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmmeasure);
        confirmTxt = (TextView) findViewById(R.id.confirmTxt);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnRetake = (Button) findViewById(R.id.btnRetake);

        //get intent, henter pakkerne der sendes fra menuen
        loginPatient = (Patient) getIntent().getParcelableExtra("PatientTag");
    }

    public void handleConfirm(View view){
        Intent i = new Intent(this, SymptomsCtrl.class);
        i.putExtra("PatientTag", (Parcelable) loginPatient);
        startActivity(i);
    }

    public void handleRetake(View view){
        Intent i = new Intent(this, MeasureCtrl.class);
        i.putExtra("PatientTag", (Parcelable) loginPatient);
        startActivity(i);
    }
}
