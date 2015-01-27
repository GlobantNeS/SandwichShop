package com.kaineras.sandwichshop;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kaineras on 27/01/15.
 */
public class OrderSandwich implements Parcelable{
    private String orden;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }
}
