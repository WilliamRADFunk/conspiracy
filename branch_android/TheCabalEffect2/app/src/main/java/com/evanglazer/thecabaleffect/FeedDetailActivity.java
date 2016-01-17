package com.evanglazer.thecabaleffect;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.evanglazer.thecabaleffect.adapters.CommentsAdapter;
import com.evanglazer.thecabaleffect.fragments.NavBarFragment;
import com.evanglazer.thecabaleffect.models.comments;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

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

    String m_title;
    String m_author;
    String m_conspirator;
    String m_comments;

    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    CommentsAdapter adapter;
    private List<comments> commentsList = null;

    FragmentManager fm = getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feeds_detail_layout);
        fm.beginTransaction().replace(R.id.feedsDetail, new NavBarFragment());

        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();
        m_title = i.getStringExtra("title");
        m_author = i.getStringExtra("author");

        // Locate the TextViews in singleitemview.xml
        title = (TextView) findViewById(R.id.detailTitle);
        author = (TextView) findViewById(R.id.detailAuthorText);

        // Load the results into the TextViews
        title.setText(m_title.toString());
        author.setText(m_author.toString());
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();
        listview = (ListView) findViewById(R.id.listView3);

        share = (Button) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create the send intent
                Intent shareIntent =
                        new Intent(android.content.Intent.ACTION_SEND);

                //set the type
                shareIntent.setType("text/plain");

                //add a subject
                shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                        "Share the " + m_title.toString() + " to your friends!");


                //start the chooser for sharing
                startActivity(Intent.createChooser(shareIntent,
                        "Choose the following to share to!"));

            }
        });
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(FeedDetailActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Fetching data...");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create the array
            commentsList = new ArrayList<comments>();
            try {
                // Locate the class table named "Conspiracies" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                        "Comments");

                ob = query.find();
                for (ParseObject con : ob) {
                    comments map = new comments();
                    map.setUsername((con.getString("username")));
                    map.setContent(con.getString("content"));
                    map.setPostedDate(con.getString("createdAt"));
                    commentsList.add(map);
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            // Pass the results into ListViewAdapter.java
            adapter = new CommentsAdapter(FeedDetailActivity.this, commentsList);
            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }


}
