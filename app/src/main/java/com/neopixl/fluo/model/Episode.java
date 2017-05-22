package com.neopixl.fluo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Yvan Moté on 11/05/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode implements Parcelable {

    private String name;
    private int season;

    private Image image;

    // Important pour Jackson qui utilise le constructeur vide
    public Episode() {
    }

    public Episode(String name) {
        this.name = name;
    }

    protected Episode(Parcel in) {
        name = in.readString();
        season = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(season);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Episode> CREATOR = new Creator<Episode>() {
        @Override
        public Episode createFromParcel(Parcel in) {
            return new Episode(in);
        }

        @Override
        public Episode[] newArray(int size) {
            return new Episode[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
