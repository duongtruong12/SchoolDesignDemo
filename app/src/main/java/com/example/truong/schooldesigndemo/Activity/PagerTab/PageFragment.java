package com.example.truong.schooldesigndemo.Activity.PagerTab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.truong.schooldesigndemo.R;

public class PageFragment extends Fragment {

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        int mPage = 0;
        tvTitle.setText("Fragment #" + mPage);
        return view;
    }
}