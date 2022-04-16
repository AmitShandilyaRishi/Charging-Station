package com.amit.chargingstations;

import android.location.Location;

public class data {
    private final String location;
    private final String latitude;
    private final String longitude;
    private final String type;
    private final String rating;
    private final String availability;

    public data(String location, String latitude, String longitude, String type,  String rating, String availability)
    {
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.rating = rating;
        this.availability = availability;
    }


    public String getLocation() {
        return location;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getType() {
        return type;
    }

    public String getRating() {
        return rating;
    }

    public String getAvailability() {
        return availability;
    }
}
