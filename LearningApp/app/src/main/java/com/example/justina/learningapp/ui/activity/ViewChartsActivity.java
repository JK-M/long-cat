package com.example.justina.learningapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.justina.learningapp.R;
import com.example.justina.learningapp.ui.fragment.MonthListFragment;
import com.example.justina.learningapp.ui.fragment.TopChartFragment;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

public class ViewChartsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_charts);

        // Store all charts in SnappyDB
        try {

            DB chartsDB = DBFactory.open(this, "charts");
            chartsDB.put("mon1", getResources().getStringArray(R.array.top10_jan));
            chartsDB.put("mon2", getResources().getStringArray(R.array.top10_feb));
            chartsDB.put("mon3", getResources().getStringArray(R.array.top10_mar));
            chartsDB.put("mon4", getResources().getStringArray(R.array.top10_apr));
            chartsDB.put("mon5", getResources().getStringArray(R.array.top10_may));
            chartsDB.put("mon6", getResources().getStringArray(R.array.top10_jun));
            chartsDB.put("mon7", getResources().getStringArray(R.array.top10_jul));
            chartsDB.put("mon8", getResources().getStringArray(R.array.top10_aug));
            chartsDB.put("mon9", getResources().getStringArray(R.array.top10_sep));;
            chartsDB.put("mon10", getResources().getStringArray(R.array.top10_oct));
            chartsDB.put("mon11", getResources().getStringArray(R.array.top10_nov));
            chartsDB.put("mon12", getResources().getStringArray(R.array.top10_dec));

            chartsDB.close();

        } catch (SnappydbException e) {
            Log.d("ViewChartsActivity-1", "SnappyDB exception: " + e.getMessage());
        }

        // top charts fragment
        TopChartFragment topChartFragment = TopChartFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.view_charts_top_chart_holder, topChartFragment, TopChartFragment.FRAGMENT_TAG)
                .commitAllowingStateLoss();

        // month list fragment
        MonthListFragment monthListFragment = new MonthListFragment();
        monthListFragment.setOnMonthSelectedListener(topChartFragment);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.view_charts_month_list_holder, monthListFragment, MonthListFragment.FRAGMENT_TAG)
                .commitAllowingStateLoss();
    }

}
