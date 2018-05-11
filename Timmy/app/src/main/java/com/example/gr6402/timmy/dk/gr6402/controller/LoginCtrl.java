package com.example.gr6402.timmy.dk.gr6402.controller;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
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

        if (cbCheckClinic.isChecked()) {
            //Toast.makeText(this, "Loui er gud", Toast.LENGTH_SHORT).show();




            }
           else {

            Patient loginUser = new Patient(1223334444);
            Intent i = new Intent(this,MenuCtrl.class);
            i.putExtra("PatientTag",loginUser);
            startActivity(i);


               }

        Intent in_menu = new Intent(this, MenuCtrl.class);
        startActivity(in_menu);
    }




    public void handleCheckClinic(View view){
        //todo skal synliggøre klinik feltet når klikket på
    }


    public void handleNewUser(View view){
        Intent in_newview = new Intent(this, NewCtrl.class);
        startActivity(in_newview);
    }
}
