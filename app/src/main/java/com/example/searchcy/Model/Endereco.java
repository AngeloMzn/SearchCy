package com.example.searchcy.Model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Endereco {
    @PrimaryKey(autoGenerate = true)
    int id;
    String description;
    double latitude;
    double longitude;
    int cityId;

    public Endereco(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCidadeId(int cityId) {
        this.cityId = cityId;
    }

}
