package com.example.justina.learningapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Vote(View view){
        Intent intent = new Intent(this, Vote.class);
        startActivity(intent);
    }

    public void viewMonthlyCharts(View view){
        Intent intent = new Intent(this, ViewCharts.class);
        startActivity(intent);
    }

    public void getHelp(View view){
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }

    public void viewPrizes(View view){
        Intent intent = new Intent(this, ViewPrizes.class);
        startActivity(intent);
    }

}
