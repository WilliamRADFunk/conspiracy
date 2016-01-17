package com.evanglazer.thecabaleffect.models;

/**
 * Created by Evan on 1/16/2016.
 */
public class profile {
    private String profilename;
    private String email;

    public String getUsername()
    {
        return profilename;
    }

    public void setUsername(String user)
    {
        this.profilename = user;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String e)
    {
        this.email = e;
    }
}
