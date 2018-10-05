package com.example.truong.schooldesigndemo.Activity.PagerTab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.truong.schooldesigndemo.Adapter.ListDeviceAdapter;
import com.example.truong.schooldesigndemo.R;

public class PageFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        ListDeviceAdapter listDeviceAdapter = new ListDeviceAdapter(getActivity());
        RecyclerView recyclerView = view.findViewById(R.id.rc_list_device);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listDeviceAdapter);
        Log.d("", "onCreateView: ");
        return view;
    }
}