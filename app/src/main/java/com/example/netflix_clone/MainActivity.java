package com.example.netflix_clone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputPassword;
    private Button signUp;
    private TextView needHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setElevation(0);

        textInputEmail = findViewById(R.id.sign_in_email_etl);
        textInputPassword = findViewById(R.id.sign_in_password_etl);
        signUp = findViewById(R.id.sign_in_bt);
        needHelp = findViewById(R.id.sign_in_help);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailInput = textInputEmail.getEditText().getText().toString().trim();
                String passwordInput = textInputPassword.getEditText().getText().toString().trim();
                if(TextUtils.isEmpty(emailInput)){
                    Toast.makeText(MainActivity.this, "Enter Email or Phone Number", Toast.LENGTH_SHORT).show();
                }else{
                    if(passwordInput.length() < 4 || passwordInput.length() > 60){
                        textInputPassword.setErrorEnabled(true);
                        textInputPassword.setError("Your password must contain between 4 and 60 characters");
                    }else{
                        textInputPassword.setErrorEnabled(false);
                        textInputPassword.setError(null);
                        Toast.makeText(MainActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        needHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.netflix.com/in/loginhelp";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }


}