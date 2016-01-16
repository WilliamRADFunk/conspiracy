package com.evanglazer.thecabaleffect;

import android.os.Bundle;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.evanglazer.thecabaleffect.fragments.NavBarFragment;

/**
 * Created by Evan on 1/16/2016.
 */
public class FeedDetailActivity extends AppCompatActivity {

    FragmentManager fm = getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm.beginTransaction().replace(R.id.feedsDetail, new NavBarFragment());
    }
}
