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

        Photo photos[] = {
                new Photo(R.drawable.pr__kearnage, "Bryan Kearney - This is Kearnage Vol 1"),
                new Photo(R.drawable.pr__k_and_a, "Kyau & Albert - Distant Lights"),
                new Photo(R.drawable.pr__oliver, "Oliver Englafjord - Myrki Heima"),
                new Photo(R.drawable.pr__orkidea, "Orkidea - Harmonia"),
                new Photo(R.drawable.pr__ram, "RAM - Forever Love"),
                new Photo(R.drawable.pr__ronski, "Ronski Speed - New Breed"),
                new Photo(R.drawable.pr__sneijder, "Sneijder - Everything Changes"),
                new Photo(R.drawable.pr__s_and_t, "Stoneface & Terminal - Be Different"),
                new Photo(R.drawable.pr__wstlndr, "WSTLNDR - Atmostopia")
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.Adapter recViewAdapter = new GalleryAdapter(photos);
        recyclerView.setAdapter(recViewAdapter);
    }

}