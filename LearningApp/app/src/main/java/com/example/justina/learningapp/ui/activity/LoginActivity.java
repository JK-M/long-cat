package com.example.justina.learningapp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.justina.learningapp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private CheckBox saveDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.enterUsername);
        password = (EditText)findViewById(R.id.enterPassword);
        saveDetails = (CheckBox)findViewById(R.id.rememberLogin);

        final SharedPreferences loginDetails = getSharedPreferences("LoginPref", Context.MODE_PRIVATE);

        // Get login information if saved in SharedPreferences
        if (loginDetails.contains("username")){
            username.setText(loginDetails.getString("username", null));
        }
        if (loginDetails.contains("password")){
            password.setText(loginDetails.getString("password", null));
        }
        if (loginDetails.contains("save")){
            saveDetails.setChecked(loginDetails.getBoolean("save", true));
        }

        // Open Vote screen on Login button click
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pw = password.getText().toString();
                boolean remember = saveDetails.isChecked();
                SharedPreferences.Editor loginPrefEditor = loginDetails.edit();

                if (user == null || user.isEmpty() || pw == null || pw.isEmpty()){
                    Toast.makeText(LoginActivity.this, "You must login before continuing", Toast.LENGTH_SHORT).show();
                }
                else{
                    // Save or delete login details depending on checkbox selection
                    if (remember){
                        loginPrefEditor.putString("username", user);
                        loginPrefEditor.putString("password", pw);
                        loginPrefEditor.putBoolean("save", remember);
                        loginPrefEditor.commit();
                    }
                    else {
                        loginPrefEditor.clear();
                        loginPrefEditor.commit();
                    }

                    Intent loginIntent = new Intent(LoginActivity.this, VoteActivity.class);
                    startActivity(loginIntent);
                }
            }
        });

        // Open online registration form on Register button click
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.trancefix.nl/register.php"));
                startActivity(registerIntent);
            }
        });
    }

}
