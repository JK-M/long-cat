package com.example.justina.learningapp.ui.activity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.justina.learningapp.R;
import com.example.justina.learningapp.data.db.DBHelper;

public class VoteActivity extends AppCompatActivity{

    private EditText fav1, fav2, fav3, fav4, fav5;
    private Button saveButton, modifyButton;
    private String action = "INS";
    private String recID;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        final DBHelper sqliteDb = new DBHelper(this);

        fav1 = (EditText)findViewById(R.id.favourite1);
        fav2 = (EditText)findViewById(R.id.favourite2);
        fav3 = (EditText)findViewById(R.id.favourite3);
        fav4 = (EditText)findViewById(R.id.favourite4);
        fav5 = (EditText)findViewById(R.id.favourite5);

        saveButton = (Button)findViewById(R.id.button_save);
        modifyButton = (Button)findViewById(R.id.button_modify);

        // Retrieve saved info from DB
        Cursor cFavourites = sqliteDb.retrieveData();
        if (cFavourites.getCount() != 0) {
            cFavourites.moveToFirst();
            recID = cFavourites.getString(0);
            fav1.setText(cFavourites.getString(1));
            fav2.setText(cFavourites.getString(2));
            fav3.setText(cFavourites.getString(3));
            fav4.setText(cFavourites.getString(4));
            fav5.setText(cFavourites.getString(5));

            // Disable fields
            disableFields();
        }


        // Save personal top5 on Save button click
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String firstFav = fav1.getText().toString();
                String secondFav = fav2.getText().toString();
                String thirdFav = fav3.getText().toString();
                String fourthFav = fav4.getText().toString();
                String fifthFav = fav5.getText().toString();

                switch (action){
                    case "INS":
                        boolean insertSuccess =
                                sqliteDb.insertData(firstFav, secondFav, thirdFav, fourthFav, fifthFav);

                        if (insertSuccess) {
                            Toast.makeText(VoteActivity.this, "Saved successfully!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(VoteActivity.this, "Save failed.", Toast.LENGTH_SHORT).show();
                        }

                    case "UPD":
                        boolean updateSuccess =
                                sqliteDb.updateData(recID, firstFav, secondFav, thirdFav, fourthFav, fifthFav);
                        if (updateSuccess){
                            Toast.makeText(VoteActivity.this, "Updated successfully!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(VoteActivity.this, "Update failed.", Toast.LENGTH_SHORT).show();
                        }
                }

                // Do not allow changes anymore
                disableFields();
            }
        });

        modifyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Allow changes
                enableFields();
                // Change flag to indicate update
                action = "UPD";
            }
        });
    }

    private void disableFields(){
        fav1.setEnabled(false);
        fav2.setEnabled(false);
        fav3.setEnabled(false);
        fav4.setEnabled(false);
        fav5.setEnabled(false);
        saveButton.setEnabled(false);
    }

    private void enableFields(){
        fav1.setEnabled(true);
        fav2.setEnabled(true);
        fav3.setEnabled(true);
        fav4.setEnabled(true);
        fav5.setEnabled(true);
        saveButton.setEnabled(true);
    }
}
