package com.example.durnkblerg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity  extends AppCompatActivity implements View.OnClickListener {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile ( "^" +
                    "(?=.*[0-9])" +     //at least one digit
                    "(?=.*[a-z])"+      //at least one lower case letter
                    "(?=.*[A-Z])"+      //at least one upper case letter
                    "(?=.*[@#$%^&+=])"+ //at least one special character
                    "(?=\\S+$)"+        //no  white space
                    ".{4,}"+            //at least 4 characters
                    "$" );

    //defining views
    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;
    private Button forgotPass;
    private static final String TAG = "MainActivity";



    //progress dialog
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignIn = (Button) findViewById(R.id.buttonSignin);
        textViewSignup  = (TextView) findViewById(R.id.textViewSignUp);


        progressDialog = new ProgressDialog(this);

        //attaching click listener
        buttonSignIn.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);

    }

    //Method for user login
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
        //Sign-in button initiates login method
        if(view == buttonSignIn){
            validateEmail();
            validatePassword ();
            startActivity(new Intent(this, BlockActivity.class));
        }

        if(view == textViewSignup){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
