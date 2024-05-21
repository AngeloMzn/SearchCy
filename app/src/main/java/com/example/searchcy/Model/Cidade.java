package com.example.searchcy.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cidade{
    @PrimaryKey(autoGenerate = true)
    int id;
    String city;
    String state;

    public Cidade(){}
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getState(){
        return state;
    }
    public void setState(String state){
        this.state = state;
    }
    @Override
    public String toString(){
        return id + ": " + city + ", estado:" + state;
    }

}