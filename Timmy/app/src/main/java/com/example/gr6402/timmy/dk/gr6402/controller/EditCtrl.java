package com.example.gr6402.timmy.dk.gr6402.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;

public class EditCtrl extends AppCompatActivity{

    private TextView cprTxt;
    private EditText cprField;
    private TextView cprTxt2;
    private EditText cprField2;
    private TextView nyhaTxt;
    private Spinner nyhaChoice;
    private TextView firstNameTxt;
    private EditText firstNameField;
    private TextView lastNameTxt;
    private EditText lastNameField;
    private TextView passwordTxt;
    private EditText passwordField;
    private TextView passwordTxt2;
    private EditText passwordField2;
    private Button btnResetThreshold;
    private Button btnOk;
    private Button btnCancel;
    private Practitioner loginPractitioner;
    private Patient loginPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        cprTxt = (TextView) findViewById(R.id.cprTxt);
        cprField = (EditText) findViewById(R.id.cprField);
        cprTxt2 = (TextView) findViewById(R.id.cprTxt2);
        cprField2 = (EditText) findViewById(R.id.cprField2);
        nyhaTxt = (TextView) findViewById(R.id.nyhaTxt);
        nyhaChoice = (Spinner) findViewById(R.id.nyhaChoice);
        firstNameTxt = (TextView) findViewById(R.id.firstNameTxt);
        firstNameField = (EditText) findViewById(R.id.firstNameField);
        lastNameTxt = (TextView) findViewById(R.id.lastNameTxt);
        lastNameField = (EditText) findViewById(R.id.lastNameField);
        passwordTxt = (TextView) findViewById(R.id.passwordTxt);
        passwordField = (EditText) findViewById(R.id.passwordField);
        passwordTxt2 = (TextView) findViewById(R.id.passwordTxt2);
        passwordField2 = (EditText) findViewById(R.id.passwordField2);
        btnResetThreshold = (Button) findViewById(R.id.btnResetThreshold);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        //get intent
        loginPractitioner = (Practitioner) getIntent().getParcelableExtra("PractitionerTag");
        loginPatient = (Patient) getIntent().getParcelableExtra("PatientTag");
    }


    public void showDetails(){

        if (loginPatient != null) {
            // todo get fornavn, efternavn og password fra database gennem Patient
            loginPatient.setFirstName("Bo");            //Dummydata todo slet
            loginPatient.setLastName("Hansen");         //Dummydata todo slet
            loginPatient.setPassword("bokode");         //Dummydata todo slet
            Toast.makeText(this, "Rediger Patient profiloplysninger", Toast.LENGTH_LONG).show();
            cprLabel.setText(loginPatient.getCpr().toString());
            employmentIDText.setVisibility(View.GONE);
            employmentIDLabel.setVisibility(View.GONE);
            firstNameField.setText(loginPatient.getFirstName());
            lastNameField.setText(loginPatient.getLastName());
            passwordField.setText(loginPatient.getPassword());
        }
        else{
            // todo get fornavn, efternavn og password fra database gennem Practitioner
            loginPractitioner.setFirstName("Steffen");      //Dummydata todo slet
            loginPractitioner.setLastName("Jensen");        //Dummydata todo slet
            loginPractitioner.setPassword("steffenkode");   //Dummydata todo slet
            Toast.makeText(this,"Rediger Læge profiloplysninger", Toast.LENGTH_LONG).show();
            cprText.setVisibility(View.GONE);
            cprLabel.setVisibility(View.GONE);
            employmentIDLabel.setText(loginPractitioner.getEmploymentID().toString());
            firstNameLabel.setText(loginPractitioner.getFirstName());
            lastNameLabel.setText(loginPractitioner.getLastName());
            passwordLabel.setText(loginPractitioner.getPassword());
        }
    }

    public void handleResetThreshold(View view){

    }

    public void handleOk(View view){

    }

    public void handleCancel(View view){

    }




}
