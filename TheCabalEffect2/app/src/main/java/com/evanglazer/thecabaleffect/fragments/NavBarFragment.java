package com.evanglazer.thecabaleffect.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.evanglazer.thecabaleffect.R;


/**
 * Created by Evan on 1/16/2016.
 */


public class NavBarFragment extends Fragment {

    Button conspire;
    Button home;
    Button settings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navbar_fragment, container, false);


        conspire = (Button) view.findViewById(R.id.conspire);
        home = (Button) view.findViewById(R.id.home);
        settings = (Button) view.findViewById(R.id.settings);

        conspire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





        return view;
    }

    // if user clicks post in feeds detail view then add comment
    // else post will make a post

    //LOGOUT
    //ParseUser.getCurrentUser().logOut();
    //startActivity(new Intent(NavBarFragment.this, DispatchActivity.class));
}
