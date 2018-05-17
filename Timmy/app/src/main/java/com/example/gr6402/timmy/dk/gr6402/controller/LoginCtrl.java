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
import java.util.Arrays;
import java.util.List;


public class LoginCtrl extends AppCompatActivity implements DatabaseOperations, AdapterView.OnItemSelectedListener {
    // objekter i viewet defineres her som attributter, med type og id på objektet (vores eget valg).
    public CheckBox cbCheckPractitioner;
    public TextView clinicTxt;
    public TextView userNameTxt;
    public EditText userNameField;
    public TextView passwordTxt;
    public EditText passwordField;
    private Button btnLogin;
    private Button btnNewUser;
    private String clinicID;
    private String[] separated;

    // This is the declaration part for the spinner
    private InputStream is = null;
    private String result = null;
    private String line = null;

    private String[] name;

    public Spinner clinicChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // forbinder java klassen med objektet i viewet
        cbCheckPractitioner = (CheckBox) findViewById(R.id.cbCheckPractitioner);
        clinicTxt = (TextView) findViewById(R.id.clinicTxt);
        clinicChoice = (Spinner) findViewById(R.id.clinicChoice); //Here we define the spinner
        userNameField = (EditText) findViewById(R.id.userNameField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        btnNewUser = (Button) findViewById(R.id.btnNewUser);
        btnLogin = (Button) findViewById(R.id.btnLogin);
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


/*
Ændre på vinduet (syndligheden af clinic dropdown og standard indholdet i brugernavn feltet) når der
 klikkes på checkboksen cbCheckPractitioner
 */
    public void checkPractitioner(View view){
        if (cbCheckPractitioner.isChecked()) {
            clinicTxt.setVisibility(View.VISIBLE);
            clinicChoice.setVisibility(View.VISIBLE);
            userNameField.setText("Ansættelses ID");
            String type = "loadClinics";
            DatabaseTask databaseTask = new DatabaseTask(this);
            databaseTask.execute(type);
        }else {
            clinicTxt.setVisibility(View.GONE);
            clinicChoice.setVisibility(View.GONE);
            userNameField.setText("CPR");
        }
    }

/*
Metoden rydder textfeltet userNameField når dette vælges
 */
    public void clearText(View view){
        userNameField.setText("");
    }

/*
Undersøger om checkBox cbChechPractitioner er valgt og læser dataen fra felterne til håndtereing af
login. Udføre den tilhørende handling for intent af næste menu vindue.
 */
    public void handleLogin (View view){
        String userName = userNameField.getText().toString();
        String password = passwordField.getText().toString();
        String type = "login";
        if (cbCheckPractitioner.isChecked()) {
            // Vi definerer klinikID ud det den valgte klinik i spinneren
            clinicID = separated[clinicChoice.getSelectedItemPosition()+(clinicChoice.getSelectedItemPosition()-1)];
            DatabaseTask databaseTask = new DatabaseTask(this);
            databaseTask.execute(type,userName,password,clinicID);
            }

            else {
            DatabaseTask databaseTask = new DatabaseTask(this);
            databaseTask.execute(type,userName,password);
        }
    }

/*
Åbner vinduet for registrering af ny bruger.
 */
    public void handleNewUser(View view){
        Intent in_newview = new Intent(this, NewUserCtrl.class);
        startActivity(in_newview);
    }

    @Override
    public void onTaskCompleted(String output) {
        if (output.equals("TRUE")) {
            Intent i = new Intent(this, MainMenuCtrl.class);
            if (cbCheckPractitioner.isChecked()) {
                Practitioner loginUser = new Practitioner(Integer.parseInt(userNameField.getText().toString()), false, Integer.parseInt(clinicID)); //instancering af lægen, dummy todo mangler hente fra databasesjovet
                i.putExtra("PractitionerTag", (Parcelable) loginUser);
            } else {
                Patient loginUser = new Patient(Integer.parseInt(userNameField.getText().toString()), "klasse 4", 12, 4); //instancering af patient, dummy todo mangler hente fra databasesjovet
                i.putExtra("PatientTag", (Parcelable) loginUser);
            }
            startActivity(i);
        }
        else if(output.equals("administrator")){
            Intent i = new Intent(this, MainMenuCtrl.class);
            Practitioner loginUser = new Practitioner(Integer.parseInt(userNameField.getText().toString()), true, Integer.parseInt(clinicID)); //instancering af lægen, dummy todo mangler hente fra databasesjovet
            i.putExtra("PractitionerTag", (Parcelable) loginUser);
            startActivity(i);
        }
        else if (output.equals("FALSE")){
            Toast.makeText(this, "Forkert loginoplysninger", Toast.LENGTH_LONG).show();
        }
        else {
            separated = output.split(",");
            loadClinicsSpinner(separated);
        }
    }

}
