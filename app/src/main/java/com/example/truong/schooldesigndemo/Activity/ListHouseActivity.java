package com.example.truong.schooldesigndemo.Activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.truong.schooldesigndemo.Adapter.ListHouseAdapter;
import com.example.truong.schooldesigndemo.R;

public class ListHouseActivity extends CommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_house);

        installToolbar("List House");
        imgBack.setVisibility(View.GONE);

        RecyclerView recyclerView = findViewById(R.id.rc_list_house);

        ListHouseAdapter listHouseAdapter = new ListHouseAdapter(context);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listHouseAdapter);
    }

    @Override
    public void onBackPressed() {
    }
}
