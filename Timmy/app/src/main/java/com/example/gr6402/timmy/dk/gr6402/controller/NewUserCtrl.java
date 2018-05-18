package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;
import com.example.gr6402.timmy.dk.gr6402.myinterface.DatabaseOperations;
import com.example.gr6402.timmy.dk.gr6402.myinterface.DatabaseTask;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class NewUserCtrl extends AppCompatActivity implements DatabaseOperations, AdapterView.OnItemSelectedListener{

    private CheckBox cbCheckPractitioner;
    private TextView clinicTxt;
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
    private String[] separated;
    private String clinicID;

    // This is the declaration part for the spinner
    private InputStream is = null;
    private String result = null;
    private String line = null;

    private String[] name;

    public Spinner clinicChoice;

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void loadClinicsSpinner(String[] separated) {
        // Her forsøges at lave en spinner med dummy data
        clinicChoice.setOnItemSelectedListener(this); // Spinner click listener

        List<String> clinics = new ArrayList<String>();  // Spinner Drop down elements
        clinics.add("Vælg klinik");
        for (int i=0; i<separated.length; i+=2){
            clinics.add(separated[i]);
        }

        // Creating adapter for spinner, som henter data fra vores clinic array
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, clinics);

        // Drop down layout style - list view with radio button
        // dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        clinicChoice.setAdapter(dataAdapter);
    }


    public void checkPractitioner(View view){
        if (cbCheckPractitioner.isChecked()) {
            clinicTxt.setVisibility(View.VISIBLE);
            clinicChoice.setVisibility(View.VISIBLE);
            employmentIDTxt.setVisibility(View.VISIBLE);
            employmentIDField.setVisibility(View.VISIBLE);
            cprTxt.setVisibility(View.GONE);
            cprField.setVisibility(View.GONE);
            String type = "loadClinics";
            DatabaseTask databaseTask = new DatabaseTask(this);
            databaseTask.execute(type);
        }
        else {
            clinicTxt.setVisibility(View.GONE);
            clinicChoice.setVisibility(View.GONE);
            employmentIDTxt.setVisibility(View.GONE);
            employmentIDField.setVisibility(View.GONE);
            cprTxt.setVisibility(View.VISIBLE);
            cprField.setVisibility(View.VISIBLE);
        }
    }

    public void handleOk(View view){
        String firstName = firstNameField.getText().toString();
        String lastName = lastNameField.getText().toString();
        String password = passwordField.getText().toString();
        String password2 = passwordField2.getText().toString();
        String type = "update_newuser";
        if (password.equals(password2)) {
            if (cbCheckPractitioner.isChecked()) {
                String employmentID = employmentIDField.getText().toString();
                // Vi definerer klinikID ud det den valgte klinik i spinneren
                clinicID = separated[clinicChoice.getSelectedItemPosition() + (clinicChoice.getSelectedItemPosition() - 1)];
                DatabaseTask databaseTask = new DatabaseTask(this);
                databaseTask.execute(type, employmentID, firstName, lastName, password, clinicID);
            }
            else {
                String cpr = cprField.getText().toString();
                DatabaseTask databaseTask = new DatabaseTask(this);
                databaseTask.execute(type, cpr, firstName, lastName, password);
            }
        }
        else {
            Toast.makeText(this, "Adgangskoder ikke ens", Toast.LENGTH_LONG).show();
        }
    }

    public void handleCancel(View view){
        Intent i = new Intent(this, LoginCtrl.class);
        startActivity(i);
    }

    @Override
    public void onTaskCompleted(String output) {
        if (output.equals("TRUE")) {
            Intent i = new Intent(this, MainMenuCtrl.class);
            if (cbCheckPractitioner.isChecked()) {
                Practitioner loginUser = new Practitioner(Integer.parseInt(employmentIDField.getText().toString()), false, Integer.parseInt(clinicID));
                i.putExtra("PractitionerTag", (Parcelable) loginUser);
            } else {
                Patient loginUser = new Patient(Integer.parseInt(cprField.getText().toString()), "klasse 4", 12, 4); // TODO Nyha, symptomer og mpi er dummy fordi lægefunktionen og støttesystem ikke er implementeret.
                i.putExtra("PatientTag", (Parcelable) loginUser);
            }
            startActivity(i);
        }
        else if(output.equals("administrator")){
            Intent i = new Intent(this, MainMenuCtrl.class);
            Practitioner loginUser = new Practitioner(Integer.parseInt(employmentIDField.getText().toString()), true, Integer.parseInt(clinicID));
            i.putExtra("PractitionerTag", (Parcelable) loginUser);
            startActivity(i);
        }
        else if (output.equals("NOID")){
            Toast.makeText(this, "Du er ikke oprettet i systemet, kontakt din læge.", Toast.LENGTH_LONG).show();
        }
        else if (output.equals("SAVED")) {
            Toast.makeText(this, "Du er allerede oprettet som bruger.", Toast.LENGTH_LONG) .show();
        }
        else if (output.equals("FALSE")) {
            Toast.makeText(this, "Tjek internetforbindelse", Toast.LENGTH_LONG).show();
        }

        else {
            separated = output.split(",");
            loadClinicsSpinner(separated);
        }
    }
}