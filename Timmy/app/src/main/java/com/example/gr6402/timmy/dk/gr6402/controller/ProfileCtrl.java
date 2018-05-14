package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;

public class ProfileCtrl extends AppCompatActivity {

    private TextView cprText;
    private TextView cprLabel;
    private TextView employmentIDText;
    private TextView employmentIDLabel;
    private TextView firstNameLabel;
    private TextView lastNameLabel;
    private TextView passwordLabel;
    private Button btnUpdate;
    private Button btnBack;
    private Patient loginPatient;
    private Practitioner loginPractitioner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        //forbind attributter og viewelementer
        cprText = (TextView) findViewById(R.id.cprText);
        cprLabel = (TextView) findViewById(R.id.cprLabel);
        employmentIDLabel = (TextView) findViewById(R.id.employmentIDLabel);
        employmentIDText = (TextView) findViewById(R.id.employmentIDText);
        firstNameLabel = (TextView) findViewById(R.id.firstNameLabel);
        lastNameLabel = (TextView) findViewById(R.id.lastNameLabel);
        passwordLabel = (TextView) findViewById(R.id.passwordLabel);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnBack = (Button) findViewById(R.id.btnBack);

        //get intent
        loginPractitioner = (Practitioner) getIntent().getParcelableExtra("PractitionerTag");
        loginPatient = (Patient) getIntent().getParcelableExtra("PatientTag");

        showDetails();
    }


    public void showDetails(){

        if (loginPatient != null) {
            // todo get fornavn, efternavn og password fra database gennem Patient
            loginPatient.setFirstName("Bo");            //Dummydata todo slet
            loginPatient.setLastName("Hansen");         //Dummydata todo slet
            loginPatient.setPassword("bokode");         //Dummydata todo slet
            Toast.makeText(this, "Patient profiloplysninger", Toast.LENGTH_LONG).show();
            cprLabel.setText(loginPatient.getCpr().toString());
            employmentIDText.setVisibility(View.GONE);
            employmentIDLabel.setVisibility(View.GONE);
            firstNameLabel.setText(loginPatient.getFirstName());
            lastNameLabel.setText(loginPatient.getLastName());
            passwordLabel.setText(loginPatient.getPassword());
        }
        else{
            // todo get fornavn, efternavn og password fra database gennem Practitioner
            loginPractitioner.setFirstName("Steffen");      //Dummydata todo slet
            loginPractitioner.setLastName("Jensen");        //Dummydata todo slet
            loginPractitioner.setPassword("steffenkode");   //Dummydata todo slet
            Toast.makeText(this,"Læge profiloplysninger", Toast.LENGTH_LONG).show();
            cprText.setVisibility(View.GONE);
            cprLabel.setVisibility(View.GONE);
            employmentIDLabel.setText(loginPractitioner.getEmploymentID().toString());
            firstNameLabel.setText(loginPractitioner.getFirstName());
            lastNameLabel.setText(loginPractitioner.getLastName());
            passwordLabel.setText(loginPractitioner.getPassword());
        }
    }


    public void handleUpdate(View view){
        Intent i = new Intent(this,EditCtrl.class);
        if (loginPatient != null) {
            i.putExtra("PatientTag",(Parcelable) loginPatient);
        }

        else {
            i.putExtra("PractitionerTag",(Parcelable) loginPractitioner);
        }
        startActivity(i);
    }


    public void handleBack(View view){
        Intent i = new Intent(this,MenuCtrl.class);
        if (loginPatient != null) {
            i.putExtra("PatientTag",(Parcelable) loginPatient);
        }

        else {
            i.putExtra("PractitionerTag",(Parcelable) loginPractitioner);
        }
        startActivity(i);
    }

}