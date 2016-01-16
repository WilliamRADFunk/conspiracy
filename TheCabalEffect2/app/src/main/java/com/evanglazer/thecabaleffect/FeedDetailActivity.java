package com.evanglazer.thecabaleffect;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.evanglazer.thecabaleffect.fragments.NavBarFragment;

/**
 * Created by Evan on 1/16/2016.
 */
public class FeedDetailActivity extends AppCompatActivity {
    ImageView imageView2;
    TextView title;
    TextView author;
    Button share;
    RatingBar ratingBar;
    RadioButton cabal;
    RadioButton notCabal;


    FragmentManager fm = getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm.beginTransaction().replace(R.id.feedsDetail, new NavBarFragment());
    }
}
