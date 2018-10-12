package com.example.truong.schooldesigndemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.truong.schooldesigndemo.Object.HouseDTO;
import com.example.truong.schooldesigndemo.R;
import com.example.truong.schooldesigndemo.Utils;

public class HeaderHomeAdapter extends RecyclerView.Adapter<HeaderHomeAdapter.MyViewHolder> {

    private HouseDTO houseDTO;
    private Context context;

    HeaderHomeAdapter(Context context, HouseDTO data) {
        this.context = context;
        this.houseDTO = data;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_home, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder h, int position) {

        h.tvHouseName.setText(houseDTO.getHouseName());
        h.tvHouseDevice.setText(Utils.format(context.getString(R.string.house_device_number), houseDTO.getDeviceNumber()));
        h.tvHouseDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvHouseName, tvHouseDevice;

        private MyViewHolder(View v) {
            super(v);
            tvHouseDevice = v.findViewById(R.id.tv_house_device);
            tvHouseName = v.findViewById(R.id.tv_house_name);
        }
    }
}
