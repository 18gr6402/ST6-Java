package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;
import com.example.gr6402.timmy.dk.gr6402.myinterface.DatabaseOperations;
import com.example.gr6402.timmy.dk.gr6402.myinterface.DatabaseTask;

public class ProfileCtrl extends AppCompatActivity implements DatabaseOperations{

    private TextView cprText;
    private TextView cprLabel;
    private TextView employmentIDText;
    private TextView employmentIDLabel;
    private TextView firstNameLabel;
    private TextView lastNameLabel;
    private TextView passwordLabel;
    private Button btnUpdate;
    private Button btnBack;
    private Patient loginPatient;
    private Practitioner loginPractitioner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        //forbind attributter og viewelementer
        cprText = (TextView) findViewById(R.id.cprText);
        cprLabel = (TextView) findViewById(R.id.cprLabel);
        employmentIDLabel = (TextView) findViewById(R.id.employmentIDLabel);
        employmentIDText = (TextView) findViewById(R.id.employmentIDText);
        firstNameLabel = (TextView) findViewById(R.id.firstNameLabel);
        lastNameLabel = (TextView) findViewById(R.id.lastNameLabel);
        passwordLabel = (TextView) findViewById(R.id.passwordLabel);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnBack = (Button) findViewById(R.id.btnBack);

        //get intent
        loginPractitioner = (Practitioner) getIntent().getParcelableExtra("PractitionerTag");
        loginPatient = (Patient) getIntent().getParcelableExtra("PatientTag");

        String type = "profile";
        if (loginPatient != null) {
            String id = loginPatient.getCpr().toString();
            DatabaseTask databaseTask = new DatabaseTask(this);
            databaseTask.execute(type,id);
        }

        else {
            String id = loginPractitioner.getEmploymentID().toString();
            String clinicID = loginPractitioner.getClinincID().toString();
            DatabaseTask databaseTask = new DatabaseTask(this);
            databaseTask.execute(type,id,clinicID);
        }
    }

    public void showDetails(String[] separated){

        if (loginPatient != null) {
            loginPatient.setFirstName(separated[0]);
            loginPatient.setLastName(separated[1]);
            loginPatient.setPassword(separated[2]);

            Toast.makeText(this, "Patient profiloplysninger", Toast.LENGTH_LONG).show();
            cprLabel.setText(loginPatient.getCpr().toString());
            employmentIDText.setVisibility(View.GONE);
            employmentIDLabel.setVisibility(View.GONE);
            firstNameLabel.setText(loginPatient.getFirstName());
            lastNameLabel.setText(loginPatient.getLastName());
            passwordLabel.setText(loginPatient.getPassword());
        }
        else{
            loginPractitioner.setFirstName(separated[0]);
            loginPractitioner.setLastName(separated[1]);
            loginPractitioner.setPassword(separated[2]);
            Toast.makeText(this,"Læge profiloplysninger", Toast.LENGTH_LONG).show();
            cprText.setVisibility(View.GONE);
            cprLabel.setVisibility(View.GONE);
            employmentIDLabel.setText(loginPractitioner.getEmploymentID().toString());
            firstNameLabel.setText(loginPractitioner.getFirstName());
            lastNameLabel.setText(loginPractitioner.getLastName());
            passwordLabel.setText(loginPractitioner.getPassword());
        }
    }


    public void handleUpdate(View view){
        Intent i = new Intent(this,EditUserCtrl.class);
        //til at fortælle vi kommer fra profile (val = 1) og ikke patientOverview (val = 0)
        Bundle bundle = new Bundle();
        bundle.putInt("VAL", 1);
        i.putExtras(bundle);

        if (loginPatient != null) {
            i.putExtra("PatientTag",(Parcelable) loginPatient);
        }

        else {
            i.putExtra("PractitionerTag",(Parcelable) loginPractitioner);
        }
        startActivity(i);
    }


    public void handleBack(View view){
        Intent i = new Intent(this,MainMenuCtrl.class);
        if (loginPatient != null) {
            i.putExtra("PatientTag",(Parcelable) loginPatient);
        }

        else {
            i.putExtra("PractitionerTag",(Parcelable) loginPractitioner);
        }
        startActivity(i);
    }

    @Override
    public void onTaskCompleted(String output) {
        String[] separated = output.split(",");
        showDetails(separated);
    }
}