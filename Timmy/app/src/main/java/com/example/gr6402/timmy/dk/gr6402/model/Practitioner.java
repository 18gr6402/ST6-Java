package com.example.gr6402.timmy.dk.gr6402.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Practitioner extends User implements Parcelable {

    // attributes
    private Integer employmentID;
    private Boolean administrator;


    //constructors
    public Practitioner() {
    }

    public Practitioner(int employmentID, Boolean administrator){
        this.employmentID =  employmentID;
        this.administrator = administrator;
    }


    // get and set methods
    public Integer getEmploymentID() {
        return employmentID;
    }

    public void setEmploymentID(Integer employmentID) {
        this.employmentID = employmentID;
    }

    public Boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }


    // parcelable part
    protected Practitioner(Parcel in) {
        employmentID = in.readByte() == 0x00 ? null : in.readInt();
        administrator = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (employmentID == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(employmentID);
        }
        if (administrator == null){

        }
        else {
            dest.writeByte((byte) (administrator ? 1 : 0));
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Practitioner> CREATOR = new Parcelable.Creator<Practitioner>() {
        @Override
        public Practitioner createFromParcel(Parcel in) {
            return new Practitioner(in);
        }

        @Override
        public Practitioner[] newArray(int size) {
            return new Practitioner[size];
        }
    };
}

