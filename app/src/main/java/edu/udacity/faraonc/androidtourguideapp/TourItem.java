package edu.udacity.faraonc.androidtourguideapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by ConardJames on 12/31/2017.
 */

//TODO Replace with Parceable
class TourItem implements Parcelable {

    private final static int NAME = 0;
    private final static int LOCATION = 1;
    private final static int DESCRIPTION = 2;

    private String entryName;
    private String entryLocation;
    private String entryDescription;
    private int entryImageId;


    TourItem(String stringResourceIds[], int entryImageId) {
        this.entryName = stringResourceIds[NAME];
        this.entryLocation = stringResourceIds[LOCATION];
        this.entryDescription = stringResourceIds[DESCRIPTION];
        this.entryImageId = entryImageId;
    }

    public TourItem(Parcel in){
        this.entryName = in.readString();
        this.entryLocation = in.readString();
        this.entryDescription = in.readString();
        this.entryImageId = in.readInt();
    }

    String getEntryName() {
        return this.entryName;
    }

    String getEntryLocation() {
        return this.entryLocation;
    }

    String getEntryDescription() {
        return this.entryDescription;
    }

    int getEntryImageId() {
        return this.entryImageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.entryName);
        parcel.writeString(this.entryLocation);
        parcel.writeString(this.entryDescription);
        parcel.writeInt(this.entryImageId);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public TourItem createFromParcel(Parcel in) {
            return new TourItem(in);
        }

        public TourItem[] newArray(int size) {
            return new TourItem[size];
        }
    };
}
