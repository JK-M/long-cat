package com.example.justina.learningapp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.justina.learningapp.data.adapter.GalleryAdapter;
import com.example.justina.learningapp.data.entity.Prize;
import com.example.justina.learningapp.R;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class ViewPrizesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_prizes);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(ViewPrizesActivity.this)
                .name("prizes.realm").build();
        Realm realm = Realm.getInstance(realmConfig);

        // Check if prizes are added; if not, add them
        RealmResults<Prize> prizes = realm.where(Prize.class).findAll();

        Log.d("ViewPrizesActivity-1", "Realm: size before is " + prizes.size());
        if (prizes.size() == 0) {

            realm.beginTransaction();

            Prize prize1 = realm.createObject(Prize.class);
            prize1.setPrizeID(1);
            prize1.setImgSource("http://i.imgur.com/72N5KHX.jpg");
            prize1.setCaptionText("Bryan Kearney - This is Kearnage Vol. 1");
            prize1.setReleased("2015.05");

            Prize prize2 = realm.createObject(Prize.class);
            prize2.setPrizeID(2);
            prize2.setImgSource("http://i.imgur.com/tAScaXZ.jpg");
            prize2.setCaptionText("Kyau & Albert - Distant Lights");
            prize2.setReleased("2015.02");

            Prize prize3 = realm.createObject(Prize.class);
            prize3.setPrizeID(3);
            prize3.setImgSource("http://i.imgur.com/c441ZMS.jpg");
            prize3.setCaptionText("Oliver Englafjord - Myrki Heima");
            prize3.setReleased("2015.07");

            Prize prize4 = realm.createObject(Prize.class);
            prize4.setPrizeID(4);
            prize4.setImgSource("http://i.imgur.com/LZ5JHwQ.jpg");
            prize4.setCaptionText("Orkidea - Harmonia");
            prize4.setReleased("2015.06");

            Prize prize5 = realm.createObject(Prize.class);
            prize5.setPrizeID(5);
            prize5.setImgSource("http://i.imgur.com/zeMhAvl.jpg");
            prize5.setCaptionText("RAM - Forever Love");
            prize5.setReleased("2015.06");

            Prize prize6 = realm.createObject(Prize.class);
            prize6.setPrizeID(6);
            prize6.setImgSource("http://i.imgur.com/5sZimVJ.jpg");
            prize6.setCaptionText("Ronski Speed - New Breed");
            prize6.setReleased("2015.05");

            Prize prize7 = realm.createObject(Prize.class);
            prize7.setPrizeID(7);
            prize7.setImgSource("http://i.imgur.com/W6wceQV.jpg");
            prize7.setCaptionText("Sneijder - Everything Changes");
            prize7.setReleased("2015.11");

            Prize prize8 = realm.createObject(Prize.class);
            prize8.setPrizeID(8);
            prize8.setImgSource("http://i.imgur.com/QDgw3Gv.jpg");
            prize8.setCaptionText("Stoneface & Terminal - Be Different");
            prize8.setReleased("2014.07");

            Prize prize9 = realm.createObject(Prize.class);
            prize9.setPrizeID(9);
            prize9.setImgSource("http://i.imgur.com/78ntxEz.jpg");
            prize9.setCaptionText("WSTLNDR - Atmostopia");
            prize9.setReleased("2015.09");

            realm.commitTransaction();
        }
        Log.d("ViewPrizesActivity-2", "Realm: size after is " + prizes.size());
        prizes.sort("released");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.Adapter recViewAdapter = new GalleryAdapter(prizes);
        recyclerView.setAdapter(recViewAdapter);
    }

}