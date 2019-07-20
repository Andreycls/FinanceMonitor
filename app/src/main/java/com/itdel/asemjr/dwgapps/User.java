package com.itdel.asemjr.dwgapps;

/**
 * Created by asemJr on 2/12/2018.
 */

public class User {
    public String Username;
    public String Password;
    public int ID;

    public User( int ID,String username, String password) {
        this.Username = username;
        this.Password = password;
        this.ID = ID;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", ID=" + ID +
                '}';
    }

    public  String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public  String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
