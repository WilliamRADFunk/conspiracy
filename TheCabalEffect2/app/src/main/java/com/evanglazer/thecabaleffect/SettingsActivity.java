package com.evanglazer.thecabaleffect;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.evanglazer.thecabaleffect.fragments.NavBarFragment;
import com.parse.ParseUser;

/**
 * Created by Evan on 1/16/2016.
 */
public class SettingsActivity extends AppCompatActivity {

    TextView name;
    TextView email;
    ImageView avatar;
    Button puzzlingFeature;
    Button reportBug;
    Button feedback;
    Button aboutus;
    Button logout;

    FragmentManager fm = getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);
        name = (TextView) findViewById(R.id.settingsName);
        email = (TextView) findViewById(R.id.settingsEmail);
        avatar = (ImageView) findViewById(R.id.imageView3);

        fm.beginTransaction().replace(R.id.settings, new NavBarFragment());

        puzzlingFeature = (Button) findViewById(R.id.puzzling);
        reportBug = (Button) findViewById(R.id.reportBug);
        feedback = (Button) findViewById(R.id.feedback);
        aboutus = (Button) findViewById(R.id.about);
        logout = (Button) findViewById(R.id.logout);

        puzzlingFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        reportBug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setContentView(R.layout.about_layout);
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LOGOUT
                ParseUser.getCurrentUser().logOut();
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
            }
        });
    }
}
