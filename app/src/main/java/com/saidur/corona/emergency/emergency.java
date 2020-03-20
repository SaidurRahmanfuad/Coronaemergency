package com.saidur.corona.emergency;

public class emergency {


    private String id;
    private String status;
    private String phoneNumber;

    public emergency() {
    }

    public emergency(String id, String status, String phoneNumber) {
        this.id = id;
        this.status = status;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber(int position) {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber,int position) {
        this.phoneNumber = phoneNumber;
    }


}
