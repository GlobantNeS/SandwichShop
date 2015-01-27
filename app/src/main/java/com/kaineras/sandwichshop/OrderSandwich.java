package com.kaineras.sandwichshop;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kaineras on 27/01/15.
 */
public class OrderSandwich implements Parcelable{
    private String orden;


    public static final Creator<OrderSandwich> CREATOR = new
            Creator<OrderSandwich>(){

                @Override
                public OrderSandwich createFromParcel(Parcel source) {
                    return new OrderSandwich(source);
                }

                @Override
                public OrderSandwich[] newArray(int size) {
                    return new OrderSandwich[0];
                }
            };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(orden);
    }
    public OrderSandwich(Parcel in)
    {
        readFromParcel(in);
    }

    private void readFromParcel(Parcel in) {
        orden=in.readString();
    }

    public OrderSandwich(String cadena)
    {
        setOrden(cadena);
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }
}
