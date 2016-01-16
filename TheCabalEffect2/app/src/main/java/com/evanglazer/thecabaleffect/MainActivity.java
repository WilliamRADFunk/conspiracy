package com.evanglazer.thecabaleffect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


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

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.isFocused())
                    username.setText("");
            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.isFocused())
                    password.setText("");
            }
        });


        login = (Button) findViewById(R.id.postFeed);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check parse db and see
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

}
