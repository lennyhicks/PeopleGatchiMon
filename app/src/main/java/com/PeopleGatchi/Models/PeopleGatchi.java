package com.PeopleGatchi.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andrewlewis on 11/16/16.
 */

public class PeopleGatchi {

    @SerializedName("petName")
    String petName;

    @SerializedName("gender")
    String gender;


    public PeopleGatchi(String petName, String gender) {
        this.petName = petName;
        this.gender = gender;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
