package com.evanglazer.thecabaleffect.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evanglazer.thecabaleffect.R;


/**
 * Created by Evan on 1/16/2016.
 */
public class NavBarFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navbar_fragment, container, false);
        return view;
    }

    // if user clicks post in feeds detail view then add comment
    // else post will make a post
}
