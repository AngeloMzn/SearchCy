package com.example.searchcy.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cidade{
    @PrimaryKey(autoGenerate = true)
    int id;
    String cidade;
    String estado;

    public Cidade(){}
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    @Override
    public String toString(){
        return id + ": " + cidade + ", estado:" + estado;
    }

}