package com.example.justina.learningapp.ui.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.justina.learningapp.R;


public class TopChartFragment extends Fragment implements MonthListFragment.OnMonthSelectedListener {

    public static String FRAGMENT_TAG = TopChartFragment.class.getName();

    private TextView viewTopChartTitle;
    private ListView viewTopChartList;

    private ArrayAdapter<String> adapter;

    public TopChartFragment() {
    }

    public static TopChartFragment newInstance() {
        final TopChartFragment fragment = new TopChartFragment();

        final Bundle arguments = new Bundle();

        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top_chart, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewTopChartTitle = (TextView) view.findViewById(R.id.top_chart_title);
        viewTopChartList = (ListView) view.findViewById(R.id.top_chart_list);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new ArrayAdapter<>(getActivity(), R.layout.top10_list);
        viewTopChartList.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        viewTopChartTitle = null;
        viewTopChartList = null;
    }

    @Override
    public void onMonthSelected(int id, String value) {
        viewTopChartTitle.setText("TranceFix TOP10 of " + value);

        Resources resources = getResources();
        String[] tracks;

        switch (id) {
            case 1:
                tracks = resources.getStringArray(R.array.top10_jan);
                break;
            case 2:
                tracks = resources.getStringArray(R.array.top10_feb);
                break;
            case 3:
                tracks = resources.getStringArray(R.array.top10_mar);
                break;
            default:
                tracks = resources.getStringArray(R.array.top10_apr);
        }

        adapter.clear();
        adapter.addAll(tracks);
    }
}
