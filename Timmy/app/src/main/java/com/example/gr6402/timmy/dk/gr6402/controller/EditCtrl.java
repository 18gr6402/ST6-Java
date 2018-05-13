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

import com.example.gr6402.timmy.R;

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
    }

    public void handleResetThreshold(View view){

    }

    public void handleOk(View view){

    }

    public void handleCancel(View view){

    }




}
