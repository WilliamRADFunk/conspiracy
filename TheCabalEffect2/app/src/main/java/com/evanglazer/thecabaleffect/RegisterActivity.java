package com.evanglazer.thecabaleffect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Evan on 1/16/2016.
 */
public class RegisterActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        setTitle(getString(R.string.app_login_register));
    }
}
