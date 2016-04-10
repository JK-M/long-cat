package com.example.justina.learningapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.justina.learningapp.R;
import com.example.justina.learningapp.data.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MonthListFragment extends Fragment {

    public static String FRAGMENT_TAG = MonthListFragment.class.getName();

    private final List<String> months;

    private GridView viewMonthList;

    private OnMonthSelectedListener onMonthSelectedListener;

    public MonthListFragment() {
        months = new ArrayList<>();

        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monthlist, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewMonthList = (GridView) view.findViewById(R.id.month_list);
        viewMonthList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (onMonthSelectedListener != null) {
                    onMonthSelectedListener.onMonthSelected(position+1, months.get(position));
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageAdapter adapter = new ImageAdapter(getActivity());
        viewMonthList.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        viewMonthList = null;
    }

    public void setOnMonthSelectedListener(OnMonthSelectedListener onMonthSelectedListener) {
        this.onMonthSelectedListener = onMonthSelectedListener;
    }

    public interface OnMonthSelectedListener {
        void onMonthSelected(int id, String value);
    }
}
