package com.evanglazer.thecabaleffect.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Evan on 1/16/2016.
 */

@ParseClassName("Conspiracies")
public class feeds extends ParseObject {
    private String title;
    private String author;
    private int conspiratorCount;
    private int  commentCount;
    private String username;

    public String getUsername()
    {
        return username;
    }
    public void setUsername(String user)
    {
        this.username = user;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {

        this.title = title;
    }

    public String getAuthor()

    {
        return author;
    }

    public void setAuthor(String author)

    {
        this.author = author;
    }

    public int getConspiratorCount()
    {

        return conspiratorCount;
    }

    public void setConspiratorCount(int count)
    {

        this.conspiratorCount = count;
    }

    public int getCommentCount()
    {

        return commentCount;
    }

    public void setCommentCount(int count)
    {
        this.commentCount = count;
    }

}
