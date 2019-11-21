package com.example.durnkblerg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile ( "^" +
                    "(?=.*[0-9])" +     //at least one digit
                    "(?=.*[a-z])"+      //at least one lower case letter
                    "(?=.*[A-Z])"+      //at least one upper case letter
                    "(?=.*[@#$%^&+=])"+ //at least one special character
                    "(?=\\S+$)"+        //no  white space
                    ".{4,}"+            //at least 4 characters
                    "$" );

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignup;


    private TextView textViewSignin;

    private ProgressDialog progressDialog;



    //Everything within onCreate executes when app is launched
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Splash Screen
        //setTheme(R.style.AppTheme);

        //initializing firebase auth object




        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignin = (TextView) findViewById(R.id.textViewSignin);


        buttonSignup = (Button) findViewById(R.id.buttonSignup);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        buttonSignup.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
    }

    //Method for registering user.
    private boolean validateEmail(){

        //getting email and password from edit texts
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if(email.isEmpty()){
            editTextEmail.setError ( "email can't be empty" );
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher ( email ).matches ()){
            editTextEmail.setError ( "Please enter a valid email address" );
            return false;
        } else{
            editTextEmail.setError ( null );
            return true;
          }
    }

    private boolean validatePassword() {
        String password  = editTextPassword.getText().toString().trim();

        if (password.isEmpty()) {
            editTextPassword.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            editTextPassword.setError("Password too weak");
            return false;
        } else {
            editTextPassword.setError(null);
            return true;
        }
    }


    @Override
    public void onClick(View view) {
        //Signup button starts registerUser method
        if(view == buttonSignup){
            validateEmail();
            validatePassword();
        }

        if(view == textViewSignin){
            //open login activity when user taps on the already registered textview
            startActivity(new Intent(this, LoginActivity.class));
        }


    }

}
