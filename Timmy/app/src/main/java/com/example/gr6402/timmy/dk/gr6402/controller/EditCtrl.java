package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
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
    private Patient selectedPatient;
    private Bundle bun;
    private int val;

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

        // hvor kommer vi fra profile (val = 1) eller overview (val = 0)
        bun=getIntent().getExtras();
        val=bun.getInt("VAL");
        //get intent med overført data fra forrige view
        loginPractitioner = (Practitioner) getIntent().getParcelableExtra("PractitionerTag");
        if(val == 1) {
            loginPatient = (Patient) getIntent().getParcelableExtra("PatientTag");
        }else if(val == 0){
            selectedPatient = (Patient) getIntent().getParcelableExtra("selectedPatienTag");
        }

        showDetails();
    }

/*
Ændre view (synlighed på Field og knapper) og indsætter data (fra overført data) afhængig af det
 forgående view og hvem der logger ind.
 */
    public void showDetails(){
        if(val==1) {
            cprTxt.setVisibility(View.GONE);
            cprField.setVisibility(View.GONE);
            cprTxt2.setVisibility(View.GONE);
            cprField2.setVisibility(View.GONE);
            nyhaTxt.setVisibility(View.GONE);
            nyhaChoice.setVisibility(View.GONE);
            btnResetThreshold.setVisibility(View.GONE);

            if (loginPatient != null) {
            // todo get fornavn, efternavn og password fra database ud fra cpr gennem Patient.class metoder
            loginPatient.setFirstName("Bo");            //Dummydata todo slet
            loginPatient.setLastName("Hansen");         //Dummydata todo slet
            loginPatient.setPassword("bokode");         //Dummydata todo slet
            Toast.makeText(this, "Rediger Patient profiloplysninger", Toast.LENGTH_LONG).show();
            firstNameField.setText(loginPatient.getFirstName());
            lastNameField.setText(loginPatient.getLastName());
            } else{
            // todo get fornavn, efternavn og password fra database ud fra employmentID og clinincID gennem Practitioner.class metoder
            loginPractitioner.setFirstName("Steffen");      //Dummydata todo slet
            loginPractitioner.setLastName("Jensen");        //Dummydata todo slet
            loginPractitioner.setPassword("steffenkode");   //Dummydata todo slet
            Toast.makeText(this,"Rediger Læge profiloplysninger", Toast.LENGTH_LONG).show();
            firstNameField.setText(loginPractitioner.getFirstName());
            lastNameField.setText(loginPractitioner.getLastName());
            }

        }else if (val==0){
            firstNameTxt.setVisibility(View.GONE);
            firstNameField.setVisibility(View.GONE);
            lastNameTxt.setVisibility(View.GONE);
            lastNameField.setVisibility(View.GONE);
            passwordTxt.setVisibility(View.GONE);
            passwordField.setVisibility(View.GONE);
            passwordTxt2.setVisibility(View.GONE);
            passwordField2.setVisibility(View.GONE);
            Toast.makeText(this,"Rediger valgte patient", Toast.LENGTH_LONG).show();
            // todo læs cpr fra selectedPatient og sæt
            //cprField.setText(selectedPatient.getCpr());
            //cprField2.setText(selectedPatient.getCpr());
            // todo læs nyha fra database
        }

    }

    public void handleResetThreshold(View view){
        // todo sæt tærskelværdierne for selctedPatient til null i databsen gennem Patient.class metode.
    }

    public void handleOk(View view){
        // todo gem nye værdier i databasen under selectedPatient gennem gennem Patient.class metode.
    }
/*
Føre bruger tilbage til forgående view og sender egne oplysninger med.
 */
    public void handleCancel(View view){
        Intent i;
        if (val == 1) {
            i = new Intent(this, ProfileCtrl.class);
            if (loginPatient != null) {
                i.putExtra("PatientTag", (Parcelable) loginPatient);
            } else {
                i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
            }
            startActivity(i);
        } else if (val==0){
            i = new Intent(this, OverviewCtrl.class);
            i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
            startActivity(i);
        }
    }
}
