package com.example.gr6402.timmy.dk.gr6402.model;

public class Clinic {

    // attributes
    private Integer clinicID;
    private String clinicName;
    private String region;

    public Clinic() {
    }

    public Clinic(int clinicID, String clinicName, String region){
        this.clinicID =  clinicID;
        this.clinicName = clinicName;
        this.region = region;
    }

    // get and set methods
    public Integer getClinicID() {
        return clinicID;
    }

    public void setClinicID(Integer clinicID) {
        this.clinicID = clinicID;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
