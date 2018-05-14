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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;
import com.example.gr6402.timmy.dk.gr6402.model.User;


public class LoginCtrl extends AppCompatActivity {
    // objekter i viewet defineres her som attributter, med type og id på objektet (vores eget valg).
    public CheckBox cbCheckPractitioner;
    public TextView clinincText;
    public Spinner clinincSpinner;
    public EditText userNameField;
    private Button btnLogin;
    private Button btnNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // forbinder java klassen med objektet i viewet
        cbCheckPractitioner = (CheckBox) findViewById(R.id.cbCheckPractitioner);
        clinincText = (TextView) findViewById(R.id.clinicText);
        clinincSpinner = (Spinner) findViewById(R.id.clinincSpinner);
        userNameField = (EditText) findViewById(R.id.userNameField);
        btnNewUser = (Button) findViewById(R.id.btnNewUser);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

/*
Ændre på vinduet (syndligheden af clinic dropdown og standart indholdet i brugernavn feltet) når der
 klikkes på checkboksen cbCheckPractitioner
 */
    public void checkPractitioner(View view){
        if (cbCheckPractitioner.isChecked()) {
            clinincText.setVisibility(View.VISIBLE);
            clinincSpinner.setVisibility(View.VISIBLE);
            userNameField.setText("Ansættelses ID");
        }else {
            clinincText.setVisibility(View.GONE);
            clinincSpinner.setVisibility(View.GONE);
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
        Intent i = new Intent(this,MenuCtrl.class);
        if (cbCheckPractitioner.isChecked()) {
            Practitioner loginUser = new Practitioner(Integer.parseInt(userNameField.getText().toString()), true); //instancering af lægen, dummy todo mangler hente fra databasesjovet
            i.putExtra("PractitionerTag",(Parcelable) loginUser);
            }

            else {
            Patient loginUser = new Patient(Integer.parseInt(userNameField.getText().toString()),"klasse 4",12, 4); //instancering af patient, dummy todo mangler hente fra databasesjovet
            i.putExtra("PatientTag",(Parcelable) loginUser);
        }
        startActivity(i);
    }

/*
Åbner vinduet for registrering af ny bruger.
 */
    public void handleNewUser(View view){

        Intent in_newview = new Intent(this, NewCtrl.class);
        startActivity(in_newview);
    }
}