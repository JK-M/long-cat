package com.example.justina.learningapp.ui.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.justina.learningapp.data.adapter.ImageAdapter;
import com.example.justina.learningapp.R;
import com.example.justina.learningapp.ui.fragment.TopChartFragment;

import java.util.HashMap;
import java.util.Map;

public class ViewChartsActivity extends AppCompatActivity {

    public Map<Integer, String> months;{
        months = new HashMap<>();
        months.put( 1,"January");
        months.put( 2,"February");
        months.put( 3,"March");
        months.put( 4,"April");
        months.put( 5,"May");
        months.put( 6,"June");
        months.put( 7,"July");
        months.put( 8,"August");
        months.put( 9,"September");
        months.put(10,"October");
        months.put(11,"November");
        months.put(12,"December");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_charts);

        // Content for the first fragment
        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        // Second fragment
        TopChartFragment chartFragment = new TopChartFragment();
        FragmentManager fManager = getFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();
        fTransaction.add(R.id.chart_activity_layout,chartFragment,"chartFragment");
        fTransaction.commit();

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                int monthNo = position + 1;
                populateTopList(monthNo);
            }
        });
    }

    public void populateTopList(int monthNo) {
        TextView textValue = (TextView) findViewById(R.id.month_chart);
        textValue.setText("TranceFix TOP10 of " + months.get(monthNo));

        Resources topTen = getResources();
        String[] tracks;

        if (monthNo == 1){
            tracks = topTen.getStringArray(R.array.top10_jan);
        }
        else if (monthNo == 2) {
            tracks = topTen.getStringArray(R.array.top10_feb);
        }
        else if (monthNo == 3) {
            tracks = topTen.getStringArray(R.array.top10_mar);
        }
        else {
            tracks = topTen.getStringArray(R.array.top10_apr);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.top10_list, tracks);
        ListView trackList = (ListView) findViewById(R.id.topTenList);
        trackList.setAdapter(adapter);
    }

}
