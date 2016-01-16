package com.evanglazer.thecabaleffect.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Evan on 1/16/2016.
 */

@ParseClassName("Conspiracies")
public class feeds extends ParseObject {

    public String getTitle()
    {
        return getString("title");
    }

    public void setTitle(String title)
    {
        put("title", title);
    }


}
