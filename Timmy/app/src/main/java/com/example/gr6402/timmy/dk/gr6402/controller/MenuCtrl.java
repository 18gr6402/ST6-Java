package com.example.gr6402.timmy.dk.gr6402.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;
import com.example.gr6402.timmy.dk.gr6402.model.User;

public class MenuCtrl extends AppCompatActivity {

    private Button btnProfile;
    private Button btnWarnings;
    private Button btnPatientOverview;
    private Button btnPractitionerOverview;
    private Button btnCollectSCG;
    private Button btnGuide;
    private Button btnLogout;
    private Patient loginPatient;
    private Practitioner loginPractitioner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        // Forbind Button i attribut og layout
        btnProfile = (Button) findViewById(R.id.btnProfile);
        btnWarnings = (Button) findViewById(R.id.btnWarnings);
        btnPatientOverview = (Button) findViewById(R.id.btnPatientOverview);
        btnPractitionerOverview = (Button) findViewById(R.id.btnPractitionerOverview);
        btnCollectSCG = (Button) findViewById(R.id.btnCollectSCG);
        btnGuide = (Button) findViewById(R.id.btnGuide);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        loginUser();

        // koden til skel mellem læge og patient
        if (loginPatient != null) {
            Toast.makeText(this, "Logget ind som Patient", Toast.LENGTH_LONG).show();
            }
            else{
            Toast.makeText(this,"Logget ind som Læge", Toast.LENGTH_LONG).show();
        }

    }

    public void handleProfile (View view){
        Intent i = new Intent(this,ProfileCtrl.class);
        if (loginPatient != null) {
            i.putExtra("PatientTag",(Parcelable) loginPatient);
        }
        else{
            i.putExtra("PractitionerTag",(Parcelable) loginPractitioner);
        }
        startActivity(i);
    }

    public void handleWarnings (View view){

    }

    public void handleOverview (View view){

    }

    public void handleCollectSCG (View view){

    }

    public void handleGuide(View view){

    }

    public void handleLogout (View view){
        Intent i = new Intent(this,LoginCtrl.class);
        startActivity(i);
    }

    public void loginUser(){
        // undersøg om det er patient der logger ind
        try {
            loginPatient = (Patient) getIntent().getParcelableExtra("PatientTag");
            Integer cpr = loginPatient.getCpr();    //til test, skal slettes
            System.err.println("cpr="+cpr);         //til test, skal slettes
            btnWarnings.setVisibility(View.GONE);
            btnPractitionerOverview.setVisibility(View.GONE);
            btnPatientOverview.setVisibility(View.GONE);
            btnGuide.setVisibility(View.GONE);
        }
        catch (Exception e){
            System.out.println("Login som Læge");
        }
        // undersøg om det er læge der logger ind
        try{
            loginPractitioner = (Practitioner) getIntent().getParcelableExtra("PractitionerTag");
            Integer ID = loginPractitioner.getEmploymentID();   //til test, skal slettes
            Boolean adm = loginPractitioner.getAdministrator();
            System.err.println("ID="+ID);                       //til test, skal slettes
            btnCollectSCG.setVisibility(View.GONE);
            if (!adm){
                btnPractitionerOverview.setVisibility(View.GONE);
            }
        }
        catch (Exception e){
            System.out.println("Login som Patient");
        }
    }
}
