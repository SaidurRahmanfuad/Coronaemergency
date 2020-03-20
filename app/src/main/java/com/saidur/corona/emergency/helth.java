package com.saidur.corona.emergency;

public class helth {
    private String id;
    private String hospitalname;

    private String upozila;
    private String division;
    private String phoneNumber;
    private String zilla;
    public helth(String id, String hospitalname, String upozila, String division, String phoneNumber, String zilla) {
        this.id = id;
        this.hospitalname = hospitalname;
        this.upozila = upozila;
        this.division = division;
        this.phoneNumber = phoneNumber;
        this.zilla = zilla;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getUpozila() {
        return upozila;
    }

    public void setUpozila(String upozila) {
        this.upozila = upozila;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getPhoneNumber(int position) {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZilla() {
        return zilla;
    }

    public void setZilla(String zilla) {
        this.zilla = zilla;
    }

    public helth() {
    }



}
