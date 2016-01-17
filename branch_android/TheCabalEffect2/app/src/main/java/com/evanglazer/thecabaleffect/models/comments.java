package com.evanglazer.thecabaleffect.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Evan on 1/16/2016.
 */

@ParseClassName("Comments")
public class comments extends ParseObject  {
    private String username;
    private String content;
    private String postedDate;

    public String getUsername() {
        return username;
    }
    public void setUsername(String user)
    {
        this.username = user;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String con)
    {
        this.content = con;
    }

    public String getPostedDate()
    {
        return postedDate;
    }

    public void setPostedDate(String date)
    {
        this.postedDate = date;
    }


}
