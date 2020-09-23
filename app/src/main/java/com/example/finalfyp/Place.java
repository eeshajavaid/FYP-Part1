package com.example.finalfyp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Place {
    @PrimaryKey
    public int placeId;
    public int categoryPid;
    private String placeName;
    private float ratings;
    private String description;
    int imageId;
    double longitude;
    double latitude;

    public Place(int placeId, int categoryPid, String placeName, float ratings, String description, int imageId, double latitude, double longitude) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.ratings = ratings;
        this.description = description;
        this.imageId = imageId;
        this.categoryPid = categoryPid;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getPlaceId() {
        return placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public float getRatings() {
        return ratings;
    }

    public String getDescription() {
        return description;
    }
}
