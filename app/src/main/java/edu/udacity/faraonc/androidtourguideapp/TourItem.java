package edu.udacity.faraonc.androidtourguideapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * The entry for tourist lists.
 *
 * @author ConardJames
 * @version 010418-01
 */
class TourItem implements Parcelable {

    private final static int NAME = 0;
    private final static int LOCATION = 1;
    private final static int DESCRIPTION = 2;

    private String entryName;
    private String entryLocation;
    private String entryDescription;
    private int entryImageId;

    /**
     * Construct a tour item with the given resources.
     *
     * @param stringResource a string-array resource.
     * @param entryImageId   the resource id for image.
     */
    TourItem(String stringResource[], int entryImageId) {
        this.entryName = stringResource[NAME];
        this.entryLocation = stringResource[LOCATION];
        this.entryDescription = stringResource[DESCRIPTION];
        this.entryImageId = entryImageId;
    }

    /**
     * Construct a TourItem from a Parcel.
     *
     * @param in the parcel.
     */
    public TourItem(Parcel in) {
        this.entryName = in.readString();
        this.entryLocation = in.readString();
        this.entryDescription = in.readString();
        this.entryImageId = in.readInt();
    }

    /**
     * Get the entry name.
     *
     * @return the entry name.
     */
    String getEntryName() {
        return this.entryName;
    }

    /**
     * Get the entry location.
     *
     * @return the entry location.
     */
    String getEntryLocation() {
        return this.entryLocation;
    }

    /**
     * Get the entry description.
     *
     * @return the entry description
     */
    String getEntryDescription() {
        return this.entryDescription;
    }

    /**
     * Get the image resource id.
     *
     * @return the image resource id.
     */
    int getEntryImageId() {
        return this.entryImageId;
    }

    @Override
    /**
     * Not used for now.
     *
     * @return an int.
     */
    public int describeContents() {
        return 0;
    }

    @Override
    /**
     * Serialized the object.
     *
     * @param parcel contains the object.
     * @param   i    not currntly used.
     */
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.entryName);
        parcel.writeString(this.entryLocation);
        parcel.writeString(this.entryDescription);
        parcel.writeInt(this.entryImageId);
    }

    /**
     * Creates a parcel creator for the TourItem.
     */
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        /**
         * Construct a TourItem
         *
         * @param in the parcel containing the TourItem.
         * @return the TourItem.
         */
        public TourItem createFromParcel(Parcel in) {
            return new TourItem(in);
        }

        /**
         * Allocate an array of serializable for TourItem.
         *
         * @param size the number of allocations
         * @return an array for TourItem.
         */
        public TourItem[] newArray(int size) {
            return new TourItem[size];
        }
    };

}
