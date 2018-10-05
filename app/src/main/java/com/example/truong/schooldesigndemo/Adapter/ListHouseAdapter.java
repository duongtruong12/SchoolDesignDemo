package com.example.truong.schooldesigndemo.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.truong.schooldesigndemo.Activity.HomeActivity;
import com.example.truong.schooldesigndemo.R;

public class ListHouseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private static final String TAG = ListHouseAdapter.class.getSimpleName();


    public ListHouseAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_house, parent, false);
        return new ListHouseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int i) {
        ((ListHouseHolder) holder).llTotalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeActivity.class);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    private static class ListHouseHolder extends RecyclerView.ViewHolder {
        private LinearLayout llTotalView;

        private ListHouseHolder(View v) {
            super(v);
            llTotalView = v.findViewById(R.id.ll_total_view);
        }
    }
}