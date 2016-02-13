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
        Intent voteIntent = new Intent(this, Login.class);
        startActivity(voteIntent);
    }

    public void viewMonthlyCharts(View view){
        Intent viewChartsIntent = new Intent(this, ViewCharts.class);
        startActivity(viewChartsIntent);
    }

    public void getHelp(View view){
        Intent getHelpIntent = new Intent(this, Contact.class);
        startActivity(getHelpIntent);
    }

    public void viewPrizes(View view){
        Intent viewPrizesIntent = new Intent(this, ViewPrizes.class);
        startActivity(viewPrizesIntent);
    }

}
