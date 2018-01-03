package edu.udacity.faraonc.androidtourguideapp;

import java.io.Serializable;

/**
 * Created by ConardJames on 12/31/2017.
 */

//TODO Replace with Parceable
class TourItem implements Serializable {

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

}
