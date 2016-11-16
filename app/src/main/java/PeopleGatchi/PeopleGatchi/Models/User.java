package PeopleGatchi.PeopleGatchi.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eaglebrosi on 11/16/16.
 */

public class User {
    @SerializedName("userName")
    String userName;

    @SerializedName("password")
    String password;

    @SerializedName("email")
    String email;

    @SerializedName("confirm")
    String confirm;

    public User() {
    }

    // this will be used to sign into your account.
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // this will be used to register an account
    public User (String userName, String email, String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}