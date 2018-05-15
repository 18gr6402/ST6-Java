package com.example.gr6402.timmy.dk.gr6402.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SCGMeasure implements Parcelable{

    // attributes
    private Object date;
    private String fiducialmarkers;
    private String scg;
    private Integer mpi;
    private Integer weight;
    private String angina;
    private String dyspnea;
    private String fatigue;
    private Boolean warning;


    //constructors
    public SCGMeasure() {
    }

    public SCGMeasure(Object date, String fiducialmarkers, String scg, int mpi, int weight, String angina, String dyspnea, String fatigue, Boolean warning){
        this.date = date;
        this.fiducialmarkers = fiducialmarkers;
        this.scg = scg;
        this.mpi = mpi;
        this.weight = weight;
        this.angina = angina;
        this.dyspnea = dyspnea;
        this.fatigue = fatigue;
        this.warning = warning;
    }


    // set and get methods
    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public String getFiducialmarkers() {
        return fiducialmarkers;
    }

    public void setFiducialmarkers(String fiducialmarkers) {
        this.fiducialmarkers = fiducialmarkers;
    }

    public String getScg() {
        return scg;
    }

    public void setScg(String scg) {
        this.scg = scg;
    }

    public Integer getMpi() {
        return mpi;
    }

    public void setMpi(Integer mpi) {
        this.mpi = mpi;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getAngina() {
        return angina;
    }

    public void setAngina(String angina) {
        this.angina = angina;
    }

    public String getDyspnea() {
        return dyspnea;
    }

    public void setDyspnea(String dyspnea) {
        this.dyspnea = dyspnea;
    }

    public String getFatigue() {
        return fatigue;
    }

    public void setFatigue(String fatigue) {
        this.fatigue = fatigue;
    }

    public Boolean getWarning() {
        return warning;
    }

    public void setWarning(Boolean warning) {
        this.warning = warning;
    }


    // parcelable part
    protected SCGMeasure(Parcel in) {
        date = (Object) in.readValue(Object.class.getClassLoader());
        fiducialmarkers = in.readString();
        scg = in.readString();
        mpi = in.readByte() == 0x00 ? null : in.readInt();
        weight = in.readByte() == 0x00 ? null : in.readInt();
        angina = in.readString();
        dyspnea = in.readString();
        fatigue = in.readString();
        warning = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeString(fiducialmarkers);
        dest.writeString(scg);
        if (mpi == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(mpi);
        }
        if (weight == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(weight);
        }
        dest.writeString(angina);
        dest.writeString(dyspnea);
        dest.writeString(fatigue);
        if (warning == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (warning ? 0x01 : 0x00));
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SCGMeasure> CREATOR = new Parcelable.Creator<SCGMeasure>() {
        @Override
        public SCGMeasure createFromParcel(Parcel in) {
            return new SCGMeasure(in);
        }

        @Override
        public SCGMeasure[] newArray(int size) {
            return new SCGMeasure[size];
        }
    };
}
