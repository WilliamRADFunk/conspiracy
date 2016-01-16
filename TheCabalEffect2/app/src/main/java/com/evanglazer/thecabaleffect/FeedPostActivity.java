package com.evanglazer.thecabaleffect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.evanglazer.thecabaleffect.models.profile;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

/**
 * Created by Evan on 1/16/2016.
 */
public class FeedPostActivity extends AppCompatActivity{
    EditText titlePost;
    Button upload;
    EditText synopsisDescription;
    Button post;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_post_layout);

        titlePost = (EditText) findViewById(R.id.postTitle);
        titlePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titlePost.isFocused())
                    titlePost.setText("");
            }
        });

        synopsisDescription = (EditText) findViewById(R.id.synopsisDescription);
        post = (Button) findViewById(R.id.postFeed);
        final profile prof = new profile();
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject obj = ParseObject.create("Conspiracies");
                obj.put("description", synopsisDescription.getText().toString());
                obj.put("title", titlePost.getText().toString());
                obj.put("username", prof.getUsername().toString());
                obj.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e != null) {
                            Toast.makeText(FeedPostActivity.this, "ERROR CODE: " + e.getCode(), Toast.LENGTH_LONG).show();
                        } else {
                            Intent intent = new Intent(FeedPostActivity.this, FeedsActivity.class);
                            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }
                });
            }
        });

    }

}
