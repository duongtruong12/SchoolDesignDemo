package com.example.truong.schooldesigndemo.Activity.PagerTab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.truong.schooldesigndemo.R;
import com.example.truong.schooldesigndemo.Utils;

public class NotificationFragment extends Fragment {
    private TextView tvTest;
    private String onNum = "3", totalNum = "/5", on = " ON";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification, container, false);
        tvTest = v.findViewById(R.id.tv_test);
        String totalText = onNum + totalNum + on;
        tvTest.setText(Utils.setTextCameraOn(totalText, onNum, totalNum, on));
        return v;
    }
}