package com.example.justina.learningapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.justina.learningapp.R;
import com.example.justina.learningapp.ui.fragment.MonthListFragment;
import com.example.justina.learningapp.ui.fragment.TopChartFragment;

public class ViewChartsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_charts);

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
