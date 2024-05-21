package com.example.searchcy.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    int id;
    String login;
    String email;
    String password;

    public Usuario(){}

    public int getId() {
        return id;    
    }
    
    public void setId(int id) {
        this.id = id;    
    }
    
    public String getLogin() {
        return login;    
    }
    
    public void setLogin(String login) {
        this.login = login;    
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
        return id +": " + login + ", email=" + email;
    }
    
}
