package com.example.justina.learningapp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.justina.learningapp.data.adapter.GalleryAdapter;
import com.example.justina.learningapp.data.entity.Photo;
import com.example.justina.learningapp.R;

public class ViewPrizesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_prizes);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        /*
        // Regular image loading using resources
        Photo photos[] = {
                new Photo(R.drawable.prize_kearnage, "Bryan Kearney - This is Kearnage Vol 1"),
                new Photo(R.drawable.prize_k_and_a, "Kyau & Albert - Distant Lights"),
                new Photo(R.drawable.prize_oliver, "Oliver Englafjord - Myrki Heima"),
                new Photo(R.drawable.prize_orkidea, "Orkidea - Harmonia"),
                new Photo(R.drawable.prize_ram, "RAM - Forever Love"),
                new Photo(R.drawable.prize_ronski, "Ronski Speed - New Breed"),
                new Photo(R.drawable.prize_sneijder, "Sneijder - Everything Changes"),
                new Photo(R.drawable.prize_s_and_t, "Stoneface & Terminal - Be Different"),
                new Photo(R.drawable.prize_wstlndr, "WSTLNDR - Atmostopia")
        };
        */

        // Image loading using Glide
        Photo photos[] = {
                new Photo("http://i.imgur.com/72N5KHX.jpg", "Bryan Kearney - This is Kearnage Vol 1"),
                new Photo("http://i.imgur.com/tAScaXZ.jpg", "Kyau & Albert - Distant Lights"),
                new Photo("http://i.imgur.com/c441ZMS.jpg", "Oliver Englafjord - Myrki Heima"),
                new Photo("http://i.imgur.com/LZ5JHwQ.jpg", "Orkidea - Harmonia"),
                new Photo("http://i.imgur.com/zeMhAvl.jpg", "RAM - Forever Love"),
                new Photo("http://i.imgur.com/5sZimVJ.jpg", "Ronski Speed - New Breed"),
                new Photo("http://i.imgur.com/W6wceQV.jpg", "Sneijder - Everything Changes"),
                new Photo("http://i.imgur.com/QDgw3Gv.jpg", "Stoneface & Terminal - Be Different"),
                new Photo("http://i.imgur.com/78ntxEz.jpg", "WSTLNDR - Atmostopia")
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.Adapter recViewAdapter = new GalleryAdapter(photos);
        recyclerView.setAdapter(recViewAdapter);
    }

}