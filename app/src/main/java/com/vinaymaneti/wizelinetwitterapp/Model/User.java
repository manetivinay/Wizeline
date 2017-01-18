package com.vinaymaneti.wizelinetwitterapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vinay on 18/01/17.
 */

public class User implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("screen_name")
    private String screenName;
    @SerializedName("description")
    private String description;

    protected User(Parcel in) {
        name = in.readString();
        screenName = in.readString();
        description = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(screenName);
        parcel.writeString(description);
    }
}
