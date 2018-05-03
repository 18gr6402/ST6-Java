package com.example.gr6402.timmy;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class LoginLaege extends AppCompatActivity {

    String [] SPINNERLIST={"1","2","3","4"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_laege);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,SPINNERLIST);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(R.id.TextKlinik);
        betterSpinner.setAdapter(arrayAdapter);


    }

    public void OnClickBox(View view) {

        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }


}
