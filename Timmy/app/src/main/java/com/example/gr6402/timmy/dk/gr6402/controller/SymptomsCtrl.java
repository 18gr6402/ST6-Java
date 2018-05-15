package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;

public class SymptomsCtrl extends AppCompatActivity {

    private TextView anginaTxt;
    private Spinner anginaChoice;
    private TextView dyspneaTxt;
    private Spinner dyspneaChoice;
    private TextView fatigueTxt;
    private Spinner fatigueChoice;
    private TextView weightTxt;
    private EditText weightField;
    private TextView otherTxt;
    private EditText otherField;
    private Button btnOk;
    private Patient loginPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symptoms);
        anginaTxt = (TextView) findViewById(R.id.anginaTxt);
        anginaChoice = (Spinner) findViewById(R.id.anginaChoice);
        dyspneaTxt = (TextView) findViewById(R.id.dyspneaTxt);
        dyspneaChoice = (Spinner) findViewById(R.id.dyspneaChoice);
        fatigueTxt = (TextView) findViewById(R.id.fatigueTxt);
        fatigueChoice = (Spinner) findViewById(R.id.fatigueChoice);
        weightTxt = (TextView) findViewById(R.id.weightTxt);
        weightField = (EditText) findViewById(R.id.weightField);
        otherTxt = (TextView) findViewById(R.id.otherTxt);
        otherField = (EditText) findViewById(R.id.otherField);
        btnOk = (Button) findViewById(R.id.btnOk);

        //get intent, henter pakkerne der sendes fra menuen
        loginPatient = (Patient) getIntent().getParcelableExtra("PatientTag");

        //TODO Hent symptomer fra dagen før og indsæt i tekstfelterne, således disse kan genbruges.
    }

    public void handleOk(View view){
        //TODO Gem de indberettede symptomer med dags dato i databasen.
        //TODO Hvis det indberettede data ikke indsendes korrekt skal der komme en fejlmeddelelse og du skal føres tilbage til symptomindberetningen igen.
        Intent i = new Intent(this, MenuCtrl.class);
        i.putExtra("PatientTag", (Parcelable) loginPatient);
        startActivity(i);
    }
}
