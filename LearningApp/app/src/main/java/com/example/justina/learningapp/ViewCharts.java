package com.example.justina.learningapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

public class ViewCharts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_charts);

        // Content for the first fragment
        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        // Second fragment
        TopChart chartFragment = new TopChart();
        FragmentManager fManager = getFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();
        fTransaction.add(R.id.chart_activity_layout,chartFragment,"chartFragment");
        fTransaction.commit();

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                int monthNo = position+1;
                TextView textValue = (TextView) findViewById(R.id.month_chart);
                textValue.setText("This is TOP10 of the month No. " + monthNo);
            }
        });

    }
}
