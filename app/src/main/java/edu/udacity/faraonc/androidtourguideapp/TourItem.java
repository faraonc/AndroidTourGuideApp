package edu.udacity.faraonc.androidtourguideapp;

import java.io.Serializable;

/**
 * Created by ConardJames on 12/31/2017.
 */

//TODO Replace with Parceable
class TourItem implements Serializable {

    private String entryName;
    private String entryLocation;
    private int entryImageId;

    TourItem(String entryName, String entryLocation, int entryImageId ){
        this.entryName = entryName;
        this.entryLocation = entryLocation;
        this.entryImageId = entryImageId;
    }

    String getEntryName(){
        return this.entryName;
    }

    String getEntryLocation(){
        return this.entryLocation;
    }

    int getEntryImageId(){
        return this.entryImageId;
    }

    void setEntryName(String entryName){
        this.entryName = entryName;
    }

    void setEntryLocation(String entryLocation){
        this.entryLocation = this.entryLocation;
    }

    void setEntryImageId(int entryImageId){
        this.entryImageId = entryImageId;
    }

    @Override
    public String toString(){
        return this.entryName + " -> " + this.entryLocation + ": " + this.entryImageId;
    }
}
