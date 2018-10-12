package com.example.truong.schooldesigndemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.truong.schooldesigndemo.Object.RoomDTO;
import com.example.truong.schooldesigndemo.R;
import com.example.truong.schooldesigndemo.Utils;

import java.util.List;

public class ListRoomAdapter extends RecyclerView.Adapter<ListRoomAdapter.MyViewHolder> {

    private static final String TAG = ListRoomAdapter.class.getSimpleName();
    private List<RoomDTO> data;
    private Context context;
    private OnClickRoom onClickRoom;

    public interface OnClickRoom {
        void onClickRoom(RoomDTO roomDTO);
    }

    public ListRoomAdapter(Context context, List<RoomDTO> data, OnClickRoom onClickRoom) {
        this.data = data;
        this.context = context;
        this.onClickRoom = onClickRoom;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_room, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder h, int position) {
        try {
            final RoomDTO roomDTO = data.get(position);
            String type = roomDTO.getRoom();
            h.tvRoom.setText(Utils.getRoomName(context, type));
            h.imgRoom.setImageDrawable(Utils.getRoomImage(context, type));
            h.tvRoomDevice.setText(Utils.format(context.getResources().getString(R.string.house_device_number), roomDTO.getDeviceNumber()));
            h.llTotalView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickRoom.onClickRoom(roomDTO);
                }
            });
        } catch (Throwable e) {
            Log.e(TAG, "onBindViewHolder: ", e);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout llTotalView;
        private ImageView imgRoom;
        private TextView tvRoom, tvRoomDevice;

        MyViewHolder(View v) {
            super(v);
            llTotalView = v.findViewById(R.id.ll_total_view);
            imgRoom = v.findViewById(R.id.img_room);
            tvRoom = v.findViewById(R.id.tv_room);
            tvRoomDevice = v.findViewById(R.id.tv_room_device);
        }
    }
}