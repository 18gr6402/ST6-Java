package com.example.gr6402.timmy.dk.gr6402.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gr6402.timmy.R;

public class GuideCtrl extends AppCompatActivity {

    private TextView guideTxt;
    private TextView step1Txt;
    private ImageView step1Img;
    private TextView step2Txt;
    private ImageView step2Img;
    private TextView step3Txt;
    private ImageView step3Img;
    private TextView step4Txt;
    private TextView step5Txt;
    private TextView step6Txt;
    private ImageView step6Img;
    private TextView step7Txt;
    private ImageView step7Img;
    private TextView step8Txt;
    private ImageView step8Img;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        guideTxt = (TextView) findViewById(R.id.guideTxt);
        step1Txt = (TextView) findViewById(R.id.step1Txt);
        step1Img = (ImageView) findViewById(R.id.step1Img);
        step2Txt = (TextView) findViewById(R.id.step2Txt);
        step2Img = (ImageView) findViewById(R.id.step2Img);
        step3Txt = (TextView) findViewById(R.id.step3Txt);
        step3Img = (ImageView) findViewById(R.id.step3Img);
        step4Txt = (TextView) findViewById(R.id.step4Txt);
        step5Txt = (TextView) findViewById(R.id.step5Txt);
        step6Txt = (TextView) findViewById(R.id.step6Txt);
        step6Img = (ImageView) findViewById(R.id.step6Img);
        step7Txt = (TextView) findViewById(R.id.step7Txt);
        step7Img = (ImageView) findViewById(R.id.step7Img);
        step8Txt = (TextView) findViewById(R.id.step8Txt);
        step8Img = (ImageView) findViewById(R.id.step8Img);
        btnOK = (Button) findViewById(R.id.btnOK);
    }

    public void handleOK (View view){

    }
}
