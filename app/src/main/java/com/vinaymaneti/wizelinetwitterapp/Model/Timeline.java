package com.vinaymaneti.wizelinetwitterapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vinay on 18/01/17.
 */

public class Timeline implements Parcelable {

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("text")
    private String textDes;

    @SerializedName("user")
    private User mUser;

    @SerializedName("favourites_count")
    private String favouritesCount;

//    @SerializedName("text")
//    private String text;

    @SerializedName("profile_image_url")
    private String profile_image_url;

    protected Timeline(Parcel in) {
        createdAt = in.readString();
        textDes = in.readString();
        mUser = in.readParcelable(User.class.getClassLoader());
        favouritesCount = in.readString();
        //text = in.readString();
        profile_image_url = in.readString();
    }

    public static final Creator<Timeline> CREATOR = new Creator<Timeline>() {
        @Override
        public Timeline createFromParcel(Parcel in) {
            return new Timeline(in);
        }

        @Override
        public Timeline[] newArray(int size) {
            return new Timeline[size];
        }
    };

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTextDes() {
        return textDes;
    }

    public void setTextDes(String textDes) {
        this.textDes = textDes;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public String getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(String favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(createdAt);
        parcel.writeString(textDes);
        parcel.writeParcelable(mUser, i);
        parcel.writeString(favouritesCount);
        //parcel.writeString(text);
        parcel.writeString(profile_image_url);
    }
}
