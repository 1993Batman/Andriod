package com.example.stevene.metadataviewer;

import android.os.Parcel;

import java.net.URL;
import java.util.Date;

/**
 * Created by StevenE on 6/10/2016.
 */

public class Parcelable implements android.os.Parcelable{
    private String name;
    private String location;
    private String keyword;
    private String date;
    private boolean share;
    private String email;
    private int rating;


    public String getName(){
        return  name;
    }
    public String getLocation(){
        return  location;
    }
    public String getKeyword(){
        return  keyword;
    }
    public String getDate(){
        return  date;
    }
    public boolean getShare(){
        return  share;
    }
    public String getEmail(){
        return  email;
    }
    public int getRating(){
        return  rating;
    }

    public void setName(String n){
        name = n;
    }
    public void setLocation(String l){
        location = l;
    }
    public void setKeyword(String k){
        keyword = k;
    }
    public void setDate(String d){
        date = d;
    }
    public void setShare(boolean s){
        share = s;
    }
    public void setEmail(String e){
        email = e;
    }
    public void setRating(int r){
          rating = r;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.location);
        dest.writeString(this.keyword);
        dest.writeString(this.date);
        dest.writeByte(this.share ? (byte) 1 : (byte) 0);
        dest.writeString(this.email);
        dest.writeInt(this.rating);
    }

    public Parcelable() {
    }

    protected Parcelable(Parcel in) {
        this.name = in.readString();
        this.location = in.readString();
        this.keyword = in.readString();
        this.date = in.readString();
        this.share = in.readByte() != 0;
        this.email = in.readString();
        this.rating = in.readInt();
    }

    public static final Creator<Parcelable> CREATOR = new Creator<Parcelable>() {
        @Override
        public Parcelable createFromParcel(Parcel source) {
            return new Parcelable(source);
        }

        @Override
        public Parcelable[] newArray(int size) {
            return new Parcelable[size];
        }
    };
}
