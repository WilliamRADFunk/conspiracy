package com.evanglazer.thecabaleffect;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.evanglazer.thecabaleffect.adapters.FeedAdapter;
import com.evanglazer.thecabaleffect.models.feeds;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evan on 1/16/2016.
 */

public class FeedsActivity extends Activity {
    // Declare Variables
    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    FeedAdapter adapter;
    private List<feeds> feedsList = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.feeds_activity);
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(FeedsActivity.this);
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
            feedsList = new ArrayList<feeds>();
            try {
                // Locate the class table named "Conspiracies" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                        "Conspiracies");

                ob = query.find();
                for (ParseObject country : ob) {
                    feeds map = new feeds();
                    map.setTitle((country.getString("title")));
                    map.setAuthor(country.getString("author"));
                    map.setConspiratorCount(country.getInt("conspirator_count"));
                    map.setCommentCount(country.getInt("CommentCount"));
                    feedsList.add(map);
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.listView2);
            // Pass the results into ListViewAdapter.java
            adapter = new FeedAdapter(FeedsActivity.this, feedsList);
            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }
}
