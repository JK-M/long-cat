package com.example.justina.learningapp.ui.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.justina.learningapp.R;

public class VoteActivity extends AppCompatActivity{

    private EditText fav1, fav2, fav3, fav4, fav5;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        fav1 = (EditText)findViewById(R.id.favourite1);
        fav2 = (EditText)findViewById(R.id.favourite2);
        fav3 = (EditText)findViewById(R.id.favourite3);
        fav4 = (EditText)findViewById(R.id.favourite4);
        fav5 = (EditText)findViewById(R.id.favourite5);

        final SharedPreferences votePrefs = getSharedPreferences("VotePref", Context.MODE_PRIVATE);

        // Get top5 saved in SharedPreferences
        if (votePrefs.contains("no1")){
            fav1.setText(votePrefs.getString("no1", null));
        }
        if (votePrefs.contains("no2")){
            fav2.setText(votePrefs.getString("no2", null));
        }
        if (votePrefs.contains("no3")){
            fav3.setText(votePrefs.getString("no3", null));
        }
        if (votePrefs.contains("no4")){
            fav4.setText(votePrefs.getString("no4", null));
        }
        if (votePrefs.contains("no5")){
            fav5.setText(votePrefs.getString("no5", null));
        }

        // Save personal top5 on Save button click using SharedPreferences
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstFav = fav1.getText().toString();
                String secondFav = fav2.getText().toString();
                String thirdFav = fav3.getText().toString();
                String fourthFav = fav4.getText().toString();
                String fifthFav = fav5.getText().toString();

                SharedPreferences.Editor votePrefEditor = votePrefs.edit();
                votePrefEditor.putString("no1", firstFav);
                votePrefEditor.putString("no2", secondFav);
                votePrefEditor.putString("no3", thirdFav);
                votePrefEditor.putString("no4", fourthFav);
                votePrefEditor.putString("no5", fifthFav);
                votePrefEditor.commit();

            }
        });
    }
}
