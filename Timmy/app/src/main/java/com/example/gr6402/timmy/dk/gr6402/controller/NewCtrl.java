package com.example.gr6402.timmy.dk.gr6402.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gr6402.timmy.R;

public class NewCtrl extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newview);
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

    }

    public void handleOk(View view){

    }

    public void handleCancel(View view){

    }

}
