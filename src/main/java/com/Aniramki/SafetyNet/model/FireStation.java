package com.Aniramki.SafetyNet.model;

public class FireStation {
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public FireStation(String address, String station) {
        this.address = address;
        this.station = station;
    }

    private String address;
    private String station;

    public FireStation() {}
}

