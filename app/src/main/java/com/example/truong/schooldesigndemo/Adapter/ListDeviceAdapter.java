package com.example.truong.schooldesigndemo.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.truong.schooldesigndemo.R;

public class ListDeviceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private static final String TAG = ListHouseAdapter.class.getSimpleName();


    public ListDeviceAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_device_list, parent, false);
        return new ListDeviceHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int i) {
        ((ListDeviceHolder) holder).tvItemDevice.setText("Thiết bị " + i);
    }


    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    private static class ListDeviceHolder extends RecyclerView.ViewHolder {
        private TextView tvItemDevice;

        private ListDeviceHolder(View v) {
            super(v);
            tvItemDevice = v.findViewById(R.id.tv_item_device);
        }
    }
}