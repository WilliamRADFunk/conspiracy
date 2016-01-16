package com.evanglazer.thecabaleffect.parse;

import android.app.Application;

import com.evanglazer.thecabaleffect.R;
import com.evanglazer.thecabaleffect.models.feeds;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Evan on 1/16/2016.
 */
public class Service extends Application {

    @Override
    public void onCreate() {
        ParseObject.registerSubclass(feeds.class);
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_key));
    }
}
