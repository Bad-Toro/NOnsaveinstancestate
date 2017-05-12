package com.mobileappscompany.training.nonsaveinstancestate;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by ferna on 5/12/2017.
 */

public class MyClass implements Parcelable {
    private String mString;

    public String getString() {
        return mString;
    }

    public void setString(String string) {
        mString = string;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mString);
    }

    public MyClass() {
    }

    protected MyClass(Parcel in) {
        this.mString = in.readString();
    }

    public static final Parcelable.Creator<MyClass> CREATOR = new Parcelable.Creator<MyClass>() {
        @Override
        public MyClass createFromParcel(Parcel source) {
            return new MyClass(source);
        }

        @Override
        public MyClass[] newArray(int size) {
            return new MyClass[size];
        }
    };
}
