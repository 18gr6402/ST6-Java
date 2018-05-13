package com.example.gr6402.timmy.dk.gr6402.controller;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;
import com.example.gr6402.timmy.dk.gr6402.model.User;


public class LoginCtrl extends AppCompatActivity {
    // objekter i viewet defineres her som attributter, med type og id på objektet.
    private Button btnLogin;
    public CheckBox cbCheckClinic;
    private Button btnNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        cbCheckClinic = (CheckBox) findViewById(R.id.cbCheckClinic); // forbinder java klassen med objektet i viewet
        btnNewUser = (Button) findViewById(R.id.btnNewUser);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    public void handleLogin (View view){
        Intent i = new Intent(this,MenuCtrl.class);
        if (cbCheckClinic.isChecked()) {
            Practitioner loginUser = new Practitioner(240694, true); //instancering af lægen, todo mangler hente fra databasesjovet

            i.putExtra("PractitionerTag",(Parcelable) loginUser);
            }

            else {
            Patient loginUser = new Patient(140693); //instancering af patient, todo mangler hente fra databasesjovet
            i.putExtra("PatientTag",(Parcelable) loginUser);
        }
        startActivity(i);
    }



    public void checkPractitioner(View view){

        //todo skal synliggøre klinik feltet når klikket på
    }


    public void handleNewUser(View view){

        Intent in_newview = new Intent(this, NewCtrl.class);
        startActivity(in_newview);
    }
}
