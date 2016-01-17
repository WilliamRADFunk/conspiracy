package com.evanglazer.thecabaleffect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        setTitle(getString(R.string.app_login_name));
        // check if user has current info

            username = (EditText) findViewById(R.id.username);
            password = (EditText) findViewById(R.id.password);
            username.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (username.isFocused())
                         username.setText("");
                }
            });
            password.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (password.isFocused())
                        password.setText("");
                }
            });


            login = (Button) findViewById(R.id.postFeed);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // check parse db and see
                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setTitle("Please wait!");
                    progressDialog.setMessage("Please wait as we sign you in");

                    ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            progressDialog.dismiss();
                            if (e != null) {
                                Toast.makeText(MainActivity.this, "ERROR CODE: " + e.getCode(), Toast.LENGTH_LONG).show();
                            } else {
                                Intent intent = new Intent(MainActivity.this, FeedsActivity.class);
                                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        }
                    });
                    register = (Button) findViewById(R.id.register);
                    register.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            });
        };


}