package com.example.signinwithphonenumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText mobilenumber,password;

    Button signup;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar

        setContentView(R.layout.activity_main);

        mobilenumber = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.editText6);
        signup = (Button) findViewById(R.id.button3);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }

        });

    }
    protected void onStart() {
        super.onStart();


    }
    public void sendData(){

        final String Password=password.getText().toString().trim();

        final String number = mobilenumber.getText().toString().trim();

        if (number.isEmpty() || number.length() < 10) {
            mobilenumber.setError("Valid number is required");
            mobilenumber.requestFocus();
            return;
        }
        if (Password.isEmpty() || Password.length()<8){

            password.setError("Valid password is required");
            password.requestFocus();
            return;
        }

                            //for Phone OTP

                            String phonenumber = "+91" + number;
                            Intent intent = new Intent(getApplicationContext(), OtpActivity.class);
                            intent.putExtra("phonenumber", phonenumber);
                            startActivity(intent);


                    }



    }





