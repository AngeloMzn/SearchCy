package com.example.searchcy.Model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Endereco {
    @PrimaryKey(autoGenerate = true)
    int id;
    String descricao;
    double latitude;
    double longitude;
    int cidadeId;

    public Endereco(){}

    public Endereco(String descricao, Double latitude, Double longitude, int cidadeId) {
        this.descricao = descricao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cidadeId = cidadeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public int getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(int cidadeId) {
        this.cidadeId = cidadeId;
    }

}
