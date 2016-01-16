package com.evanglazer.thecabaleffect.parse;

import android.app.Application;

import com.evanglazer.thecabaleffect.R;
import com.parse.Parse;

/**
 * Created by Evan on 1/16/2016.
 */
public class Service extends Application {

    @Override
    public void onCreate() {
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_key));
    }
}
