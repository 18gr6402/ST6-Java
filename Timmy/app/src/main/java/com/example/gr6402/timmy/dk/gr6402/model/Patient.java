package com.example.gr6402.timmy.dk.gr6402.model;

import android.os.Parcel;
import android.os.Parcelable;
/*
public class Patient implements Parcelable {

    // attributes
    private Integer cpr;
    private String nyha;
    private Integer symptomThreshold;
    private Integer mpiThreshold;

    //constructors
    public Patient() {

    }

    public Patient(int c){
        cpr =  c;
    }
    //  private static Patient instance;

    // methods
    public Integer getCpr() {
        return cpr;
    }

    public void setCpr(Integer cpr) {
        this.cpr = cpr;
    }

    public String getNyha() {
        return nyha;
    }

    public void setNyha(String nyha) {
        this.nyha = nyha;
    }

    public Integer getSymptomThreshold() {
        return symptomThreshold;
    }

    public void setSymptomThreshold(Integer symptomThreshold) {
        this.symptomThreshold = symptomThreshold;
    }

    public Integer getMpiThreshold() {
        return mpiThreshold;
    }

    public void setMpiThreshold(Integer mpiThreshold) {
        this.mpiThreshold = mpiThreshold;
    }


    // parcelable part
    @Override
    public int describeContents() {
        return 0;
    }

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
*/
public class Patient extends User implements Parcelable {

    // attributes
    private Integer cpr;
    private String nyha;
    private Integer symptomThreshold;
    private Integer mpiThreshold;

    //constructors
    public Patient() {

    }

    public Patient(int c){
        cpr =  c;
    }
    //  private static Patient instance;

    // methods
    public Integer getCpr() {
        return cpr;
    }

    public void setCpr(Integer cpr) {
        this.cpr = cpr;
    }

    public String getNyha() {
        return nyha;
    }

    public void setNyha(String nyha) {
        this.nyha = nyha;
    }

    public Integer getSymptomThreshold() {
        return symptomThreshold;
    }

    public void setSymptomThreshold(Integer symptomThreshold) {
        this.symptomThreshold = symptomThreshold;
    }

    public Integer getMpiThreshold() {
        return mpiThreshold;
    }

    public void setMpiThreshold(Integer mpiThreshold) {
        this.mpiThreshold = mpiThreshold;
    }


    protected Patient(Parcel in) {
        cpr = in.readByte() == 0x00 ? null : in.readInt();
        nyha = in.readString();
        symptomThreshold = in.readByte() == 0x00 ? null : in.readInt();
        mpiThreshold = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (cpr == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(cpr);
        }
        dest.writeString(nyha);
        if (symptomThreshold == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(symptomThreshold);
        }
        if (mpiThreshold == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(mpiThreshold);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Patient> CREATOR = new Parcelable.Creator<Patient>() {
        @Override
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        @Override
        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };
}