package com.evanglazer.thecabaleffect.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.evanglazer.thecabaleffect.FeedPostActivity;
import com.evanglazer.thecabaleffect.FeedsActivity;
import com.evanglazer.thecabaleffect.R;
import com.evanglazer.thecabaleffect.SettingsActivity;


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
                Intent intent = new Intent(getActivity(), FeedPostActivity.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FeedsActivity.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
