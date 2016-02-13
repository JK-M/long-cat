package com.example.justina.learningapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void registerOnTf(View view){
        Intent registerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.trancefix.nl/register.php"));
        startActivity(registerIntent);
    }

}
