package com.evanglazer.thecabaleffect;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.evanglazer.thecabaleffect.fragments.NavBarFragment;

/**
 * Created by Evan on 1/16/2016.
 */

public class FeedsActivity extends AppCompatActivity {
    FragmentManager fm = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.feeds));
        setContentView(R.layout.feeds_activity);

        fm.beginTransaction().replace(R.id.feeds, new NavBarFragment());
    }

}
