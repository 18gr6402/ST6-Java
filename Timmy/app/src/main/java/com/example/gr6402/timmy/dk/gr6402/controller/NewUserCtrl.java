package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;

public class NewUserCtrl extends AppCompatActivity {

    private CheckBox cbCheckPractitioner;
    private TextView clinicTxt;
    private Spinner clinicChoice;
    private TextView employmentIDTxt;
    private EditText employmentIDField;
    private TextView cprTxt;
    private EditText cprField;
    private TextView firstNameTxt;
    private EditText firstNameField;
    private TextView lastNameTxt;
    private EditText lastNameField;
    private TextView passwordTxt;
    private EditText passwordField;
    private TextView passwordTxt2;
    private EditText passwordField2;
    private Button btnOk;
    private Button btnCancel;
    private Practitioner loginPractitioner;
    private Patient loginPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newuser);
        cbCheckPractitioner = (CheckBox) findViewById(R.id.cbCheckPractitioner);
        clinicTxt = (TextView) findViewById(R.id.clinicTxt);
        clinicChoice = (Spinner) findViewById(R.id.clinicChoice);
        employmentIDTxt = (TextView) findViewById(R.id.employmentIDTxt);
        employmentIDField = (EditText) findViewById(R.id.employmentIDField);
        cprTxt = (TextView) findViewById(R.id.cprTxt);
        cprField = (EditText) findViewById(R.id.cprField);
        firstNameTxt = (TextView) findViewById(R.id.firstNameTxt);
        firstNameField = (EditText) findViewById(R.id.firstNameField);
        lastNameTxt = (TextView) findViewById(R.id.lastNameTxt);
        lastNameField = (EditText) findViewById(R.id.lastNameField);
        passwordTxt = (TextView) findViewById(R.id.passwordTxt);
        passwordField = (EditText) findViewById(R.id.passwordField);
        passwordTxt2 = (TextView) findViewById(R.id.passwordTxt2);
        passwordField2 = (EditText) findViewById(R.id.passwordField2);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);
    }


    public void checkPractitioner(View view){
        if (cbCheckPractitioner.isChecked()) {
            cprTxt.setVisibility(View.GONE);
            cprField.setVisibility(View.GONE);
        }
        else {
            clinicTxt.setVisibility(View.GONE);
            clinicChoice.setVisibility(View.GONE);
            employmentIDTxt.setVisibility(View.GONE);
            employmentIDField.setVisibility(View.GONE);
        }
    }

    public void handleOk(View view){
        Intent i = new Intent(this, MenuCtrl.class);
        if (cbCheckPractitioner.isChecked()) {
            Practitioner loginUser = new Practitioner(Integer.parseInt(employmentIDField.getText().toString()), false,1); //instancering af lægen, dummy todo mangler at gemme ny læge i databasen
            i.putExtra("PractitionerTag", (Parcelable) loginUser);
        } else {
            Patient loginUser = new Patient(Integer.parseInt(cprField.getText().toString()), "klasse 4", 12, 4); //instancering af patient, dummy todo mangler at gemme ny patient i databasen
            i.putExtra("PatientTag", (Parcelable) loginUser);
        }
        startActivity(i);
    }

    public void handleCancel(View view){
        Intent i = new Intent(this, LoginCtrl.class);
        startActivity(i);
    }
}