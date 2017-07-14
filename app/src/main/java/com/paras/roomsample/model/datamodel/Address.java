package com.paras.roomsample.model.datamodel;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by Paras on 7/14/2017.
 */

public class Address {

    @ColumnInfo(name = "street")
    public String street;

    @ColumnInfo(name = "state")
    public String state;

    @ColumnInfo(name = "city")
    public String city;

    @ColumnInfo(name = "post_code")
    public int postCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
}
