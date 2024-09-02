package com.example.edonator.ui.Donor;

public class DonorModel {
    private String mName;
    private String mContact;
    private String mAddress;

    public DonorModel(String name, String contact, String address) {
        mName = name;
        mContact = contact;
        mAddress = address;
    }

    public String getName() {
        return mName;
    }

    public String getContact() {
        return mContact;
    }

    public String getAddress() {
        return mAddress;
    }

}

