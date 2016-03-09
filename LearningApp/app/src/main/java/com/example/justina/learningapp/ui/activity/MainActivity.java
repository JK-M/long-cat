package com.example.justina.learningapp.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.justina.learningapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Opening vote screen on Vote icon tap
        findViewById(R.id.voteButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voteIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(voteIntent);
            }
        });

        // Opening monthly top10 charts screen on Monthly icon tap
        findViewById(R.id.chartsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent viewChartsIntent = new Intent(MainActivity.this, ViewChartsActivity.class);
                startActivity(viewChartsIntent);
            }
        });

        // Opening prizes screen on Prizes icon tap
        findViewById(R.id.prizesButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent viewPrizesIntent = new Intent(MainActivity.this, ViewPrizesActivity.class);
                startActivity(viewPrizesIntent);
            }
        });

        // Opening contact/help screen on Contact icon tap
        findViewById(R.id.contactButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent getHelpIntent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(getHelpIntent);
            }

        });

    }
}
