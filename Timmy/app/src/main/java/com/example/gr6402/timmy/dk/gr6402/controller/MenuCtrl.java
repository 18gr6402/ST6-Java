package com.example.gr6402.timmy.dk.gr6402.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;
import com.example.gr6402.timmy.dk.gr6402.model.User;

public class MenuCtrl extends Activity {

    private Button btnProfile;
    private Button btnWarnings;
    private Button btnPatientOverview;
    private Button btnPractitionerOverview;
    private Button btnCollectSCG;
    private Button btnGuide;
    private Button btnLogout;


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

        // undersøg om det er patient der logger ind
        try {
            Patient loginUser = (Patient) getIntent().getParcelableExtra("PatientTag");
            Integer cpr = loginUser.getCpr();   //til test, skal slettes
            System.err.println("cpr="+cpr);     //til test, skal slettes
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
            Practitioner loginUser = (Practitioner) getIntent().getParcelableExtra("PractitionerTag");
            Integer ID = loginUser.getEmploymentID();   //til test, skal slettes
            Boolean adm = loginUser.getAdministrator();
            System.err.println("ID="+ID);               //til test, skal slettes
            btnCollectSCG.setVisibility(View.GONE);
            if (!adm){
                btnPractitionerOverview.setVisibility(View.GONE);
            }
        }
        catch (Exception e){
            System.out.println("Login som Patient");
        }


    }

    public void handleProfile (View view){

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


}
