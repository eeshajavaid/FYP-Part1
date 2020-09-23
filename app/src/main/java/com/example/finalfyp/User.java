package com.example.finalfyp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    private String username;
    private String password;
    private String nationality;
    @PrimaryKey
    @NonNull
    private String email;
    private String profileuri;

    public User(String username, String password, String nationality, @NonNull String email, String profileuri) {
        this.username = username;
        this.password = password;
        this.nationality = nationality;
        this.email = email;
        this.profileuri = profileuri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileuri() {
        return profileuri;
    }

    public void setProfileuri(String profileuri) {
        this.profileuri = profileuri;
    }
}
