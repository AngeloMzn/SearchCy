package com.example.searchcy.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    int id;
    String nome;
    String email;
    String password;

    public Usuario(){

    }

    public Usuario(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;    
    }
    
    public void setId(int id) {
        this.id = id;    
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;    
    }
    
    public void setEmail(String email) {
        this.email = email;    
    }

    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }    
    
    @Override
    public String toString() {
        return id +": " + nome + ", email=" + email;
    }
    
}
