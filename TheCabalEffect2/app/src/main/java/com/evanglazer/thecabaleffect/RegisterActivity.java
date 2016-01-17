package com.evanglazer.thecabaleffect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by Evan on 1/16/2016.
 */
public class RegisterActivity extends AppCompatActivity{

    EditText usernameReg;
    EditText passwordReg;
    EditText emailReg;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        setTitle(getString(R.string.app_login_register));

        usernameReg = (EditText) findViewById(R.id.usernameRegister);
        passwordReg= (EditText) findViewById(R.id.passwordRegister);
        emailReg = (EditText) findViewById(R.id.emailRegister);

        usernameReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameReg.isFocused())
                    usernameReg.setText("");
            }
        });
        passwordReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordReg.isFocused())
                    passwordReg.setText("");
            }
        });

        emailReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailReg.isFocused())
                    emailReg.setText("");
            }
        });


        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
                progressDialog.setTitle("Please wait!");
                progressDialog.setMessage("Signing up, please wait.");

                // send to parse db to register user
                ParseUser user = new ParseUser();
                user.setUsername(usernameReg.getText().toString());
                user.setPassword(passwordReg.getText().toString());
                user.setEmail(emailReg.getText().toString());
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        progressDialog.dismiss();
                        if(e != null)
                        {
                            Toast.makeText(RegisterActivity.this, "ERROR CODE: " + e.getCode(), Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }
                });
            }
        });
    }
}
