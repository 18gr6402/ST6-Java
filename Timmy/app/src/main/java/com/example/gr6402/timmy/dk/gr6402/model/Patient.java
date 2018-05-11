package com.example.gr6402.timmy.dk.gr6402.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Patient implements Parcelable {

    // attributes

    private Integer cpr;
    private String nyha;
    private Integer symptomThreshold;
    private Integer mpiThreshold;

    public Patient() {

    }
    //  private static Patient instance;

    // methods
    public Patient(int c){
        cpr =  c;
    }


    public void setCPR(int cpr){

    }

    public Integer getCPR(){
        // int
        return cpr.get();
    }

    public void cprProperty(){
        // Integer
    }

    public void setNYHA(String nyha){

    }

    public void getNYHA(){
        // String
    }

    public void nyhaProperty(){
        // String
    }

    public void setSymptomThreshold(int symptomThreshold){

    }

    public void getSymptomThreshold(){
        // int
    }

    public void symptomThresholdProperty(){
        // Integer
    }

    public void setMPIThreshold(int mpiThreshold){

    }

    public void getMPIThreshold(){
        // int
    }

    public void mpiProperty(){
        // Integer
    }


    @Override
    public int describeContents() {
        return 0;
    }


   // public class User implements Parcelable{

        //parcel part
            public Patient(Parcel in){
            String[] data= new String[4];

            in.readStringArray(data);
            this.cpr= Integer.parseInt(data[0]);
            this.nyha= data[1];
            this.mpiThreshold= Integer.parseInt(data[2]);
            this.symptomThreshold=Integer.parseInt(data[3]);
        }


        @Override
        public void writeToParcel(Parcel dest, int flags) {
// TODO Auto-generated method stub

            dest.writeStringArray(new String[]{String.valueOf(this.cpr),this.nyha,String.valueOf(this.mpiThreshold),String.valueOf(this.symptomThreshold)});
        }

        public static final Parcelable.Creator<Patient> CREATOR= new Parcelable.Creator<Patient>() {

            @Override
            public Patient createFromParcel(Parcel source) {
// TODO Auto-generated method stub
                return new Patient(source);  //using parcelable constructor
            }

            @Override
            public Patient[] newArray(int size) {
// TODO Auto-generated method stub
                return new Patient[size];
            }
        };




}
