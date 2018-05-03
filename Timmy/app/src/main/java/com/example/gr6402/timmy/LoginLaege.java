package com.example.gr6402.timmy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class LoginLaege extends AppCompatActivity {

    //MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(R.id.TextKlinik);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_laege);
    }

    public void OnClickBox(View view) {

        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }


}
