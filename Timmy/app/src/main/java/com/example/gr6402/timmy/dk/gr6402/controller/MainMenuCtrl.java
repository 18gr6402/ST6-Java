package com.example.gr6402.timmy.dk.gr6402.controller;

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

public class MainMenuCtrl extends AppCompatActivity {

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
        setContentView(R.layout.mainmenu);

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
        } else{
            Boolean adm = loginPractitioner.getAdministrator();
            if (!adm){
                Toast.makeText(this, "Logget ind som Læge", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Logget ind som Administrator", Toast.LENGTH_LONG).show();
            }
        }
    }


    public void handleProfile (View view){
        Intent i = new Intent(this,ProfileCtrl.class);
        if (loginPatient != null) {
            i.putExtra("PatientTag",(Parcelable) loginPatient);
        } else{
            i.putExtra("PractitionerTag",(Parcelable) loginPractitioner);
        }
        startActivity(i);
    }


    public void handleWarnings (View view){
        Intent i = new Intent(this,WarningsCtrl.class);
        i.putExtra("PractitionerTag",(Parcelable) loginPractitioner);
        startActivity(i);
    }


    public void handlePatientOverview (View view){
        Intent i = new Intent(this,OverviewCtrl.class);
        i.putExtra("PractitionerTag",(Parcelable) loginPractitioner);
        Bundle bundle = new Bundle();
        bundle.putInt("VAL", 1);    // menu:Patientkartotek til overview -> val = 1
        i.putExtras(bundle);
        startActivity(i);
    }


    public void handlePractitionerOverview (View view){
        Intent i = new Intent(this,OverviewCtrl.class);
        i.putExtra("PractitionerTag",(Parcelable) loginPractitioner);
        Bundle bundle = new Bundle();
        bundle.putInt("VAL", 0);    // menu:Lægekartotek til overview -> val = 0
        i.putExtras(bundle);
        startActivity(i);
    }


    public void handleCollectSCG (View view){
        Intent i = new Intent(this,CollectSCGCtrl.class);
        i.putExtra("PatientTag",(Parcelable) loginPatient);
        startActivity(i);
    }


    public void handleGuide(View view){
        Intent i = new Intent(this,GuideCtrl.class);
        i.putExtra("PractitionerTag",(Parcelable) loginPractitioner);
        Bundle bundle = new Bundle();
        bundle.putInt("VAL", 1);    // menu til guide -> val = 1
        i.putExtras(bundle);
        startActivity(i);
    }


    public void handleLogout (View view){
        Intent i = new Intent(this,LoginCtrl.class);
        startActivity(i);
        finish();
    }

    public void loginUser(){
        // undersøg om det er patient der logger ind
        try {
            loginPatient = (Patient) getIntent().getParcelableExtra("PatientTag");
            Long cpr = loginPatient.getCpr();    //til test, skal slettes
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
