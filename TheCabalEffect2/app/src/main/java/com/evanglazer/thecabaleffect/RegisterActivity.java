package com.evanglazer.thecabaleffect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Evan on 1/16/2016.
 */
public class RegisterActivity extends AppCompatActivity{

    EditText username;
    EditText password;
    EditText email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        setTitle(getString(R.string.app_login_register));

        username = (EditText) findViewById(R.id.usernameRegister);
        password = (EditText) findViewById(R.id.passwordRegister);
        email = (EditText) findViewById(R.id.emailRegister);


        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send to parse db to register user
            }
        });




    }
}
